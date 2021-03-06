package br.com.pbtech.scanner;

import br.com.pbtech.issues.MutantesVivosPosTesteIssueRegister;
import br.com.pbtech.metrics.Totalizador;
import br.com.pbtech.model.ObjectFile;
import br.com.pbtech.model.StrykerJSonModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.config.Configuration;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Languages.JAVASCRIPT_KEY;
import static br.com.pbtech.constantes.Metricas.REPOSITORY_KEY_JS;
import static br.com.pbtech.metrics.MutantMetrics.*;
import static java.util.Arrays.asList;

public class StrykerSensor implements Sensor {
    private final String SENSOR_NAME = "Stryker .Net";
    private final Logger LOG = Loggers.get(getClass());

    private final FileSystem fileSystem;
    private final Configuration settings;

    public StrykerSensor(Configuration configuration, FileSystem fileSystem) {
        this.fileSystem = fileSystem;
        this.settings = configuration;
    }

    @Override
    public void describe(SensorDescriptor sensorDescriptor) {
        sensorDescriptor.name(SENSOR_NAME);
        sensorDescriptor.createIssuesForRuleRepository(REPOSITORY_KEY_JS);
        List<String> languages = asList(JAVASCRIPT_KEY, CSHARP_KEY);
        sensorDescriptor.onlyOnLanguages(languages.stream().toArray(String[]::new));
    }

    public void execute(SensorContext sensorContext) {
        String informedReport = this.settings.get("sonar.javascript.stryker.path").orElse("NAO_INFORMADO");
        if (!informedReport.equals("NAO_INFORMADO")) {

            LOG.info("StrykerSensor Running on {} in {}", sensorContext.project(), sensorContext.fileSystem().baseDir());

            File mutationReport = new File(this.fileSystem.baseDir() + "/" + this.settings.get("sonar.javascript.stryker.path").get());
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                StrykerJSonModel strykerJSonModel = objectMapper.readValue(mutationReport, StrykerJSonModel.class);

                Iterable<InputFile> listaDeArquivos = this.fileSystem.inputFiles(inputFile ->
                        inputFile.filename().contains(".js") && !inputFile.filename().contains(".test")
                );

                for (Map.Entry<String, ObjectFile> reportForFile : strykerJSonModel.getFiles().getAdditionalProperties().entrySet()) {
                    Totalizador totalizador = new Totalizador(reportForFile.getValue().getMutants());

                    for (InputFile file : listaDeArquivos) {
                        if(reportForFile.getKey().contains(file.filename())) {
                            registrarMetricas(sensorContext, file, totalizador);
                            if(totalizador.getTotalOfMutantsSurvived() > 0) {
                                MutantesVivosPosTesteIssueRegister mutantesVivosPosTesteIssueRegister = new MutantesVivosPosTesteIssueRegister();
                                mutantesVivosPosTesteIssueRegister.registrarIssue(sensorContext, file, reportForFile.getValue().getMutants());
                            }

                            LOG.info("Arquivo: {} - Total de mutantes gerados: {} - Total de mutantes mortos: {} - Total de mutantes que sobreviveram: {} - Total de mutantes skipados: {}",
                                    file, totalizador.getTotalOfMutators(), totalizador.getTotalOfMutantsKilled(), totalizador.getTotalOfMutantsSurvived(), totalizador.getTotalOfMutantsSkipped());
                        }
                    }
                }
            } catch (IOException e) {
                LOG.error("Não foi possível realizar o parser do report. {}", e.getMessage());
            }

        } else {
            LOG.info("Relatório de mutação não informado");
        }
    }

    private void registrarMetricas(SensorContext sensorContext, InputFile file, Totalizador totalizador) {
        sensorContext.<Integer>newMeasure().forMetric(MUTANTES_GERADOS).on(file).withValue(totalizador.getTotalOfMutators()).save();
        sensorContext.<Integer>newMeasure().forMetric(MUTANTES_MORTOS).on(file).withValue(totalizador.getTotalOfMutantsKilled()).save();
        sensorContext.<Integer>newMeasure().forMetric(MUTANTES_SOBREVIVENTES).on(file).withValue(totalizador.getTotalOfMutantsSurvived()).save();
        sensorContext.<Integer>newMeasure().forMetric(TRECHOS_NAO_COBERTOS).on(file).withValue(totalizador.getTotalOfNoCoverageMutants()).save();
        sensorContext.<Integer>newMeasure().forMetric(ERROS_IN_RUNTIME).on(file).withValue(totalizador.getTotalOfRuntimeError()).save();
        sensorContext.<Integer>newMeasure().forMetric(ERROS_DE_COMPILACAO).on(file).withValue(totalizador.getTotalOfRuntimeError()).save();
        sensorContext.<Integer>newMeasure().forMetric(MUTANTES_SKIPADOS).on(file).withValue(totalizador.getTotalOfMutantsSkipped()).save();
    }
}

package br.com.pbtech.scanner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sonar.api.batch.fs.*;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.measure.NewMeasure;
import org.sonar.api.config.Configuration;

import java.io.File;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class StrykerSensorTest {

    private static Configuration mockedConfiguration = mock(Configuration.class);
    private static FileSystem mockedFileSystem = mock(FileSystem.class);
    private static FilePredicates mockedFilePredicates = mock(FilePredicates.class);
    private static FilePredicate mockedFilePredicate = mock(FilePredicate.class);
    private static SensorContext mockedSensorContext = mock(SensorContext.class);
    private static InputFile mockedInputFile = mock(InputFile.class);
    private static NewMeasure<Integer> mockedNewMeasure = mock(NewMeasure.class);

    @BeforeAll
    public static void setUp() {
        when(mockedConfiguration.get(anyString())).thenReturn(Optional.of("defaultreport/defaultReport.json"));
        when(mockedFileSystem.baseDir()).thenReturn(new File("src/test/resources"));
        when(mockedFilePredicates.hasLanguage(anyString())).thenReturn(mockedFilePredicate);
        when(mockedFileSystem.predicates()).thenReturn(mockedFilePredicates);
        when(mockedFileSystem.inputFiles(any(FilePredicate.class))).thenReturn(asList(mockedInputFile));
        when(mockedSensorContext.fileSystem()).thenReturn(mockedFileSystem);
        when(mockedSensorContext.fileSystem().predicates()).thenReturn(mockedFilePredicates);
        when(mockedSensorContext.fileSystem().baseDir()).thenReturn(new File("src/test/resources"));
        when(mockedSensorContext.<Integer>newMeasure()).thenReturn(mockedNewMeasure);
        when(mockedNewMeasure.on(any(InputFile.class))).thenReturn(mockedNewMeasure);
        when(mockedNewMeasure.withValue(any(Integer.class))).thenReturn(mockedNewMeasure);
        when(mockedNewMeasure.forMetric(any())).thenReturn(mockedNewMeasure);
    }

    @Test
    public void deveCriarQuatroMetricasParaOArquivoQuePassouPorMutacoes() {

        when((mockedInputFile.filename())).thenReturn("grafo.js");

        StrykerSensor strykerSensor = new StrykerSensor(mockedConfiguration, mockedFileSystem);

        strykerSensor.execute(mockedSensorContext);

        verify(mockedSensorContext, times(4)).newMeasure();
    }

    @Test
    public void naoDeveCriarMetricasParaArquivosDeTest() {

        when((mockedInputFile.filename())).thenReturn("grafo.test.js");

        StrykerSensor strykerSensor = new StrykerSensor(mockedConfiguration, mockedFileSystem);

        strykerSensor.execute(mockedSensorContext);

        verify(mockedSensorContext, never()).newMeasure();
    }

    @Test
    public void naoDeveCriarMetricasParaArquivosQueNaoForamMutados() {

        when((mockedInputFile.filename())).thenReturn("Readme.js");

        StrykerSensor strykerSensor = new StrykerSensor(mockedConfiguration, mockedFileSystem);

        strykerSensor.execute(mockedSensorContext);

        verify(mockedSensorContext, never()).newMeasure();
    }
}

package br.com.pbtech.issues;

import br.com.pbtech.model.Mutant;
import br.com.pbtech.model.MutantStatus;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;

import java.util.List;

public class MutantesVivosPosTesteIssueRegister {

    private final Double GAP_DEFAULT = 10.0;

    public void registrarIssue(SensorContext sensorContext, InputFile file, List<Mutant> mutantes) {

        if (!mutantes.stream().anyMatch(mutante -> mutante.getStatus() == MutantStatus.SURVIVED)){
            throw new NotMutationSurvivedException("Nenhum mutante vivo foi encontrado");
        };

        mutantes.stream().filter(mutant -> mutant.getStatus() == MutantStatus.SURVIVED)
                .forEach(mutant -> {
                    NewIssue newIssue = sensorContext.newIssue()
                            .forRule(mutant.getMutatorName().getRegra().getOperatorJs())
                            .gap(GAP_DEFAULT);

                    NewIssueLocation primaryLocation = newIssue.newLocation()
                            .on(file)
                            .at(file.newRange(mutant.getLocation().getStart().getLine(),
                                    mutant.getLocation().getStart().getColumn() -1,
                                    mutant.getLocation().getEnd().getLine(),
                                    mutant.getLocation().getEnd().getColumn() -1 ))
                            .message(mutant.getMutatorName().getRegra().getRuleName() + " -> Mutação: " + mutant.getReplacement());

                    newIssue.at(primaryLocation)
                            .save();
                });
    }
}

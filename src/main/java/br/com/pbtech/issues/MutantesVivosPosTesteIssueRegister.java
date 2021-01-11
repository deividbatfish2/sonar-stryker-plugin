package br.com.pbtech.issues;

import br.com.pbtech.model.Mutant;
import br.com.pbtech.model.MutantStatus;
import br.com.pbtech.rules.js.mutators.JsRule;
import br.com.pbtech.rules.js.mutators.JsRules;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;

import java.util.List;

public class MutantesVivosPosTesteIssueRegister {

    public void registrarIssue(SensorContext sensorContext, InputFile file, List<Mutant> mutantes) {

        if (!mutantes.stream().anyMatch(mutante -> mutante.getStatus() == MutantStatus.SURVIVED)){
            throw new NotMutationSurvivedException("Nenhum mutante vivo foi encontrado");
        };

        mutantes.stream().filter(mutant -> mutant.getStatus() == MutantStatus.SURVIVED)
                .forEach(mutant -> {
                    JsRule jsRule = JsRules.getRuleByMutatorName(mutant.getMutatorName());

                    NewIssue newIssue = sensorContext.newIssue()
                            .forRule(jsRule.getOperatorJs())
                            .gap(jsRule.getGap());

                    NewIssueLocation primaryLocation = newIssue.newLocation()
                            .on(file)
                            .at(file.newRange(mutant.getLocation().getStart().getLine(),
                                    mutant.getLocation().getStart().getColumn() -1,
                                    mutant.getLocation().getEnd().getLine(),
                                    mutant.getLocation().getEnd().getColumn() -1 ))
                            .message(jsRule.getRuleName() + " -> Mutação: " + mutant.getReplacement());

                    newIssue.at(primaryLocation)
                            .save();
                });
    }
}

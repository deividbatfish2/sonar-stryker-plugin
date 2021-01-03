package br.com.pbtech.metrics;

import br.com.pbtech.model.Mutant;

import java.util.List;

public class Totalizador {
    private Integer totalOfMutantsSurvived;
    private Integer totalOfMutantsKilled;
    private Integer totalOfMutantsSkipped;
    private Integer totalOfMutators;

    public Totalizador(List<Mutant> mutants) {
        totalOfMutantsSurvived = 0;
        totalOfMutantsKilled = 0;
        totalOfMutantsSkipped = 0;
        totalOfMutators = mutants.size();

        for (Mutant mutant : mutants) {
            switch (mutant.getStatus()) {
                case KILLED:
                    totalOfMutantsKilled++;
                    break;
                case SURVIVED:
                    totalOfMutantsSurvived++;
                    break;
                case TIMEOUT:
                    totalOfMutantsSkipped++;
                    break;
            }
        }
    }

    public Integer getTotalOfMutantsSurvived() {
        return totalOfMutantsSurvived;
    }

    public Integer getTotalOfMutators() {
        return totalOfMutators;
    }

    public Integer getTotalOfMutantsKilled() {
        return totalOfMutantsKilled;
    }

    public Integer getTotalOfMutantsSkipped() {
        return totalOfMutantsSkipped;
    }
}

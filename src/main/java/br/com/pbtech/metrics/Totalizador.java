package br.com.pbtech.metrics;

import br.com.pbtech.model.Mutant;

import java.util.List;

public class Totalizador {
    private Integer totalOfMutantsSurvived;
    private Integer totalOfMutantsKilled;
    private Integer totalOfMutantsSkipped;
    private Integer totalOfRuntimeError;
    private Integer totalOfCompileError;
    private Integer totalOfNoCoverageMutants;
    private Integer totalOfMutators;

    public Totalizador(List<Mutant> mutants) {
        totalOfMutantsSurvived = 0;
        totalOfMutantsKilled = 0;
        totalOfMutantsSkipped = 0;
        totalOfCompileError = 0;
        totalOfRuntimeError = 0;
        totalOfNoCoverageMutants = 0;
        totalOfMutators = mutants.size();

        for (Mutant mutant : mutants) {
            switch (mutant.getStatus()) {
                case KILLED:
                    totalOfMutantsKilled++;
                    break;
                case SURVIVED:
                    totalOfMutantsSurvived++;
                    break;
                case COMPILE_ERROR:
                    totalOfCompileError++;
                    break;
                case NO_COVERAGE:
                    totalOfNoCoverageMutants++;
                    break;
                case RUNTIME_ERROR:
                    totalOfRuntimeError++;
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

    public Integer getTotalOfRuntimeError() {
        return totalOfRuntimeError;
    }

    public Integer getTotalOfCompileError() {
        return totalOfCompileError;
    }

    public Integer getTotalOfNoCoverageMutants() {
        return totalOfNoCoverageMutants;
    }
}

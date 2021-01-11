package br.com.pbtech.builder.mutantes;

import br.com.pbtech.model.*;

import java.util.ArrayList;
import java.util.List;

public class MutantesBuilderForTest {
    private List<Mutant> mutantes;

    public static MutantesBuilderForTest criaListaDeMutantes() {
        MutantesBuilderForTest mutantesBuilderForTest = new MutantesBuilderForTest();
        mutantesBuilderForTest.mutantes = new ArrayList<>();
        return mutantesBuilderForTest;
    }

    public MutantesBuilderForTest withASurvivedMutant() {
        Mutant survivedMutant = createMutant("01", MutantStatus.SURVIVED);
        this.mutantes.add(survivedMutant);
        return this;
    }

    public MutantesBuilderForTest withAKilledMutant() {
        Mutant killedMutant = createMutant("02", MutantStatus.KILLED);
        this.mutantes.add(killedMutant);
        return this;
    }

    public MutantesBuilderForTest withATimeoutMutant() {
        Mutant timeoutMutant = createMutant("03", MutantStatus.TIMEOUT);
        this.mutantes.add(timeoutMutant);
        return this;
    }

    public MutantesBuilderForTest withANoCoverageMutant() {
        Mutant noCoverageMutant = createMutant("04", MutantStatus.NO_COVERAGE);
        this.mutantes.add(noCoverageMutant);
        return this;
    }

    public MutantesBuilderForTest withARuntimeErrorMutant() {
        Mutant runtimeErrorMutant = createMutant("05", MutantStatus.RUNTIME_ERROR);
        this.mutantes.add(runtimeErrorMutant);
        return this;
    }

    public MutantesBuilderForTest withACompileErrorMutant() {
        Mutant compileErrorMutant = createMutant("06", MutantStatus.COMPILE_ERROR);
        this.mutantes.add(compileErrorMutant);
        return this;
    }

    public MutantesBuilderForTest withThisMutant(Mutant mutant) {
        this.mutantes.add(mutant);
        return this;
    }

    public List<Mutant> build() {
        return this.mutantes;
    }

    private Mutant createMutant(String id, MutantStatus status) {
        return new Mutant(
                id,
                new Location(
                        new End(1, 10),
                        new Start(1, 10)
                ),
                MutatorName.BlockStatement,
                "{}",
                status,
                "Killed by: Grafo Tests construtor A quantidade mínima de vertices definidos deve ser maior que 1"
        );
    }
}

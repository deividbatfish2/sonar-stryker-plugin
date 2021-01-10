package br.com.pbtech.metrics;

import br.com.pbtech.builder.mutantes.MutantesBuilderForTest;
import br.com.pbtech.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TotalizadorTest {

    @Test
    public void deveTotalizarOsMutantesAPartirDeUmaLista() {

        List<Mutant> mutants = MutantesBuilderForTest.criaListaDeMutantes()
                .withASurvivedMutant()
                .withAKilledMutant()
                .withATimeoutMutant()
                .withACompileErrorMutant()
                .withANoCoverageMutant()
                .withARuntimeErrorMutant()
                .build();

        Totalizador totalizador = new Totalizador(mutants);

        assertThat(totalizador.getTotalOfMutators(), is(6));
        assertThat(totalizador.getTotalOfMutantsKilled(), is(1));
        assertThat(totalizador.getTotalOfMutantsSurvived(), is(1));
        assertThat(totalizador.getTotalOfMutantsSkipped(), is(1));
        assertThat(totalizador.getTotalOfCompileError(), is(1));
        assertThat(totalizador.getTotalOfRuntimeError(), is(1));
        assertThat(totalizador.getTotalOfNoCoverageMutants(), is(1));
    }

    @Test
    public void DeveContabilizarZeroParaStatusNaoInformados() {
        List<Mutant> mutants = MutantesBuilderForTest.criaListaDeMutantes()
                .withASurvivedMutant()
                .build();

        Totalizador totalizador = new Totalizador(mutants);

        assertThat(totalizador.getTotalOfMutators(), is(1));
        assertThat(totalizador.getTotalOfMutantsKilled(), is(0));
        assertThat(totalizador.getTotalOfMutantsSurvived(), is(1));
        assertThat(totalizador.getTotalOfMutantsSkipped(), is(0));
        assertThat(totalizador.getTotalOfCompileError(), is(0));
        assertThat(totalizador.getTotalOfRuntimeError(), is(0));
        assertThat(totalizador.getTotalOfNoCoverageMutants(), is(0));
    }
}

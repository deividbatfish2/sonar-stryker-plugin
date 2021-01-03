package br.com.pbtech.metrics;

import br.com.pbtech.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TotalizadorTest {

    @Test
    public void deveTotalizarOsMutantesAPartirDeUmaLista() {

        List<Mutant> mutants = asList(
                new Mutant(
                        "01",
                        new Location(
                                new End(1, 10),
                                new Start(1, 10)
                        ),
                        "BlockStatement",
                        "{}",
                        MutantStatus.KILLED,
                        "Killed by: Grafo Tests construtor A quantidade mínima de vertices definidos deve ser maior que 1"
                ),
                new Mutant(
                        "02",
                        new Location(
                                new End(1, 10),
                                new Start(1, 10)
                        ),
                        "BlockStatement",
                        "{}",
                        MutantStatus.SURVIVED,
                        "Killed by: Grafo Tests construtor A quantidade mínima de vertices definidos deve ser maior que 1"
                ),
                new Mutant(
                        "03",
                        new Location(
                                new End(1, 10),
                                new Start(1, 10)
                        ),
                        "BlockStatement",
                        "{}",
                        MutantStatus.TIMEOUT,
                        "Killed by: Grafo Tests construtor A quantidade mínima de vertices definidos deve ser maior que 1"
                )
        );

        Totalizador totalizador = new Totalizador(mutants);

        assertThat(totalizador.getTotalOfMutators(), is(3));
        assertThat(totalizador.getTotalOfMutantsKilled(), is(1));
        assertThat(totalizador.getTotalOfMutantsSurvived(), is(1));
        assertThat(totalizador.getTotalOfMutantsSkipped(), is(1));
    }

    @Test
    public void DeveContabilizarZeroParaStatusNaoInformados() {
        List<Mutant> mutants = asList(
                new Mutant(
                        "02",
                        new Location(
                                new End(1, 10),
                                new Start(1, 10)
                        ),
                        "BlockStatement",
                        "{}",
                        MutantStatus.SURVIVED,
                        "Killed by: Grafo Tests construtor A quantidade mínima de vertices definidos deve ser maior que 1"
                )
        );

        Totalizador totalizador = new Totalizador(mutants);

        assertThat(totalizador.getTotalOfMutators(), is(1));
        assertThat(totalizador.getTotalOfMutantsKilled(), is(0));
        assertThat(totalizador.getTotalOfMutantsSurvived(), is(1));
        assertThat(totalizador.getTotalOfMutantsSkipped(), is(0));
    }
}

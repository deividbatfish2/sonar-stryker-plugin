package br.com.pbtech.metrics;

import br.com.pbtech.constantes.Metricas;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.List;

import static java.util.Arrays.asList;

public class MutantsAggregatedMetrics implements Metrics {

    public static final Metric<Integer> MUTANTES_GERADOS = new Metric.Builder("mutantes_gerados", "Mutantes Gerados", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes criados durante a execução dos testes")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> MUTANTES_MORTOS = new Metric.Builder("mutantes_mortos", "Mutantes Mortos", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes mortos durante a execução dos testes")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(true)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> MUTANTES_SOBREVIVENTES = new Metric.Builder("mutantes_sobreviventes", "Mutantes Sobreviventes", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes que sobreviveram a execução dos testes")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(true)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> MUTANTES_SKIPADOS = new Metric.Builder("mutantes_skipados", "Mutantes Skipados", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes que foram abandonados por timeout na execução dos testes")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> TOTAL_DE_MUTANTES = new Metric.Builder("total_de_mutantes", "Total de Mutantes", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes gerados")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    @Override
    public List<Metric> getMetrics() {
        return asList(MUTANTES_GERADOS, MUTANTES_SOBREVIVENTES, MUTANTES_MORTOS, MUTANTES_SKIPADOS, TOTAL_DE_MUTANTES);
    }
}

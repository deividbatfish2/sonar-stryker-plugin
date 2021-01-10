package br.com.pbtech.metrics;

import br.com.pbtech.constantes.Metricas;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import java.util.List;

import static java.util.Arrays.asList;

public class MutantAggregatedMetrics implements Metrics {

    public static final Metric<Integer> TOTAL_DE_MUTANTES_DETECTADOS = new Metric.Builder("total_de_mutantes_detectados", "Total de Mutantes Detectados", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes detectados por teste. Killed + Survived")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> TOTAL_DE_MUTANTES_NAO_DETECTADOS = new Metric.Builder("total_de_mutantes_nao_detectedos", "Total de Mutantes Não Detectados", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes não detectados por testes. Survived + No Coverage")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> TOTAL_DE_MUTANTES_COBERTOS = new Metric.Builder("total_de_mutantes_cobertos", "Total de Mutantes Cobertos", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes cobertos por teste")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> TOTAL_DE_MUTANTES_VALIDOS = new Metric.Builder("total_de_mutantes_validos", "Total de Mutantes Validos", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes validos, ou seja, que não resultaram em erros de compilação ou runtime")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> TOTAL_DE_MUTANTES_INVALIDOS = new Metric.Builder("total_de_mutantes_invalidos", "Total de Mutantes Invalidos", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes invalidos. Runtime Errors + Compile Errors")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> TOTAL_DE_MUTANTES = new Metric.Builder("total_de_mutantes", "Total de Mutantes", Metric.ValueType.INT)
            .setDescription("Exibe o total de mutantes gerados, Validos + Invalidos + Ignorados")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> SCORE_DE_MUTACAO = new Metric.Builder("score_de_mutacao", "Score de Mutacao", Metric.ValueType.INT)
            .setDescription("Exibe o percentual de mutantes mortos. (Detectados / Validos) * 100")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    public static final Metric<Integer> SCORE_DE_MUTACAO_BASEADO_EM_COBERTURA_DE_CODIGO = new Metric.Builder(
            "score_de_mutacao_baseado_em_cobertura_de_codigo", "Score de Mutacao baseado em Cobertura de Codigo", Metric.ValueType.INT
    )
            .setDescription("Exibe o percentual de mutantes mortos baseado nos resultados de cobertura de código. (Detectados / Cobertos) * 100")
            .setDirection(Metric.DIRECTION_BETTER)
            .setQualitative(false)
            .setDomain(Metricas.DOMINIO)
            .create();

    @Override
    public List<Metric> getMetrics() {
        return asList(
                TOTAL_DE_MUTANTES_DETECTADOS,
                TOTAL_DE_MUTANTES_NAO_DETECTADOS,
                TOTAL_DE_MUTANTES_COBERTOS,
                TOTAL_DE_MUTANTES_VALIDOS,
                TOTAL_DE_MUTANTES_INVALIDOS,
                TOTAL_DE_MUTANTES,
                SCORE_DE_MUTACAO,
                SCORE_DE_MUTACAO_BASEADO_EM_COBERTURA_DE_CODIGO
                );
    }
}

package br.com.pbtech.metrics;

import org.sonar.api.ce.measure.Component;
import org.sonar.api.ce.measure.Measure;
import org.sonar.api.ce.measure.MeasureComputer;
import org.sonar.api.utils.log.Logger;
import org.sonar.api.utils.log.Loggers;

import static br.com.pbtech.metrics.MutantMetrics.MUTANTES_GERADOS;

public class TotalizaMutantes implements MeasureComputer {

    private final Logger LOG = Loggers.get(getClass());

    @Override
    public MeasureComputerDefinition define(MeasureComputerDefinitionContext defContext) {
        return defContext
                .newDefinitionBuilder()
                .setOutputMetrics(MUTANTES_GERADOS.getKey())
                .build();
    }

    @Override
    public void compute(MeasureComputerContext context) {
        if (context.getComponent().getType() != Component.Type.FILE) {
            LOG.info("Calcula metricas para pastas: {}", context.getComponent());
            int sum = 0;
            for (Measure child : context.getChildrenMeasures(MUTANTES_GERADOS.key())) {
                LOG.info("Arquivo: {} - Total de mutantes: {}", child, child.getIntValue());
                sum += child.getIntValue();
            }
            context.addMeasure(MUTANTES_GERADOS.key(), sum);
        }
    }
}

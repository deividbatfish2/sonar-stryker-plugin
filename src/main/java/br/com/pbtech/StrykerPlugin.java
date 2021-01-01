package br.com.pbtech;

import br.com.pbtech.metrics.TotalizaMutantes;
import br.com.pbtech.metrics.MutantsAggregatedMetrics;
import br.com.pbtech.rules.StrykerRulesDefinition;
import br.com.pbtech.scanner.StrykerSensor;
import org.sonar.api.Plugin;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.PropertyType;

@Properties({
        @Property(
                key = "sonar.javascript.stryker.path",
                name = "Caminho para arquivo de report",
                description = "Informe o caminho para o report .json gerado pela execução dos testes",
                type = PropertyType.STRING,
                project = true
        ),
        @Property(
                key = "sonar.javascript.stryker.min.mutation.score",
                name = "Percentual mínimo de cobertura aceito para o projeto",
                description = "Caso o score de mutação geral fique a baixo desse valor, uma falha será lançada.",
                type = PropertyType.INTEGER,
                defaultValue = "60",
                project = true
        )
})
public class StrykerPlugin implements Plugin {

    @Override
    public void define(Context context) {
        context.addExtension(StrykerSensor.class);
        context.addExtension(MutantsAggregatedMetrics.class);

        context.addExtension(TotalizaMutantes.class);

        context.addExtension(StrykerRulesDefinition.class);
    }
}

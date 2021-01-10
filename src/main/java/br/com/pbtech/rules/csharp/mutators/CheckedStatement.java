package br.com.pbtech.rules.csharp.mutators;

import br.com.pbtech.rules.DefaultRuleDefinition;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.rule.RulesDefinition;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Metricas.REPOSITORY_KEY_CS;
import static br.com.pbtech.constantes.Metricas.REPOSITORY_NAME;

public class CheckedStatement implements RulesDefinition {

    public static final RuleKey CHECHED_STATEMENT = RuleKey.of(REPOSITORY_KEY_CS, "stryker.rule.cs.checked_statement");

    private final String RULE_NAME = "Stryker - Checked Statement";
    private final String HTML_DESCRIPTION = "Operador Checked Statement: <a href=\"https://stryker-mutator.io/docs/mutation-testing-elements/supported-mutators/#checked-statement\">Saiba mais</a>";

    @Override
    public void define(Context context) {

        NewRepository csharpRepository = context
                .createRepository(REPOSITORY_KEY_CS, CSHARP_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition.createDefinition(csharpRepository, CHECHED_STATEMENT.rule(), RULE_NAME, HTML_DESCRIPTION);

        csharpRepository.done();
    }
}

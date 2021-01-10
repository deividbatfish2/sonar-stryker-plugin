package br.com.pbtech.rules.mutators;

import br.com.pbtech.rules.AbstractMutatorRule;
import br.com.pbtech.rules.DefaultRuleDefinition;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.rule.RulesDefinition;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Languages.JAVASCRIPT_KEY;
import static br.com.pbtech.constantes.Metricas.*;

public class LogicalOperator extends AbstractMutatorRule {

    private final RuleKey LOGICAL_OPERATOR_JS = RuleKey.of(REPOSITORY_KEY_JS, "stryker.rule.js.logical_operator");
    private final RuleKey LOGICAL_OPERATOR_CS = RuleKey.of(REPOSITORY_KEY_CS, "stryker.rule.cs.logical_operator");

    private final String RULE_NAME = "Stryker - Logical Operator";
    private final String HTML_DESCRIPTION = "Operador logical operator: <a href=\"https://stryker-mutator.io/docs/mutation-testing-elements/supported-mutators/#logical-operator\">Saiba mais</a>";

    @Override
    public void define(Context context) {
        NewRepository jsRepository = context
                .createRepository(REPOSITORY_KEY_JS, JAVASCRIPT_KEY)
                .setName(REPOSITORY_NAME);

        NewRepository csharpRepository = context
                .createRepository(REPOSITORY_KEY_CS, CSHARP_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition.createDefinition(jsRepository, LOGICAL_OPERATOR_JS.rule(), RULE_NAME, HTML_DESCRIPTION);

        DefaultRuleDefinition.createDefinition(csharpRepository, LOGICAL_OPERATOR_CS.rule(), RULE_NAME, HTML_DESCRIPTION);

        jsRepository.done();
        csharpRepository.done();
    }

    @Override
    public RuleKey getOperatorJs() {
        return this.LOGICAL_OPERATOR_JS;
    }

    @Override
    public String getRuleName() {
        return this.RULE_NAME;
    }
}

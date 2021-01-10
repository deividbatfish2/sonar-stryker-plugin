package br.com.pbtech.rules.mutators;

import br.com.pbtech.rules.AbstractMutatorRule;
import br.com.pbtech.rules.DefaultRuleDefinition;
import org.sonar.api.rule.RuleKey;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Languages.JAVASCRIPT_KEY;
import static br.com.pbtech.constantes.Metricas.*;

public class ArithmeticOperator extends AbstractMutatorRule {

    private final RuleKey OPERATOR_JS = RuleKey.of(REPOSITORY_KEY_JS, "stryker.rule.js.arithmetic_operator");
    private final RuleKey OPERATOR_CS = RuleKey.of(REPOSITORY_KEY_CS, "stryker.rule.cs.arithmetic_operator");

    private final String RULE_NAME = "Stryker - Arithmetic Operator";
    private final String HTML_DESCRIPTION = "Operador de mutação artimetica: <a href=\"https://stryker-mutator.io/docs/mutation-testing-elements/supported-mutators/#arithmetic-operator\">Saiba mais</a>";

    @Override
    public void define(Context context) {
        NewRepository jsRepository = context
                .createRepository(REPOSITORY_KEY_JS, JAVASCRIPT_KEY)
                .setName(REPOSITORY_NAME);

        NewRepository csharpRepository = context
                .createRepository(REPOSITORY_KEY_CS, CSHARP_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition.createDefinition(jsRepository, OPERATOR_JS.rule(), RULE_NAME, HTML_DESCRIPTION);

        DefaultRuleDefinition.createDefinition(csharpRepository, OPERATOR_CS.rule(), RULE_NAME, HTML_DESCRIPTION);

        jsRepository.done();
        csharpRepository.done();
    }

    @Override
    public RuleKey getOperatorJs() {
        return this.OPERATOR_JS;
    }

    @Override
    public String getRuleName() {
        return this.RULE_NAME;
    }
}

package br.com.pbtech.rules.csharp.mutators;

import br.com.pbtech.rules.DefaultRuleDefinition;
import br.com.pbtech.rules.js.mutators.JsRule;
import org.sonar.api.rule.RuleKey;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Metricas.REPOSITORY_KEY_CS;
import static br.com.pbtech.constantes.Metricas.REPOSITORY_NAME;

public class MethodExpression implements CsRule {

    private final RuleKey METHOD_EXPRESSION = RuleKey.of(REPOSITORY_KEY_CS, "stryker.rule.cs.method_expression");

    private final Double GAP = 10.0;

    private final String RULE_NAME = "Stryker - Method Expression";
    private final String HTML_DESCRIPTION = "Operador Method Expression: <a href=\"https://stryker-mutator.io/docs/mutation-testing-elements/supported-mutators/#method-expression\">Saiba mais</a>";

    @Override
    public void define(Context context) {

        NewRepository csharpRepository = context
                .createRepository(REPOSITORY_KEY_CS, CSHARP_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition.createDefinition(csharpRepository, METHOD_EXPRESSION.rule(), RULE_NAME, HTML_DESCRIPTION);

        csharpRepository.done();
    }

    @Override
    public String getRuleName() {
        return this.RULE_NAME;
    }

    @Override
    public Double getGap() {
        return this.GAP;
    }

    @Override
    public RuleKey getOperatorCs() {
        return this.METHOD_EXPRESSION;
    }
}

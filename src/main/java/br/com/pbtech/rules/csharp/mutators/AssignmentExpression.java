package br.com.pbtech.rules.csharp.mutators;

import br.com.pbtech.rules.DefaultRuleDefinition;
import org.sonar.api.rule.RuleKey;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Metricas.*;

public class AssignmentExpression implements CsRule {

    private final RuleKey ASSIGNMENT_EXPRESSION = RuleKey.of(REPOSITORY_KEY_CS, "stryker.rule.cs.assignment_expression");

    private final Double GAP = 10.0;

    private final String RULE_NAME = "Stryker - Assignment Expression";
    private final String HTML_DESCRIPTION = "Operador de mutação assignment expression: <a href=\"https://stryker-mutator.io/docs/mutation-testing-elements/supported-mutators/#assignment-expression\">Saiba mais</a>";

    @Override
    public void define(Context context) {

        NewRepository csharpRepository = context
                .createRepository(REPOSITORY_KEY_CS, CSHARP_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition.createDefinition(csharpRepository, ASSIGNMENT_EXPRESSION.rule(), RULE_NAME, HTML_DESCRIPTION);

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
        return this.ASSIGNMENT_EXPRESSION;
    }
}

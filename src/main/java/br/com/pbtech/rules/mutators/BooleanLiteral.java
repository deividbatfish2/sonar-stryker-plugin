package br.com.pbtech.rules.mutators;

import br.com.pbtech.rules.AbstractMutatorRule;
import br.com.pbtech.rules.DefaultRuleDefinition;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.rule.RulesDefinition;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Languages.JAVASCRIPT_KEY;
import static br.com.pbtech.constantes.Metricas.*;

public class BooleanLiteral extends AbstractMutatorRule {

    private final RuleKey BOOLEAN_LITERAL_JS = RuleKey.of(REPOSITORY_KEY_JS, "stryker.rule.js.boolean_literal");
    private final RuleKey BOOLEAN_LITERAL_CS = RuleKey.of(REPOSITORY_KEY_CS, "stryker.rule.cs.boolean_literal");

    private final String RULE_NAME = "Stryker - Boolean Literal";
    private final String HTML_DESCRIPTION = "Operador Boolean Literal: <a href=\"https://stryker-mutator.io/docs/mutation-testing-elements/supported-mutators/#boolean-literal\">Saiba mais</a>";

    @Override
    public void define(Context context) {
        NewRepository jsRepository = context
                .createRepository(REPOSITORY_KEY_JS, JAVASCRIPT_KEY)
                .setName(REPOSITORY_NAME);

        NewRepository csharpRepository = context
                .createRepository(REPOSITORY_KEY_CS, CSHARP_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition.createDefinition(jsRepository, BOOLEAN_LITERAL_JS.rule(), RULE_NAME, HTML_DESCRIPTION);

        DefaultRuleDefinition.createDefinition(csharpRepository, BOOLEAN_LITERAL_CS.rule(), RULE_NAME, HTML_DESCRIPTION);

        jsRepository.done();
        csharpRepository.done();
    }

    @Override
    public RuleKey getOperatorJs() {
        return this.BOOLEAN_LITERAL_JS;
    }

    @Override
    public String getRuleName() {
        return this.RULE_NAME;
    }
}

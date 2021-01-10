package br.com.pbtech.rules.mutators;

import br.com.pbtech.rules.DefaultRuleDefinition;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.rule.RulesDefinition;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Languages.JAVASCRIPT_KEY;
import static br.com.pbtech.constantes.Metricas.*;

public class StringLiteral implements RulesDefinition {

    public static final RuleKey STRING_LITERAL_JS = RuleKey.of(REPOSITORY_KEY_JS, "stryker.rule.js.string_literal");
    public static final RuleKey STRING_LITERAL_CS = RuleKey.of(REPOSITORY_KEY_CS, "stryker.rule.cs.string_literal");

    private final String RULE_NAME = "Stryker - String Literal";
    private final String HTML_DESCRIPTION = "Operador String Literal: <a href=\"https://stryker-mutator.io/docs/mutation-testing-elements/supported-mutators/#string-literal\">Saiba mais</a>";

    @Override
    public void define(Context context) {
        NewRepository jsRepository = context
                .createRepository(REPOSITORY_KEY_JS, JAVASCRIPT_KEY)
                .setName(REPOSITORY_NAME);

        NewRepository csharpRepository = context
                .createRepository(REPOSITORY_KEY_CS, CSHARP_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition.createDefinition(jsRepository, STRING_LITERAL_JS.rule(), RULE_NAME, HTML_DESCRIPTION);

        DefaultRuleDefinition.createDefinition(csharpRepository, STRING_LITERAL_CS.rule(), RULE_NAME, HTML_DESCRIPTION);

        jsRepository.done();
        csharpRepository.done();
    }
}

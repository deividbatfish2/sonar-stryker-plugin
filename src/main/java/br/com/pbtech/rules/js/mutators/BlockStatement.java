package br.com.pbtech.rules.js.mutators;

import br.com.pbtech.rules.DefaultRuleDefinition;
import org.sonar.api.rule.RuleKey;

import static br.com.pbtech.constantes.Languages.JAVASCRIPT_KEY;
import static br.com.pbtech.constantes.Metricas.*;

public class BlockStatement implements JsRule {

    private final RuleKey BLOCK_STATEMENT = RuleKey.of(REPOSITORY_KEY_JS, "stryker.rule.js.block_statement");

    private final Double GAP = 10.0;

    private final String RULE_NAME = "Stryker - Block Statement";
    private final String HTML_DESCRIPTION = "Operador de mutação block statement: <a href=\"https://stryker-mutator.io/docs/mutation-testing-elements/supported-mutators/#block-statement\">Saiba mais</a>";

    @Override
    public void define(Context context) {

        NewRepository jsRepository = context
                .createRepository(REPOSITORY_KEY_JS, JAVASCRIPT_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition.createDefinition(jsRepository, BLOCK_STATEMENT.rule(), RULE_NAME, HTML_DESCRIPTION);

        jsRepository.done();
    }

    @Override
    public RuleKey getOperatorJs() {
        return this.BLOCK_STATEMENT;
    }

    @Override
    public String getRuleName() {
        return this.RULE_NAME;
    }

    @Override
    public Double getGap() {
        return this.GAP;
    }
}

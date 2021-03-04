package br.com.pbtech.rules.mutators;

import br.com.pbtech.rules.DefaultRuleDefinition;
import br.com.pbtech.rules.csharp.mutators.CsRule;
import br.com.pbtech.rules.js.mutators.JsRule;
import org.sonar.api.rule.RuleKey;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Languages.JAVASCRIPT_KEY;
import static br.com.pbtech.constantes.Metricas.*;

public class UpdateOperator implements JsRule, CsRule {

    private final RuleKey UPDATE_OPERATOR_JS = RuleKey.of(REPOSITORY_KEY_JS, "stryker.rule.js.update_operator");
    private final RuleKey UPDATE_OPERATOR_CS = RuleKey.of(REPOSITORY_KEY_CS, "stryker.rule.cs.update_operator");

    private final Double GAP = 10.0;

    private final String RULE_NAME = "Stryker - Update Operator";
    private final String PATH_TO_HTML_DESCRIPTION = "br/com/pbtech/rules/UpdateOperator.html";

    @Override
    public void define(Context context) {
        NewRepository jsRepository = context
                .createRepository(REPOSITORY_KEY_JS, JAVASCRIPT_KEY)
                .setName(REPOSITORY_NAME);

        NewRepository csharpRepository = context
                .createRepository(REPOSITORY_KEY_CS, CSHARP_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition defaultRuleDefinition = new DefaultRuleDefinition();

        defaultRuleDefinition.createDefinition(jsRepository, UPDATE_OPERATOR_JS.rule(), RULE_NAME, PATH_TO_HTML_DESCRIPTION);

        defaultRuleDefinition.createDefinition(csharpRepository, UPDATE_OPERATOR_CS.rule(), RULE_NAME, PATH_TO_HTML_DESCRIPTION);

        jsRepository.done();
        csharpRepository.done();
    }

    @Override
    public RuleKey getOperatorJs() {
        return this.UPDATE_OPERATOR_JS;
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
        return this.UPDATE_OPERATOR_CS;
    }
}

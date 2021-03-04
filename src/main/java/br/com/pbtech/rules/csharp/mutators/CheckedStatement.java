package br.com.pbtech.rules.csharp.mutators;

import br.com.pbtech.rules.DefaultRuleDefinition;
import org.sonar.api.rule.RuleKey;

import static br.com.pbtech.constantes.Languages.CSHARP_KEY;
import static br.com.pbtech.constantes.Metricas.REPOSITORY_KEY_CS;
import static br.com.pbtech.constantes.Metricas.REPOSITORY_NAME;

public class CheckedStatement implements CsRule {

    private final RuleKey CHECHED_STATEMENT = RuleKey.of(REPOSITORY_KEY_CS, "stryker.rule.cs.checked_statement");

    private final Double GAP = 10.0;

    private final String RULE_NAME = "Stryker - Checked Statement";
    private final String PATH_TO_HTML_DESCRIPTION = "br/com/pbtech/rules/CheckedStatement.html";

    @Override
    public void define(Context context) {

        NewRepository csharpRepository = context
                .createRepository(REPOSITORY_KEY_CS, CSHARP_KEY)
                .setName(REPOSITORY_NAME);

        DefaultRuleDefinition defaultRuleDefinition = new DefaultRuleDefinition();

        defaultRuleDefinition.createDefinition(csharpRepository, CHECHED_STATEMENT.rule(), RULE_NAME, PATH_TO_HTML_DESCRIPTION);

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
        return this.CHECHED_STATEMENT;
    }
}

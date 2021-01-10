package br.com.pbtech.rules;

import org.sonar.api.rule.RuleKey;
import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rule.Severity;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;

import static br.com.pbtech.constantes.Languages.JAVASCRIPT_KEY;
import static br.com.pbtech.constantes.Metricas.*;

public class StrykerRulesDefinition implements RulesDefinition {

    public static final RuleKey INSUFFICIENT_MUTATION_COVERAGE_RULE_KEY = RuleKey.of(REPOSITORY_KEY_JS,"stryker.insufficient.mutation.coverage");
    public static final RuleKey MUTANTE_VIVO_POS_TESTE = RuleKey.of(REPOSITORY_KEY_JS, "stryker.mutante.vivo.pos.teste");
    private static final String COVERAGE_RATIO_PARAM = "minimumMutationCoverageRatio";

    @Override
    public void define(Context context) {
        NewRepository repository = context
                .createRepository(REPOSITORY_KEY_JS, JAVASCRIPT_KEY)
                .setName(REPOSITORY_NAME);

        repository.createRule(MUTANTE_VIVO_POS_TESTE.rule())
                .setName("Stryker - Mutante vivo pos teste")
                .setHtmlDescription("Um mutante sobrevieu após a execução dos testes.")
                .setStatus(RuleStatus.READY)
                .setSeverity(Severity.MAJOR)
                .setType(RuleType.CODE_SMELL)
                .setTags(TAG_TEST_QUALITY, TAG_TEST_COVERAGE)
                .setActivatedByDefault(true);

        NewRule insufficientMutationCoverageRule = repository.createRule(INSUFFICIENT_MUTATION_COVERAGE_RULE_KEY.rule())
                .setName("Stryker - Insufficient mutation coverage")
                .setHtmlDescription(
                        "An issue is created on a file as soon as the mutation coverage on this file is less than the required threshold. It gives the number of mutations to be covered in order to reach the required threshold.")
                .setStatus(RuleStatus.BETA)
                .setSeverity(Severity.MAJOR)
                .setType(RuleType.BUG)
                .setTags(TAG_TEST_QUALITY, TAG_TEST_COVERAGE)
                .setActivatedByDefault(true);

        insufficientMutationCoverageRule
                .createParam(COVERAGE_RATIO_PARAM)
                .setDefaultValue("65")
                .setDescription("The minimum required mutation coverage ratio");

        repository.done();
    }
}

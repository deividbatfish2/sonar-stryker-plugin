package br.com.pbtech.rules;

import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rule.Severity;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;

public class StrykerRulesDefinition implements RulesDefinition {

    private final String REPOSITORY_NAME = "Stryker";
    private final String REPOSITORY_KEY = "stryker";
    private static final String SURVIVED_MUTANT_RULE_KEY = "stryker.survived.mutant";
    private static final String INSUFFICIENT_MUTATION_COVERAGE_RULE_KEY = "stryker.insufficient.mutation.coverage";
    private static final String COVERAGE_RATIO_PARAM = "minimumMutationCoverageRatio";

    public static final String TAG_TEST_QUALITY = "test-quality";
    public static final String TAG_TEST_COVERAGE = "test-coverage";

    @Override
    public void define(Context context) {
        NewRepository repository = context
                .createRepository(REPOSITORY_KEY, "javascript")
                .setName(REPOSITORY_NAME);

        /*
         * Rule: Survived Mutant
         * Current thinking is that a survived mutant is at least as severe as missing code coverage, probably more severe.
         * Reason for more severe: a test covers this code, so there may be a false sense of security regarding test coverage
         */
        repository.createRule(SURVIVED_MUTANT_RULE_KEY)
                .setName("Survived mutant")
                .setHtmlDescription(
                        "An issue is created when an existing test fails to identify a mutation in the code. For more information, review the <a href=\"http://pitest.org/quickstart/mutators\">PIT documentation</a>")
                .setStatus(RuleStatus.READY)
                .setSeverity(Severity.MAJOR)
                .setType(RuleType.BUG)
                .setTags(TAG_TEST_QUALITY)
                .setActivatedByDefault(false);

        /*
         * Rule: Insufficient Mutation coverage
         */
        NewRule insufficientMutationCoverageRule = repository.createRule(INSUFFICIENT_MUTATION_COVERAGE_RULE_KEY)
                .setName("Insufficient mutation coverage")
                .setHtmlDescription(
                        "An issue is created on a file as soon as the mutation coverage on this file is less than the required threshold. It gives the number of mutations to be covered in order to reach the required threshold.")
                .setStatus(RuleStatus.READY)
                .setSeverity(Severity.MAJOR)
                .setType(RuleType.BUG)
                .setTags(TAG_TEST_QUALITY, TAG_TEST_COVERAGE)
                .setActivatedByDefault(false);

        insufficientMutationCoverageRule
                .createParam(COVERAGE_RATIO_PARAM)
                .setDefaultValue("65")
                .setDescription("The minimum required mutation coverage ratio");

        repository.done();
    }
}

package br.com.pbtech.rules;

import org.sonar.api.rule.RuleStatus;
import org.sonar.api.rule.Severity;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition.NewRepository;

import static br.com.pbtech.constantes.Metricas.TAG_TEST_COVERAGE;
import static br.com.pbtech.constantes.Metricas.TAG_TEST_QUALITY;

public class DefaultRuleDefinition {

    public void createDefinition(NewRepository repository, String rule, String name, String pathToHtmlDescription) {
        repository.createRule(rule)
                .setName(name)
                .setHtmlDescription(getClass().getClassLoader().getResource(pathToHtmlDescription))
                .setStatus(RuleStatus.READY)
                .setSeverity(Severity.MAJOR)
                .setType(RuleType.CODE_SMELL)
                .setTags(TAG_TEST_QUALITY, TAG_TEST_COVERAGE)
                .setActivatedByDefault(true);
    }
}

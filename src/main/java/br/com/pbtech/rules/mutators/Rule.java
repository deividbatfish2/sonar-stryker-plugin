package br.com.pbtech.rules.mutators;

import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.rule.RulesDefinition;

public interface Rule extends RulesDefinition {
    String getRuleName();
    Double getGap();
}

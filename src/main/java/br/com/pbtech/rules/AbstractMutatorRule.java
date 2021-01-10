package br.com.pbtech.rules;

import org.sonar.api.rule.RuleKey;
import org.sonar.api.server.rule.RulesDefinition;

public abstract class AbstractMutatorRule implements RulesDefinition {

    public abstract RuleKey getOperatorJs();
    public abstract String getRuleName();
}

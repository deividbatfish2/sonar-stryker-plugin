package br.com.pbtech.rules.js.mutators;

import br.com.pbtech.rules.mutators.Rule;
import org.sonar.api.rule.RuleKey;

public interface JsRule extends Rule {
    RuleKey getOperatorJs();
}

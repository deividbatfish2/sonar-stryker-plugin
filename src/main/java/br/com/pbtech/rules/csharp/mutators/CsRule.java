package br.com.pbtech.rules.csharp.mutators;

import br.com.pbtech.rules.mutators.Rule;
import org.sonar.api.rule.RuleKey;

public interface CsRule extends Rule {
    RuleKey getOperatorCs();
}

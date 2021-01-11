package br.com.pbtech.rules.csharp.mutators;

import br.com.pbtech.model.MutatorName;
import br.com.pbtech.rules.mutators.*;

import java.util.HashMap;
import java.util.Map;

public class CsRules {
    private static Map<MutatorName, CsRule> mutatorNameRule = new HashMap<MutatorName, CsRule>() {{
        put(MutatorName.ArithmeticOperator, new ArithmeticOperator());
        put(MutatorName.ArrayDeclaration, new ArrayDeclaration());
        put(MutatorName.BooleanLiteral, new BooleanLiteral());
        put(MutatorName.ConditionalExpression, new ConditionalExpression());
        put(MutatorName.EqualityOperator, new EqualityOperator());
        put(MutatorName.LogicalOperator, new LogicalOperator());
        put(MutatorName.StringLiteral, new StringLiteral());
        put(MutatorName.UnaryOperator, new UnaryOperator());
        put(MutatorName.UpdateOperator, new UpdateOperator());
        put(MutatorName.AssignmentExpression, new AssignmentExpression());
        put(MutatorName.CheckedStatement, new CheckedStatement());
        put(MutatorName.MethodExpression, new MethodExpression());
    }};

    public static CsRule getRuleByMutatorName(MutatorName mutatorName) {
        return mutatorNameRule.get(mutatorName);
    }
}

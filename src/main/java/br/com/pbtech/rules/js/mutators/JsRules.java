package br.com.pbtech.rules.js.mutators;

import br.com.pbtech.model.MutatorName;
import br.com.pbtech.rules.mutators.*;

import java.util.HashMap;
import java.util.Map;

public class JsRules {
    private static final Map<MutatorName, JsRule> mutatorNameRule = new HashMap<MutatorName, JsRule>() {{
        put(MutatorName.ArithmeticOperator, new ArithmeticOperator());
        put(MutatorName.ArrayDeclaration, new ArrayDeclaration());
        put(MutatorName.BlockStatement, new BlockStatement());
        put(MutatorName.BooleanLiteral, new BooleanLiteral());
        put(MutatorName.ConditionalExpression, new ConditionalExpression());
        put(MutatorName.EqualityOperator, new EqualityOperator());
        put(MutatorName.LogicalOperator, new LogicalOperator());
        put(MutatorName.StringLiteral, new StringLiteral());
        put(MutatorName.UnaryOperator, new UnaryOperator());
        put(MutatorName.UpdateOperator, new UpdateOperator());
    }};

    public static JsRule getRuleByMutatorName(MutatorName mutatorName) {
        return mutatorNameRule.get(mutatorName);
    }
}

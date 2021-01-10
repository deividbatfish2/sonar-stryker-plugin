package br.com.pbtech.model;

import br.com.pbtech.rules.AbstractMutatorRule;
import br.com.pbtech.rules.csharp.mutators.AssignmentExpression;
import br.com.pbtech.rules.csharp.mutators.CheckedStatement;
import br.com.pbtech.rules.csharp.mutators.MethodExpression;
import br.com.pbtech.rules.js.mutators.BlockStatement;
import br.com.pbtech.rules.mutators.*;
import com.fasterxml.jackson.annotation.JsonValue;
import org.sonar.api.server.rule.RulesDefinition;

public enum MutatorName {

    ArithmeticOperator("ArithmeticOperator", new ArithmeticOperator()),
    ArrayDeclaration("ArrayDeclaration", new ArrayDeclaration()),
    AssignmentExpression("AssignmentExpression", new AssignmentExpression()),
    BlockStatement("BlockStatement", new BlockStatement()),
    BooleanLiteral("BooleanLiteral", new BooleanLiteral()),
    CheckedStatement("CheckedStatement", new CheckedStatement()),
    ConditionalExpression("ConditionalExpression", new ConditionalExpression()),
    EqualityOperator("EqualityOperator", new EqualityOperator()),
    LogicalOperator("LogicalOperator", new LogicalOperator()),
    MethodExpression("MethodExpression", new MethodExpression()),
    StringLiteral("StringLiteral", new StringLiteral()),
    UnaryOperator("UnaryOperator", new UnaryOperator()),
    UpdateOperator("UpdateOperator", new UpdateOperator());

    private String descricao;
    private AbstractMutatorRule regra;

    MutatorName(String descricao, AbstractMutatorRule regra) {
        this.descricao = descricao;
        this.regra = regra;
    }

    @JsonValue
    public String getDescricao() { return this.descricao; }

    public AbstractMutatorRule getRegra() { return this.regra; }
}

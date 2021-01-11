package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MutatorName {

    ArithmeticOperator("ArithmeticOperator"),
    ArrayDeclaration("ArrayDeclaration"),
    AssignmentExpression("AssignmentExpression"),
    BlockStatement("BlockStatement"),
    BooleanLiteral("BooleanLiteral"),
    CheckedStatement("CheckedStatement"),
    ConditionalExpression("ConditionalExpression"),
    EqualityOperator("EqualityOperator"),
    LogicalOperator("LogicalOperator"),
    MethodExpression("MethodExpression"),
    StringLiteral("StringLiteral"),
    UnaryOperator("UnaryOperator"),
    UpdateOperator("UpdateOperator");

    private String descricao;

    MutatorName(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() { return this.descricao; }
}

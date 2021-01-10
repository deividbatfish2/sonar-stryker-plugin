package br.com.pbtech.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.sonar.api.rule.RuleKey;

import static br.com.pbtech.rules.csharp.mutators.AssignmentExpression.ASSIGNMENT_EXPRESSION;
import static br.com.pbtech.rules.csharp.mutators.CheckedStatement.CHECHED_STATEMENT;
import static br.com.pbtech.rules.csharp.mutators.MethodExpression.METHOD_EXPRESSION;
import static br.com.pbtech.rules.js.mutators.BlockStatement.BLOCK_STATEMENT;
import static br.com.pbtech.rules.mutators.ArithmeticOperator.ARITHMETIC_OPERATOR_JS;
import static br.com.pbtech.rules.mutators.ArrayDeclaration.ARRAY_DECLARATION_JS;
import static br.com.pbtech.rules.mutators.BooleanLiteral.BOOLEAN_LITERAL_JS;
import static br.com.pbtech.rules.mutators.ConditionalExpression.CONDITIONAL_EXPRESSION_JS;
import static br.com.pbtech.rules.mutators.EqualityOperator.EQUALITY_OPERATOR_JS;
import static br.com.pbtech.rules.mutators.LogicalOperator.LOGICAL_OPERATOR_JS;
import static br.com.pbtech.rules.mutators.StringLiteral.STRING_LITERAL_JS;
import static br.com.pbtech.rules.mutators.UnaryOperator.UNARY_OPERATOR_JS;
import static br.com.pbtech.rules.mutators.UpdateOperator.UPDATE_OPERATOR_JS;

public enum MutatorName {

    ArithmeticOperator("ArithmeticOperator", ARITHMETIC_OPERATOR_JS),
    ArrayDeclaration("ArrayDeclaration", ARRAY_DECLARATION_JS),
    AssignmentExpression("AssignmentExpression", ASSIGNMENT_EXPRESSION),
    BlockStatement("BlockStatement", BLOCK_STATEMENT),
    BooleanLiteral("BooleanLiteral", BOOLEAN_LITERAL_JS),
    CheckedStatement("CheckedStatement", CHECHED_STATEMENT),
    ConditionalExpression("ConditionalExpression", CONDITIONAL_EXPRESSION_JS),
    EqualityOperator("EqualityOperator", EQUALITY_OPERATOR_JS),
    LogicalOperator("LogicalOperator", LOGICAL_OPERATOR_JS),
    MethodExpression("MethodExpression", METHOD_EXPRESSION),
    StringLiteral("StringLiteral", STRING_LITERAL_JS),
    UnaryOperator("UnaryOperator", UNARY_OPERATOR_JS),
    UpdateOperator("UpdateOperator", UPDATE_OPERATOR_JS);

    private String descricao;
    private RuleKey regra;

    MutatorName(String descricao, RuleKey regra) {
        this.descricao = descricao;
        this.regra = regra;
    }

    @JsonValue
    public String getDescricao() { return this.descricao; }

    public RuleKey getRegra() { return this.regra; }
}

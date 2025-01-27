package refactoring_guru.interpreter.example;

import refactoring_guru.interpreter.example.expressions.AndExpression;
import refactoring_guru.interpreter.example.expressions.Context;
import refactoring_guru.interpreter.example.expressions.OrExpression;
import refactoring_guru.interpreter.example.expressions.VariableExpression;

/**
 * EN: Interpreter Design Pattern
 * 
 * Defines a representation for a grammar as well as a mechanism to understand and act upon the grammar.
 * 
 * RU: Паттерн Интерпретатор
 * 
 * Определяет грамматику простого языка, представляет предложения на этом языке и интерпретирует их.
 */
public class Demo {
    private static void example1() throws Exception {
    	Context context = new Context();

    	VariableExpression a = new VariableExpression("A");
    	VariableExpression b = new VariableExpression("B");
    	VariableExpression c = new VariableExpression("C");

        // example 1:
        // A ∧ (B ∨ C)
    	AndExpression example1 = new AndExpression(
                a,
                new OrExpression(b, c)
        );

        context.assign(a, true);
        context.assign(b, true);
        context.assign(c, false);

        String result = example1.interpret(context) ? "true" : "false";

        System.out.println("boolean expression A ∧ (B ∨ C) = " + result + ", with variables A=true, B=true, C=false");
    }

    private static void example2() throws Exception {
    	Context context = new Context();

    	VariableExpression a = new VariableExpression("A");
    	VariableExpression b = new VariableExpression("B");
    	VariableExpression c = new VariableExpression("C");

        // example 2:
        // B ∨ (A ∧ (B ∨ C))
    	OrExpression example2 = new OrExpression(
                b,
                new AndExpression(
                        a,
                        new OrExpression(b, c)
                )
        );

        context.assign(a, false);
        context.assign(b, false);
        context.assign(c, true);

        String result2 = example2.interpret(context) ? "true" : "false";

        System.out.println("boolean expression B ∨ (A ∧ (B ∨ C)) = " + result2 + ", with variables A=false, B=false, C=true");
    }

    public static void main(String[] args) throws Exception {
        example1();
        example2();
    }
}

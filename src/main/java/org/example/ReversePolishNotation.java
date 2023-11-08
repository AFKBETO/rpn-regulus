package org.example;

import java.util.Stack;

public class ReversePolishNotation {

    private static boolean isANumericValue(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static double evaluateRPN(String expression) throws IllegalArgumentException {
        String[] tokens = expression.split(" ");
        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isANumericValue(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                if (token.equals("sqrt")) {
                    if (stack.size() < 1) {
                        throw new IllegalArgumentException("Error: expecting one argument for `sqrt`, but got less than one argument");
                    }
                    stack.push(Math.sqrt(stack.pop()));
                } else {
                    if (stack.size() < 2) {
                        throw new IllegalArgumentException("Error: expecting two arguments, but got less than two arguments");
                    }
                    switch (token) {
                        case "+":
                            stack.push(stack.pop() + stack.pop());
                            break;
                        case "-":
                            double first = stack.pop();
                            double second = stack.pop();
                            stack.push(second - first);
                            break;
                        case "*":
                            stack.push(stack.pop() * stack.pop());
                            break;
                        default:
                            throw new IllegalArgumentException("Error: Unknown operator " + token);
                    }
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Error: Too many values in the stack");
        }

        return stack.pop();
    }
}
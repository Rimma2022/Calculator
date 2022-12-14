import java.util.Stack;

public class Calculate {
    //0
    public double decide (String Expression){
        String prepared = preparingExpression(Expression);
        String rpn = ExspressionToRPN(prepared);
        return RPNtoAnswer(rpn);
    }
    //1
    private static int getPriority(char token) {
        if (token == '*' || token == '/') {
            return 3;
        } else if (token == '+' || token == '-') {
            return 2;
        } else if (token == '(') {
            return 1;
        } else if (token == ')') {
            return -1;
        } else {
            return 0;
        }
    }
    //2

    private static String ExspressionToRPN(String Expr){
        String current = "";
        int priority;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < Expr.length(); i++) {
            priority = getPriority(Expr.charAt(i));
            if(priority == 0) {
                current += Expr.charAt(i);
            } else if (priority == 1) {
                stack.push(Expr.charAt(i));
            } else if (priority > 1){
                current += " ";
                while (!stack.empty()){
                    if(getPriority(stack.peek()) >= priority){
                        current += stack.pop();
                    } else{
                        break;
                    }
                }
                stack.push(Expr.charAt(i));
            } else if (priority == -1) {
                current += " ";
                while (getPriority(stack.peek()) !=1) {
                    current +=stack.pop();
                }
                stack.pop();
            }
        }
        while (!stack.empty()){
            current += stack.pop();
        }
        return current;
    }


    //3
    private static double RPNtoAnswer(String rpn){
        String operand = new String();
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < rpn.length(); i++) {
            if(rpn.charAt(i) == ' '){
                continue;
            }
            if (getPriority(rpn.charAt(i)) == 0){
                while (rpn.charAt(i) != ' ' && getPriority(rpn.charAt(i)) == 0){
                    operand += rpn.charAt(i++);
                    if (i == rpn.length()){
                        break;
                    }
                }
                stack.push(Double.parseDouble(operand));
                operand = new String();
            }
            if (getPriority(rpn.charAt(i)) > 1) {
                double a = stack.pop();
                double b = stack.pop();
                if (rpn.charAt(i) == '+'){
                    stack.push(b+a);
                } else if (rpn.charAt(i) == '-'){
                    stack.push(b-a);
                } else if (rpn.charAt(i) == '*'){
                    stack.push(b*a);
                } else if (rpn.charAt(i) == '/'){
                    stack.push(b/a);
                }
            }
        }
        return stack.pop();
    }
     //4
    private String preparingExpression (String exspression){
        String preparingExpression = new String();
        for (int token = 0; token < exspression.length(); token++){
            char symbol = exspression.charAt(token);
            if (symbol == '-') {
                if(token == 0){
                    preparingExpression += '0';
                } else if (exspression.charAt(token-1) == '('){
                    preparingExpression += '0';
                }
            }
            preparingExpression += symbol;
        }
        return preparingExpression;
    }

}

import java.util.Stack;

public class Calculate {
    private static int getPriority(char token) {
        if (token == '*' || token == '/') {
            return 3;
        }else if (token == '+' || token == '-'){
            return 2;
        }else if (token == '('){
            return 1;
        } else if (token == ')'){
            return -1;
        }else {
            return 0;
        }
    }

        public static String ExspressionToRPN(String Expr){
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
}

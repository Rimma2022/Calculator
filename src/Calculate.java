public class Calculate {
    public static int getPriority(char token) {
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
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("0. Выход\n1. Рассчитать");
            String X;
            X = bufferedReader.readLine();
            try {
                int x = Integer.parseInt(X);
                switch (x) {
                    case 0: {
                        isTrue = false;
                        break;
                    }
                    case 1: {
                        System.out.println("Введите выражение");
                        String str = bufferedReader.readLine();
                        if (str.isEmpty()){
                            System.out.println("Ничего не ввели!");
                            break;
                        }
//                        else if  (!str.contains("+") || str.contains("-") || str.contains("/") || str.contains("*")){
//                            System.out.println("В выражении отсутствуют математические знаки");
//                            break;
//                        }
                        for (int i = 0; i < str.length(); i++) {
                            if (str.charAt(i) > 39 && str.charAt(i) < 44 || str.charAt(i) == 45 || str.charAt(i) > 46 && str.charAt(i) < 58 || str.charAt(i) == 32) {
                            continue;
                            }
                            else {
                                System.out.println("В выражении присутствует не математический символ: " + str.charAt(i) + " !");
                                break;
                            }
                        }
                        System.out.println(Calculate.ExspressionToRPN(str));
//                        System.out.println(Calculate.RPNtoAnswer(Calculate.ExspressionToRPN(str)));
                        break;
                    }
                    default: {
                        System.out.println("Неверное значение: " + x);
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ничего не ввели или ввели не число! " + ex);
            }
        }


    }
}

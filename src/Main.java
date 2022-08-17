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
//                        Calculate();
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

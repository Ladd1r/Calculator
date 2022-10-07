import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение, состоящее из двух чисел от 1 до 10 " +
                "или от I до X");
        String input = scanner.nextLine();


        String result = calc(input);

        System.out.println(String.format("%1s = %2s", input, result));
    }

    public static String calc(String input) {
        try {
            input = input.replaceAll(" ", "");
            String[] blocks = input.split("[+-/*]");
            if (blocks.length != 2)
                throw new IllegalArgumentException("Неверная форма выражения");

            int n1, n2, result;
            char sign = input.charAt(blocks[0].length());
            String finalResult;

            boolean flag = Roman.check(blocks);
            if (flag) {
                n1 = Roman.toNumber(blocks[0]);
                n2 = Roman.toNumber(blocks[1]);
            } else {
                try {
                    n1 = Integer.parseInt(blocks[0]);
                    n2 = Integer.parseInt(blocks[1]);
                }
                catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Похоже вы ввели римское число, использовав не \"I\" и \"V\"");
                }
            }

            if (n1 > 10 || n1 < 1 || n2 > 10 || n2 < 1)
                throw new IllegalArgumentException("Только числа от 1 до 10, либо только числа от I до X");

            result = calculator(n1, n2, sign);

            if(flag)
                finalResult = Roman.toRoman(result);
            else
                finalResult = Integer.toString(result);

            return finalResult;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
        catch (RuntimeException e){
            throw new IllegalArgumentException("Неверная форма выражения");
        }
    }

    public static int calculator(int n1, int n2, char sign){
        int result = 0;
        switch (sign) {
            case '+': result = n1 + n2; break;
            case '-': result = n1 - n2; break;
            case '*': result = n1 * n2; break;
            case '/': result = n1 / n2; break;
            default: throw new IllegalArgumentException("Неверный оператор");
        }
        return result;
    }




}
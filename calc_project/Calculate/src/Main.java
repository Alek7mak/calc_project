import java.util.Scanner;

public class Main {

    private static Scanner scanner;//сканер

    public static void main(String[] args) {
        scanner = new Scanner(System.in);//объявляем сканер

        String temp = scanner.nextLine();//считываем строку

        //делим строку на два числа и оператор
        String x = temp.split(" ")[0];
        String op = temp.split(" ")[1];
        String y = temp.split(" ")[2];


        if (TranslateNum.checkNum(x) && TranslateNum.checkNum(y)) {//проверка что это арабские числа
            double finalNum = Сalculator.calculator(Integer.parseInt(x), op, Integer.parseInt(y));//выполняем операцию

            if(finalNum == -300) {//проверка на существующий оператор
                throw  new NullPointerException("Invalid input");//исключение
            }

            System.out.println(finalNum);//вывод значения
        } else if (!TranslateNum.checkNum(x) && !TranslateNum.checkNum(y)) {//проверка на римские числа
            int xInt = TranslateNum.romanToArabic(x);//преводим в арабские
            int yInt = TranslateNum.romanToArabic(y);

            double finalNum = Сalculator.calculator(xInt, op, yInt);

            if(finalNum == -300) {
                throw  new NullPointerException("Invalid input");
            }

            String num = TranslateNum.arabicToRoman((int) finalNum);//переводим в римские

            System.out.println(num);
        } else {
            //error
            throw  new NullPointerException("Invalid input");//неверный ввод чисел или вообще не правильная строка
        }
    }
}

public class Сalculator {//калькулятор

    public static double calculator(int x, String op, int y) {//статический метод калькулятора
        //статический метод позволяет не объявлять объект в других классах

        double num = switch (op) {//свитч для определения опирации
            case "+" -> x + y;
            case "-" -> x - y;
            case "/" -> x / y;
            case "*" -> x * y;
            //если не существующий опиратор
            default -> -300;
        };//переменая для итогово значения

        return num;//возвращаем значение
    }
}

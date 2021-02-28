import java.util.List;

public class TranslateNum {//переводчик чисел

    public static int romanToArabic(String input) {//из римских в арабские
        String romanNumeral = input.toUpperCase();//делаем верхний регистор
        int result = 0;//переменная для результата

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();//сортируем значение

        int i = 0;

        //преобразовыем в арабские
        while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }//исключение если нет такого числа

        return result;//возрващаем значение
    }

    public static String arabicToRoman(int number) {//из арабских в римские
        if ((number <= 0) || (number > 4000)) {//проверяем область значений
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();//сортируем число

        int i = 0;
        StringBuilder sb = new StringBuilder();//стрин билдер, чтобы создать строку

        //преобразовываем в римские
        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    public static boolean checkNum(String num) {//проверка какое число, арабское или римкое
        //через конструкцию try catch
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

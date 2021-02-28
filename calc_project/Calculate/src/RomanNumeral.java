import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum RomanNumeral {//модель для римских чисел(используется в переводе)
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);//готовые значения

    private int value;

    RomanNumeral(int value) {//конструктор который принимает значение
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumeral> getReverseSortedValues() {//сортировка листа для числа
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }
}

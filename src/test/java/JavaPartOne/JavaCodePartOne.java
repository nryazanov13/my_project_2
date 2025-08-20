package JavaPartOne;

public class JavaCodePartOne {

    public static void main(String[] args) {

        int firstNumberInt = 10;
        int secondNumberInt = 5;
        double thirdNumberDouble = 3.0;

        // 0) применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int
        System.out.println("This is addition - " + (firstNumberInt + secondNumberInt));
        System.out.println("This is subtraction - " + (firstNumberInt - secondNumberInt));
        System.out.println("This is multiply - " + (firstNumberInt * secondNumberInt));
        System.out.println("This is division - " + (firstNumberInt / secondNumberInt));

        //1) применить несколько арифметических операций над int и double в одном выражении
        System.out.println("int / double - " + (firstNumberInt / thirdNumberDouble));
        System.out.println("int * double - " + (firstNumberInt * thirdNumberDouble));
        System.out.println("int + double - " + (firstNumberInt + thirdNumberDouble));
        System.out.println("int - double - " + (firstNumberInt - thirdNumberDouble));

        //2) применить несколько логических операций ( < , >, >=, <= )
        System.out.println("int > double - " + (firstNumberInt > thirdNumberDouble));
        System.out.println("int < double - " + (firstNumberInt < thirdNumberDouble));
        System.out.println("int >= double - " + (firstNumberInt >= thirdNumberDouble));
        System.out.println("int <= double - " + (firstNumberInt <= thirdNumberDouble));

        //3) прочитать про диапазоны типов данных для вещественных / чисел с плавающей точкой (какие максимальные и минимальные значения есть, как их получить) и переполнение
        // Переполнение - это результат арифметической операции превышает максимальное значение,
        // которое может хранить тип данных.
        System.out.println("The minimum number of int - " + Integer.MIN_VALUE);
        System.out.println("The maximum number of int - " + Integer.MAX_VALUE);
        System.out.println("The minimum number of double - " + Double.MIN_VALUE);
        System.out.println("The maximum number of double - " + Double.MAX_VALUE);

        //4) получить переполнение при арифметической операции

        //Переполнения для максимального Integer
        int maxInt = Integer.MAX_VALUE;
        int overflowed = maxInt + 1;
        System.out.println("Integer.MAX_VALUE + 1 = " + overflowed); // -2147483648

        //Переполнения для минимального Integer
        int minInt = Integer.MIN_VALUE;
        int underflowed = minInt - 1;
        System.out.println("Integer.MIN_VALUE - 1 = " + underflowed); // 2147483647

        // Переполнения для максимального числа с плавающей точкой
        double maxDouble = Double.MAX_VALUE;
        double overflowedDouble = maxDouble * 2;
        System.out.println("Double.MAX_VALUE * 2 = " + overflowedDouble); // Infinity

        // Переполнения для минимального числа с плавающей точкой
        double negativeOverflow = -maxDouble * 2;
        System.out.println("-Double.MAX_VALUE * 2 = " + negativeOverflow); // -Infinity

    }


}

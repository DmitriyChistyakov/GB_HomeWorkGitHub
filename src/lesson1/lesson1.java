package lesson1;

public class lesson1 {
    public static void main(String[] args) {

        //2. Создать переменные всех пройденных типов данных и инициализировать их значения.
        // Примитивные типы данных
        byte a1 = -128 ;
        short a2 = -32767 ;
        int a3 = 2147483646 ;
        long a4 = 9222222222222l ;
        float a5 = 14.05f ;
        double a6 = 14.05d ;
        char a7 = 'W';
        // Логический тип данных
        boolean a8 = false ;
        //Ссылочный тип данных
        String name = "Петя" ;

        // Вывод переменных (не предусмотрено заданием)
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
        System.out.println(a6);
        System.out.println(a7);
        System.out.println(a8);
        System.out.println(name);

        //3. Для вызова метода вычисляющего выражение a*(b+(c/d)) передаются аргументы типа float
        // результат возвращается

        evaluateExpression(2.1f,5.2f,3.3f,1.1f);



        //4. Для вызова метода передается два аргумента типа int
        // метод проверят условие, что сумма двух целых чисел >=10 и <=20
        // результат сравнения возвращается
        compareSumm(10,7) ;

        // 5. Для вызова метода передаем в него целое число
        // метод определяет положительное или отрицательное число
        // результат выводится в консоль
        isNegativeOrPositive( 12) ;

        // 6. Для вызова метода  передаем в него целое число
        // метод определяет отрицательное ли число
        // если отрицательное - возвращает true, иначе - false/
        isNegative(15) ;

        // 7. Для вызова меода передаем строку (имя)
        // метод выводит в консоль приветствие
        greeting("Семен" ) ;

        // 8. Для вызова метода передаем в него целое число - год
        // метод определяет високосный год или нет
        // результат выводится в консоль
        isLeapYear(1104) ;
    }
    public static float evaluateExpression (float a, float b, float c, float d) {
        float rez = (a*(b+(c/d))) ;
//        System.out.println(rez); /*вывод  в консоль, не предусмотрено заданием*/
        return (rez);
    }
    public static  boolean compareSumm (int c, int d) {
        int sum = c + d ;
        boolean bb =  (10<= sum & sum <=20);
//        System.out.println(bb); /*вывод вконсоль, не предусмотрено заданием*/
        return bb ;
    }

    public static void isNegativeOrPositive(int f) {
        if (f >= 0) {
            System.out.println("Положительное");
        }
        else {
            System.out.println("Отрицательное");
        }
    }

    public static boolean isNegative (int g){
        if (g < 0) {
//            System.out.println("true"); /*вывод вконсоль, не предусмотрено заданием*/
            return true;
        }
        {
//            System.out.println("false"); /*вывод вконсоль, не предусмотрено заданием*/
            return false;
        }

    }

    public static void greeting (String name1) {
        System.out.println("Привет, " + name1+"!");
    }

    public static void isLeapYear (int year) {
        int four = year % 4 ;
        int hundred = year % 100 ;
        int fourHundred = year % 400 ;
        if (four != 0){ // проверка деления на 4
            System.out.println("Не високосный!");
        } else if ( fourHundred == 0) { // проверка деления на 400
            System.out.println("Високосный1");
        } else if (hundred == 0){ // Проверка деления на 100
            System.out.println("Не високосный") ;
        } else System.out.println("Високосный2"); // все что делится на 4, не делится на 100 и 400
// чувствую, что последнее задание можно проще решить. Поизучаю логические операторы.

    }
}

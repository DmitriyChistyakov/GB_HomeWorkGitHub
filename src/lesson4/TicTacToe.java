package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    /*  1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
        2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
        3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
        Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
        4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока. */
    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {


        char[][] field = createField();

        drawField(field);
        while (true) {
            if (!checkNextPlayerMove(field)) {
                return;
            }
            if (!checkNextAIMove(field)) {
                return;
            }
        }
    }

    static boolean checkNextAIMove(char[][] field) {
        doAiMove(field);
        System.out.println("А так сходил AI:");
        drawField(field);
        return isNextMoveAvailable(field, '0', "Вы старались, но AI победил.");
    }

    static boolean checkNextPlayerMove(char[][] field) {
        doPlayerMove(field);
        System.out.println("Это ваш ход:");
        drawField(field);
        return isNextMoveAvailable(field, 'X', "Поздравляю!!!! Вы победили!!!!!!");
    }

    static boolean isNextMoveAvailable(char[][] field, char sign, String winMessage) {
        if (isWin(field, sign)) { //В исходном коде заменил местами проверку на победу и ничью, иначе был БаГ.
            System.out.println(winMessage);
            return false;
        }
        if (isDraw(field)) {
            System.out.println("Игра окончена! НИЧЬЯ!");
            return false;
        }
        return true;
    }

    static boolean isWin(char[][] field, char sign) {
        /** Чувствую, что можно упростить данный метод...но пока не понимаю как */

        int numberOfChips = 4; // количество фишек в ряд для выйгрыша, думал получится универсальный метод проверки создать
        /**Проверка победы по строкам   */
        for (int i = 0; i < field.length; i++) {  //выбор строки
            int counting = 0;
            for (int j = 0; j < field[i].length - 1; j++) {  //пробежка по строке
                if (field[i][j] == field[i][j + 1] && field[i][j] == sign) {
                    ++counting;
                } else counting = 0;
                if (counting == numberOfChips - 1) {
                    return true;
                }
            }
        }
        /** проверка по столбикам*/
        for (int i = 0; i < field.length; i++) {  //выбор столбика
            int counting = 0;
            for (int j = 0; j < field[i].length - 1; j++) {  //пробежка построчно по столбику
                if (field[j][i] == field[j + 1][i] && field[j][i] == sign) {
                    ++counting;
                } else counting = 0;
                if (counting == numberOfChips - 1) {
                    return true;
                }
            }
        }
        /** Проверка диагонали 0-0/4-4*/
        int diagonal1 = 0;
        for (int i = 0; i < field.length - 1; i++) {
            if (field[i][i] == field[i + 1][i + 1] && field[i][i] == sign) {
                ++diagonal1;
            } else diagonal1 = 0;
        }
        if (diagonal1 == numberOfChips - 1) {
            return true;
        }
        /**Проверка диагонали 4-0/0-4  */
        int diagonal2 = 0;
        for (int j = 0, i = field.length - 1; j < field.length - 1 && i > 0; j++, i--) {
            if (field[i][j] == field[i - 1][j + 1] && field[i][j] == sign) {
                ++diagonal2;
            } else diagonal2 = 0;
            if (diagonal2 == numberOfChips - 1) {
                return true;
            }
        }
        /**Проверка диагонали 0-1/3-4*/
        int diagonal3 = 0;
        for (int i = 0; i < 3; i++) {
            if (field[i][i + 1] == field[i + 1][i + 2] && field[i][i] == sign) {
                ++diagonal3;
            } else diagonal3 = 0;
            if (diagonal3 == numberOfChips - 1) {
                return true;
            }
        }
        /**Проверка диагонали 1-0/4-3*/
        int diagonal4 = 0;
        for (int i = 1; i < 4; i++) {
            if (field[i][i - 1] == field[i + 1][i] && field[i][i] == sign) {
                ++diagonal4;
            } else diagonal4 = 0;
            if (diagonal4 == numberOfChips - 1) {
                return true;
            }
        }
        /**Проверка диагонали 3-0/0-3*/
        int diagonal5 = 0;
        for (int j = 0, i = 3; j < 3 && i > 0; j++, i--) {
            if (field[i][j] == field[i - 1][j + 1] && field[i][j] == sign) {
                ++diagonal5;
            } else diagonal5 = 0;
            if (diagonal5 == numberOfChips - 1) {
                return true;
            }
        }

        /**Проверка диагонали 4-1/1-4*/
        int diagonal6 = 0;
        for (int i = 4, j = 1; i > 0 && j < 4; i--, j++) {
            if (field[i][j] == field[i - 1][j + 1] && field[i][j] == sign) {
                ++diagonal6;
            } else diagonal6 = 0;
            if (diagonal6 == numberOfChips - 1) {
                return true;
            }
        }

        return false;
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    static void doAiMove(char[][] field) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field.length);
        } while (isCellFree(field, x, y));
        field[x][y] = '0';
    }

    static char[][] createField() {
        return new char[][]{
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},

        };
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void doPlayerMove(char[][] field) { //ход игрока
        Scanner scanner = new Scanner(System.in);
        int x, y;
        do {
            x = checkCoordinateRange(scanner, "строки", field.length);
            y = checkCoordinateRange(scanner, "столбца", field.length);
        } while (isCellFree(field, x, y));

        field[x][y] = 'X';
    }

    static int checkCoordinateRange(Scanner scanner, String coordName, int maximumCoordinate) {
        int val;
        do {
            System.out.printf("Введите номер %s от 1 до %s...%n", coordName, maximumCoordinate);
            val = scanner.nextInt() - 1;
        } while (val < 0 || val > maximumCoordinate - 1);
        return val;
    }

    static boolean isCellFree(char[][] field, int x, int y) { // Проверка занятости поля
        return field[x][y] != '-';
    }
}
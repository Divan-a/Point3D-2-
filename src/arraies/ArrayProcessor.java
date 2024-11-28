package arraies;

import java.util.Scanner;

public class ArrayProcessor {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива: ");
        int size = in.nextInt();
        int[] arrays;
        arrays = new int[size];



        input(arrays, size);
        output(arrays);
        summ(arrays);
        honCounter(arrays);
        elInRange(arrays);
        allPositiv(arrays);
        revers(arrays);
        output(arrays);

    }


    public static int[] input(int arrays[], int size) {
        if (size < 0) {
            Scanner in = new Scanner(System.in);
            while (size < 0) {
                System.out.println("Ошибка! Размер должен быть неотрицательным.");
                size = in.nextInt();
            }
        }

        Scanner in = new Scanner(System.in);
        for (int i = 0; i < arrays.length; i++) {
            System.out.printf("Введиет %d элемент: ", i);
            arrays[i] = in.nextInt();
        }
        return arrays;
    }

    public static void output(int arrays[]) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
    }

    public static void summ(int arrays[]) {
        int sum = 0;
        for (int i = 0; i < arrays.length; i++) {
            sum += arrays[i];
        }
        System.out.printf("Сумма элементов массива: %d\n", sum);
    }

    public static void honCounter(int arrays[]) {
        int counter = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] % 2 == 0) {
                counter++;
            }
        }
        System.out.printf("Колличество четных чисел в массиве: %d\n", counter);
    }

    public static void elInRange(int arrays[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите нижнюю границу: ");
        int a = in.nextInt();

        System.out.println("Введите верхнюю границу");
        int b = in.nextInt();

        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int counter = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] >= a & arrays[i] <= b) {
                counter++;
            }
        }
        System.out.printf("Колличество элементов массива лежащих в промежутке от %d, до %d: %d\n", a, b, counter);
    }

    public static void allPositiv(int arrays[]) {
        boolean indicate = true;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] < 0) {
                indicate = false;
                break;
            }
        }
        if (indicate) {
            System.out.println("Все элементы массива положительны");
        } else {
            System.out.println("Не все элементы массива положительны");
        }
    }

    public static int[] revers(int arrays[]) {

        for (int i = 0; i < arrays.length / 2; i++) {
            int tmp = arrays[i];
            arrays[i] = arrays[arrays.length - i - 1];
            arrays[arrays.length - i - 1] = tmp;
        }

        return arrays;
    }
}

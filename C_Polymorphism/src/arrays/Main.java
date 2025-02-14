package C_Polymorphism.src.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] genArray = (getRandomArray(5));
        System.out.println("Generated Array: " + Arrays.toString(genArray));
        System.out.println("Sum of elements: " + Arrays.toString(sortLargest(genArray)));

        System.out.println("Reversed Array:- "+Arrays.toString(reverseArray(genArray)));


    }



    private static int[] sortLargest(int[] genArray) {
        Arrays.sort(genArray);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int i = 0; i < genArray.length - 1; i++) {
                if (genArray[i] < genArray[i + 1]) {
                    temp = genArray[i];
                    genArray[i] = genArray[i + 1];
                    genArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return genArray;
    }

    public static int[] getRandomArray(int len) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            System.out.println("Enter a num between 0-99: ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int findSmallest(int[] array) {
        int smallest = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }
    private static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        int end = array.length-1;
        for (int el: array) {
            reversedArray[end--] = el;
        }

        return reversedArray;

    }
}

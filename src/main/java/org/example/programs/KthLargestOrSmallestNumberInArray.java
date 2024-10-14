package org.example.programs;

import java.util.Arrays;

public class KthLargestOrSmallestNumberInArray {

    private static void printArray(String arrayType, int[] arr) {
        System.out.println(arrayType + ":" + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] givenArray = {2, 9, 3, 7};
        printArray("Original Array", givenArray);
//        printArray("Array sorted Ascending", sortArrayAscending(givenArray));
//        printArray("Array sorted Descending", sortArrayDescending(givenArray));
//        kthLargestElementOfArray(2, givenArray);
        kthSmallestElementOfArray(3, givenArray);
    }

    public static int[] sortArrayAscending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("i array iterating for index:" + i);
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("j array iterating for index:" + j);
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] sortArrayDescending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("i array iterating for index:" + i);
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("j array iterating for index:" + j);
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void kthLargestElementOfArray(int kthCount, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("i array iterating for index:" + i);
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("j array iterating for index:" + j);
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if (i == (kthCount - 1)) {
                System.out.println(kthCount + " largest element of the array is " + arr[i]);
                break;
            }
        }
    }

    public static void kthSmallestElementOfArray(int kthCount, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println("i array iterating for index:" + i);
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println("j array iterating for index:" + j);
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if (i == (kthCount - 1)) {
                System.out.println(kthCount + " smallest element of the array is " + arr[i]);
                break;
            }
        }
    }

}

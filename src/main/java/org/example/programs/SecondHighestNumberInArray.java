package org.example.programs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SecondHighestNumberInArray {
    private static int largest = 0;
    private static int secondLargest = 0;

    public static void main(String[] args) {
        int arr[] = {100, 14, 46, 47, 94, 94, 52, 86, 36, 94, 89};


        System.out.println("Given array is " + Arrays.toString(arr));
        IntStream.range(0, arr.length - 1).forEach(
                i -> {

                    if (arr[i] > largest) {
                        secondLargest = largest;
                        largest = arr[i];
                    } else if (arr[i] > secondLargest) {
                        secondLargest = arr[i];
                    }
                }
        );
        System.out.println("\nSecond largest number is:" + secondLargest);
        System.out.println("Largest Number is: " + largest);
    }
}

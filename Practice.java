import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Collections;
import java.lang.*;



class Practice {

    public static void main(String[] args) {
        int[] val = new int[1200];
        for (int i = 0; i < val.length; i++) {
            val[i] = new Random().nextInt(10000);

        }
        Arrays.sort(val);

        for (int i = 0; i < val.length; i++) {
            val[i] = val[i] * (-1);
        }

        Arrays.sort(val);

        for (int i = 0; i < val.length; i++) {
            val[i] = val[i] * (-1);
        }


        long startTime = System.nanoTime();

        BubbleSort ob = new BubbleSort();
        ob.bubbleSort(val);

        SelectionSort ob = new SelectionSort();
        ob.sort(val);

        InsertionSort ob = new InsertionSort();
        ob.sort(val);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Time in Microseconds : " + totalTime / 1000);

        System.out.println("After Sorting");

        for (int i = 0; i < val.length; i++) {
            System.out.print(val[i] + ", ");
        }




    }
}


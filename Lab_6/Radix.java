import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Collections;
import java.lang.*;


import java.io.*;
import java.util.*;

class Radix {

    //Getting maximum value
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);


        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;


        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void radixsort(int arr[], int n)
    {

        int m = getMax(arr, n);

        // Do counting sort for every digit
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

//    Printing array
    static void print(int arr[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }



    public static void main (String[] args)
    {

        int[] val = new int[10000];
        for (int i = 0; i < val.length; i++) {
            val[i] = new Random().nextInt(100000);

        }

        int n = val.length;

        long startTime = System.nanoTime();

        radixsort(val, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Time in Microseconds : " + totalTime / 1000);


//        print(val, n);
    }
}


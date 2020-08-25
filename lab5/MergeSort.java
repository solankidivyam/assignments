import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Collections;
import java.lang.*;

class MergeSort {

    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        //Temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        //Copying temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        //Merging two arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //Remaining of L[]
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        //Remaining of R[]
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            //Middle element
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            //Merging sorted halves
            merge(arr, l, m, r);
        }
    }

    //Prining array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String args[])
    {

        int[] val = new int[10000];
        for (int i = 0; i < val.length; i++) {
            val[i] = new Random().nextInt(100000);
        }

        int n = val.length;


        Arrays.sort(val);

        for (int i = 0; i < val.length; i++) {
            val[i] = val[i] * (-1);
        }

        Arrays.sort(val);

        for (int i = 0; i < val.length; i++) {
            val[i] = val[i] * (-1);
        }
//
//        printArray(val);

        long startTime = System.nanoTime();

        MergeSort ob = new MergeSort();
        ob.sort(val, 0, val.length - 1);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Time in Microseconds : " + totalTime / 1000);


//        System.out.println("\nSorted array");
//        printArray(val);
    }
}

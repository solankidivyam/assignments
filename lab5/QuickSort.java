import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Collections;
import java.lang.*;

class QuickSort
{
   //Last element as the pivot
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }


        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }


    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    public static void main(String args[])
    {
        int[] val = new int[10000];
        for (int i = 0; i < val.length; i++) {
            val[i] = new Random().nextInt(10000);
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

//        printArray(val);

        long startTime = System.nanoTime();

        QuickSort ob = new QuickSort();
        ob.sort(val, 0, n-1);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Time in Microseconds : " + totalTime / 1000);

//
//        System.out.println("\nSorted array");
//        printArray(val);





    }
}


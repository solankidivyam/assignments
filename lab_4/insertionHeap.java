import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Collections;
import java.lang.*;


public class insertionHeap{

    static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    static void buildHeap(int arr[], int n)
    {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    static void insertNode(int arr[],int point, int n, int Key)
    {
        // Get the last element

        arr[point] = Key;

        // heapify the root node
        heapify(arr, n, n-1);


    }

    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static void main(String args[])
    {

//        int val[] = {9863, 8562, 5141, 7835, 3269, 3998, 2016, 657, 2574, 1787};
//        int n = val.length;
//        Arrays.sort(val);
        int pointer = 0;
        int[] val = new int[10000];
        int n = val.length;

//        Arrays.sort(val);
        long startTime = System.nanoTime();

        for (int i = 0; i < val.length; i++) {
            int k = new Random().nextInt(100000);
            insertNode(val, pointer, n, k);
            pointer++;
        }

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Time in Microseconds : " + totalTime / 1000);


//
//        int key = 15;
//        insertNode(val,n,key);

//        printArray(val, n);
    }


}
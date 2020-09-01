//Using ArrayLists
import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.*;
import java.util.Collections;
import java.lang.*;
import java.util.ArrayList;
import java.util.Collections;

class Bucket{

    static void bucketSort(float arr[], int n)
    {
        if(n <= 0)
            return;

        @SuppressWarnings("unchecked")
        ArrayList<Float>[] b = new ArrayList[n];

        for(int i = 0; i < n; i++)
        {
            b[i] = new ArrayList<Float>();
        }


        for(int i = 0; i < n; i++)
        {
            int idx = (int)arr[i]*n;
            b[idx].add(arr[i]);
        }


        for(int i = 0; i < n; i++)
        {
            Collections.sort(b[i]);
        }
        int index = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < b[i].size(); j++)
            {
                arr[index++] = b[i].get(j);
            }
        }
    }


    public static void main(String args[])
    {
//        float arr[] = { (float)0.897, (float)0.565,
//                (float)0.656, (float)0.1234,
//                (float)0.665, (float)0.3434 };


        float[] val = new float[10000];
        for (int i = 0; i < val.length; i++) {
            Random rd = new Random();
            val[i] = rd.nextFloat();
        }

        int n = val.length;
        long startTime = System.nanoTime();

        bucketSort(val, n);

        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("Time in Microseconds : " + totalTime / 1000);





//          for(float el : val)
//        {
//            System.out.print(el + " ");
//        }
    }
}



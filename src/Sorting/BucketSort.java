package Sorting;

/**
 * Created by Shivangi on 5/4/2017.
 */
public class BucketSort {

    public int maxValue(int[] a){
        int max = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] > max)
                max = a[i];
        }
        return max;
    }

    public void bucketSort(int[] a, int maxValue){
        int[] bucket = new int[maxValue+1];

        // 1) Create n empty buckets
        for(int i=0; i<bucket.length; i++)
            bucket[i] = 0;

        // 2) Put array elements in different buckets
        for(int i=0; i<a.length; i++)
            bucket[a[i]]++;


        // 3) Sort individual buckets
        // 4) Concatenate all buckets into a[]
        int x = 0;
        for(int i=0; i<bucket.length; i++){
            for(int j=0; j<bucket[i]; j++)
                a[x++] = i;
        }
    }

    public static void main(String args[]){
        BucketSort bs = new BucketSort();
        int a[] = {10, 50, 30, 20, 70, 0, 80, 100 , 10};

        int max = bs.maxValue(a);
        bs.bucketSort(a, max);

        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }

    }
}

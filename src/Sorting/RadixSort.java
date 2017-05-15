package Sorting;

/**
 * Created by Shivangi on 5/4/2017.
 */
public class RadixSort {

    public void countSort(int[] a, int n, int exp){
        int[] output = new int[n];
        int bucket[] = new int[10];

        for(int i=0; i<bucket.length; i++)
            bucket[i] = 0;

        for(int i=0; i<n; i++)
            bucket[(a[i]/exp)%10]++;

        for(int i=1; i<10; i++)
            bucket[i] += bucket[i-1];

        for(int i=n-1; i>=0; i--){
            output[bucket[(a[i]/exp)%10]-1] = a[i];
            bucket[(a[i]/exp)%10]--;
        }

        for(int i=0; i<n; i++)
            a[i] = output[i];
    }

    public int getMax(int[] a){
        int max = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] > max)
                max = a[i];
        }
        return max;
    }

    public void radixSort(int[] a){
        int m = getMax(a);

        for(int i = 1; m/i > 0; i *= 10){
            countSort(a, a.length, i);
        }
    }

    public static void main(String args[]){
        RadixSort rs = new RadixSort();
        int a[] = {10, 50, 30, 20, 70, 0, 80, 100, 90, 0};

        rs.radixSort(a);

        for(int i=0; i<a.length; i++)
            System.out.print(a[i] + " ");
    }
}

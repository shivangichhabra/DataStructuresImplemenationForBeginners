package Sorting;

/**
 * Created by Shivangi on 5/4/2017.
 */
public class InsertionSort {
    public static void main(String args[]){
        int a[] = {10, 50, 30, 20, 70, 0};

        for(int i=0; i<a.length; i++){
            int value = a[i], j=0;
            for(j=i-1; j>=0 && a[j] > value; j--){
               a[j+1] = a[j];
            }
            a[j+1] = value;
        }

        for(int i=0; i<a.length; i++)
            System.out.print(a[i] + " ");
    }
}

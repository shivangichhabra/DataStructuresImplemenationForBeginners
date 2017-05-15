package Sorting;

/**
 * Created by Shivangi on 5/4/2017.
 */
public class QuickSort {

    public void sort(int[] a, int start, int end){
        if(a==null || a.length ==0)
            return;

        if(end > start){
            int pivot = a[(end+start)/2]; //  this is same as start+(end-start)/2;
            int i= start, j = end;
            while(i<=j){
                while(a[i] < pivot)
                    i++;

                while(a[j] > pivot )
                    j--;

                if(i<=j){
                    swap(a, i, j);
                    i++;
                    j--;
                }
            }

            if(start < j)
                sort(a,start, j);

            if(i < end)
                sort(a, i, end);
        }
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String args[]){
        QuickSort qs = new QuickSort();
        int a[] = {10, 50, 30, 20, 70, 0};

        qs.sort(a, 0, a.length-1);

        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}

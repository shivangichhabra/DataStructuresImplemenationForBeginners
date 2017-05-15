package Sorting;

/**
 * Created by Shivangi on 5/4/2017.
 */
public class HeapSort {

    public void heapify(int[] a, int size, int root){
        int top = root;
        int left = 2*root+1;
        int right = 2*root+2;

        if(left < size && a[left] > a[top])
            top = left;

        if(right < size && a[right] > a[top])
            top = right;

        if(top != root){
            int temp = a[root];
            a[root] = a[top];
            a[top] = temp;

            heapify(a, size, top);
        }
    }

    public void sort(int[] a){
        int size = a.length;
        //build heap
        for(int i=size/2-1 ; i >= 0; i--){
            heapify(a, size, i);
        }

        //sort one by one
        for(int i=size-1; i>=0 ; i--){
            //root to end;
            int temp = a[0];
            a[0] = a[i];
            a[i]=temp;

            heapify(a, i, 0);
        }



    }

    public static void main(String args[]){
        HeapSort hs = new HeapSort();
        int a[] = {10, 50, 30, 20, 70, 0, 60, 80, 100};

        hs.sort(a);

        for(int i=0; i<a.length; i++)
            System.out.print(a[i] + "  ");

    }
}

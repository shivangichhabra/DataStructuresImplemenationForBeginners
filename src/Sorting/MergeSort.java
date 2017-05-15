package Sorting;

/**
 * Created by Shivangi on 5/4/2017.
 */
public class MergeSort {

    public void mergeSort(int[] a, int start, int end) {
        if(end <= start)
            return;

        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);

    }

    public void merge(int[] a, int start, int mid, int end){
        int first = mid - start+1;
        int second = end-mid;

        int[] left = new int[first];
        int[] right = new int[second];

        for(int i=0; i<first; i++)
            left[i] = a[start+i];

        for(int j=0; j<second; j++)
            right[j] = a[mid+1+j];

        int i=0,j=0,k = start;
        while(i < first && j < second){
            if(left[i] < right[j]){
                a[k] = left[i];
                i++;
            } else {
                a[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < first){
            a[k] = left[i];
            i++;
            k++;
        }

        while(j < second){
            a[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String args[]){
        MergeSort ms = new MergeSort();
        int a[] = {10, 50, 30, 20, 70, 0};
        ms.mergeSort(a, 0, a.length-1);

        for(int i=0; i<a.length; i++)
            System.out.print(a[i] + "  ");

    }
}

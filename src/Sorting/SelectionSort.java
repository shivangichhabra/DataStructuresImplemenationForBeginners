package Sorting;

/**
 * Created by Shivangi on 5/4/2017.
 */
public class SelectionSort {
    public static void main(String args[]){
        int a[] = {10, 50, 90, 30, 20, 70, 0};

        for(int i=0; i<a.length-1; i++){
            int min = i;
            for(int j=i+1; j<a.length; j++) {
                if (a[min] > a[j])
                    min = j;
            }

            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }


        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + "  ");
        }
    }
}

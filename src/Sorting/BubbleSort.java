package Sorting;

/**
 * Created by Shivangi on 5/4/2017.
 */
public class BubbleSort {
    public static void main(String args[]){
        int a[] = {10, 50, 30, 20, 70, 0};

        for(int i=0; i<a.length; i++){
            for(int j=1; j<(a.length - i); j++){
                if(a[j-1] > a[j]){ //ascending > descending <
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }

        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + "  ");
        }
    }
}

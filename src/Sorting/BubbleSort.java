package Sorting;

/**
 * Created by Shivangi on 5/4/2017.
 */
public class BubbleSort {
    public static void main(String args[]){
        int a[] = {10, 50, 30, 20, 70, 0};

        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length - i-1; j++){
                if(a[j] > a[j+1]){ //ascending > descending <
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        for(int i=0; i<a.length; i++){
            System.out.print(a[i] + "  ");
        }
    }
}

import java.util.Scanner;

/**
 * Created by Shivangi on 3/19/2017.
 */
public class BinarySearch {
    public int bsearch(int[] array, int start, int end, int key){
        if(end >= start){
            int mid = (start+end)/2;

            if(array[mid] == key)
                return mid;
            else if(array[mid] > key){
                //left subaary
                return bsearch(array, start,mid-1, key );
            } else {
                //right subarray
                return bsearch(array, mid+1, end, key);
            }
        }
        return -1;
    }
    public static void main(String args[]){
        BinarySearch bs = new BinarySearch();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int output = bs.bsearch(array, 0, size-1,key);
        System.out.println(output < 0 ? "Not found" : "Found at location: " + (output+1));
    }
}

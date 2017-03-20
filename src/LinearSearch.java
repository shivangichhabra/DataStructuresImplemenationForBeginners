import java.util.Scanner;

/**
 * Created by Shivangi on 3/19/2017.
 */
public class LinearSearch {

    public boolean search(int[] list, int n){
        for(int i=0; i<list.length; i++){
            if(n == list[i]) {
                System.out.println(n + " exits at location " + (i+1));
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        LinearSearch ls = new LinearSearch();
        Scanner sc = new Scanner(System.in);
        int sizeOfArray = sc.nextInt();
        int[] array = new int[sizeOfArray];
        for(int i=0; i<sizeOfArray; i++){
            array[i] = sc.nextInt();
        }
        int searchKey = sc.nextInt();
        System.out.println(ls.search(array, searchKey));
    }
}

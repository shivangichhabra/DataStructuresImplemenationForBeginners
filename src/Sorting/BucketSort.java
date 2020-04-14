package Sorting;

import java.util.*;
/**
 * Created by Shivangi on 5/4/2017.
 */
public class BucketSort {

    private int maxValue(int[] a){
        int max = 0;
        for(int i=0; i<a.length; i++){
            if(a[i] > max)
                max = a[i];
        }
        return max;
    }

    private int hash(int i, int max, int numberOfBuckets) {
        return (int) ((double) i / max * (numberOfBuckets - 1));
    }

    public List<Integer> bucketSort(int[] input, int max){
        final int numberOfBuckets = (int) Math.sqrt(input.length);

        // 1) Create n empty buckets
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);
        for(int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        // 2) Put array elements in different buckets
        for (int i : input) {
            buckets.get(hash(i, max, numberOfBuckets)).add(i);
        }

        // 3) Sort individual buckets
        for(List bucket : buckets){
            Collections.sort(bucket);
        }

        // 4) Concatenate all buckets into input[]
        List<Integer> sortedList = new LinkedList<>();
        for(List<Integer> bucket : buckets){
            sortedList.addAll(bucket);
        }

        return sortedList;
    }

    public static void main(String args[]){
        BucketSort bs = new BucketSort();
        int a[] = {10, 50, 30, 20, 70, 0, 80, 100 , 10};

        int max = bs.maxValue(a);
        List<Integer> sortedList = bs.bucketSort(a, max);

        for(int i : sortedList){
            System.out.print(i + " ");
        }

    }
}


//ctr + alt + s: auto import
//alt + space: check the error
//yellow line: warning


import java.util.Arrays;

/**
 * Created by Linghan on 4/14/2016.
 */

/* 1. pseudocode:
split each element into partitions of size 1
recursively merge adjancent partitions
  for i = leftPartStartIndex to rightPartLastIndex inclusive
    if leftPartHeadValue <= rightPartHeadValue
        copy leftPartHeadValue
    else: copy rightPartHeadValue
copy elements back to original array
*/

//2. example: [5, 3, 11, 15, 2, 4] - > [2,3,4,5,11,15]
//3. notes for code: public and class are lowercase

public class MergeSort {
    private static final int SIZE = 10000;

    //Step1: dividing into partitions into size of 1, and recursively merge sort each part
    public int[] mergeSort(int[] unsorted) {
        //base case
        if (unsorted.length <= 1) {
            return unsorted;
        }
        int len = unsorted.length;
        //1. divide into two arrays, and assign values to them
        int[] left = new int[len / 2];
        System.arraycopy(unsorted, 0, left, 0, len / 2);

        int[] right = new int[len - left.length];
        System.arraycopy(unsorted, len / 2, right, 0, len - len / 2);

        //2. recursive case: recursive merge sort left half and right half
        left = mergeSort(left);
        right = mergeSort(right);
        //merge sorted halves
        return merge(left, right);
    }

    //step2: merge two sorted arrays
    //precaution: two arrays should be the sorted array
    public int[] merge(int[] left, int[] right) {
        //left array index
        int leftstart = 0;
        //right array index
        int rightstart = 0;
        //new array index
        int mergedstart = 0;
        //create a new array to hold the sorted value
        int[] merged = new int[left.length + right.length];
        // traverse and put proper values into merged array from left or right
        while (leftstart < left.length && rightstart < right.length) {
            if (left[leftstart] < right[rightstart]) {
                merged[mergedstart++] = left[leftstart++];
            } else {
                merged[mergedstart++] = right[rightstart++];
            }
        }
        //since not all the elements are copied over to merged array
        //case1: there are still elements left in left array
        if (leftstart < left.length) {
            for (int i = leftstart; i < left.length; i++) {
                merged[mergedstart++] = left[i];
            }
        }
        //case2: there are still elements left in left array
        if (rightstart < right.length) {
            for (int i = rightstart; i < right.length; i++) {
                merged[mergedstart++] = right[i];
            }
        }
        return merged;
    }

    public static void main(String args[]) {
        MergeSort ms = new MergeSort();
        //test1: test the mergeSort function
        int[] unsortedArray = {5, 3, 11, 15, 2, 4};
        System.out.println("the merge sorted array for: " + Arrays.toString(unsortedArray) + "is: " +
                Arrays.toString(ms.mergeSort(unsortedArray)));

        //test2: test the merge function
        int[] left = {3, 5, 11};
        int[] right = {2, 4, 15};
        System.out.println("test the merge function: " + Arrays.toString(ms.merge(left, right)));


        // test merge method
        int[] left2 = {};
        int[] right2 = {3, 27, 78, 94};
        System.out.println(Arrays.toString(ms.merge(left2, right2)));

        //test3: more test cases
        int[] num = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            num[i] = (int) (Math.random() * SIZE);
        }
        System.out.println("the random test result: " + Arrays.toString(ms.mergeSort(num)));
    }
}

import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
    /*
    * sort()
    * recursively calls itself until the arrays are of size 1
    * then merges all the arrays in order from least to
    * greatest
     */
    @Override
    public void sort(int[] a) {
        int[] left = getLeft(a);
        int[] right = getRight(a);
        if(left.length > 1) {
            sort(left);
        }
        if(right.length > 1) {
            sort(right);
        }
        merge(left,right,a);
    }

    /*
    * merge()
    * creatests values to store indexes for each array
    * in the left, right and target.  Then loops through
    * the left and right together checking which value
    * is smaller and putting it in the target array.  Finally,
    * it loops through each array separately to fill in the rest
    * of the missing elements in the left or right.
     */
    static void merge(int[] left, int[] right, int[] a) {

        int lefti = 0;
        int righti = 0;
        int targeti = 0;

        while (lefti < left.length && righti < right.length) {
            if (left[lefti] <= right[righti]) { // stability == if two arrays have the same value, choose the left first
                a[targeti++] = left[lefti++];
            }
            else {
                a[targeti++] = right[righti++];
            }
        }
        while (lefti < left.length) {
            a[targeti++] = left[lefti++];
        }
        while (righti < right.length) {
            a[targeti++] = right[righti++];
        }
    }

    /*
    * getLeft()
    * gets a copy of the first half of the array for sort()
     */

    static int[] getLeft(int[] a){
        int[] left = Arrays.copyOfRange(a, 0, a.length/2);
        return left;
    }

    /*
     * getRight()
     * gets a copy of the second half of the array for sort()
     */
    static int[] getRight(int[] a){
        int[] right = Arrays.copyOfRange(a, (a.length/2), a.length);
        return right;
    }
}

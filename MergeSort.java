import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
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

    static int[] getLeft(int[] a){
        int[] left = Arrays.copyOfRange(a, 0, a.length/2);
        return left;
    }

    static int[] getRight(int[] a){
        int[] right = Arrays.copyOfRange(a, (a.length/2), a.length);
        return right;
    }
}

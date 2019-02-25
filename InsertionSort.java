
public class InsertionSort implements SortingAlgorithm {
    /*
     * insertion sort()
     * sorts the values from least to greatest in an array
     * Sets a marker for the first element in the array
     * the left side is sorted and the right is the rest
     * of the array. Selects the first unsorted element
     * on the right side and adjust the elements in the
     * sorted side.  The marker is then advanced by one
     * element.  This continues until the entire array
     * is sorted.
     */
    @Override
    public void sort(int[] a) {
        int temp;
        int j;
        for(int i = 1; i < a.length;i++){
            temp = a[i];
            j = i-1;
            while(j>=0 && a[j] > temp) {
                a[j+1] = a[j];
                --j;
            }
            a[j+1] = temp;
        }
    }
}

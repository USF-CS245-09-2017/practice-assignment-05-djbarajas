public class QuickSort implements SortingAlgorithm {
    @Override
    public void sort(int[] a) {
        quicksort(a, 0, a.length-1);
    }

    /*
    * swap()
    * swaps 2 elements in the array
     */
    void swap(int [] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /*
    * quicksort()
    * partitions the array based on the pivot
    * quicksorts the first half and second
    * half
     */

    void quicksort (int [] arr, int left, int right) {
        if (left < right) {
            int p = partition(arr, left, right);
            quicksort(arr, left, p-1);
            quicksort(arr, p+1, right);
        }
    }

    /*
    * partition()
    * creates a pivot and sorts the array based on
    * that pivot with i and j being indexes to swap
     */
    int partition (int [] arr, int left, int right) {
        if (left < right) {
            int pivot = left;
            int i = left + 1; // Avoids re-sorting the pivot
            int j = right;
            while (i < j) {
                while (i <= right && arr[i] <= arr[pivot]) {
                    ++i;
                }
                while (j >= i && arr[j] > arr[pivot]) {
                    --j;
                }
                if (i <= right && i < j) {
                    swap(arr, i, j);
                }
            }
            swap(arr, pivot, j);  // pivot to the middle
            return j;
        }
        return left;
    }


}

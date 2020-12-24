package com.kururu.skillup.algorithm.problems.sorting;

/**
 * <h2>Quick Sorting</h2>
 * <ol>
 *     <li>Sort image : <a href = "https://medium.com/@ujjwalgupta_57939/quicksort-in-javascript-a7337a1a6e80">LINK</a></li>
 * </ol>
 *
 * @author Rick00Kim dreamx119@gmail.com
 */
public class QuickSorting extends AbstractSorting {

    public QuickSorting(int[] targetArray, boolean reverseFlg) {
        super(targetArray, reverseFlg);
    }

    @Override
    public void process() {
        quickSort(targetArray, 0, targetArray.length - 1);
    }

    private void quickSort(int[] target, int low, int high) {
        if (low >= high) return;

        int mid = partition(target, low, high);
        quickSort(target, low, mid - 1);
        quickSort(target, mid, high);
    }

    private int partition(int[] target, int low, int high) {
        int pivot = target[(low + high) / 2];
        while (low <= high) {
            while (target[low] < pivot) low++;
            while (target[high] > pivot) high--;
            if (low <= high) {
                int temp = target[low];
                target[low] = target[high];
                target[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }

    @Override
    protected String getSortName() {
        return getClass().getSimpleName();
    }
}

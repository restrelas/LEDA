package sorting.simpleSorting;

import sorting.AbstractSorting;

import static util.Util.swap;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		for(int j = 0; j < rightIndex-leftIndex; ++j){
			int p = leftIndex;
			for(int i = leftIndex; i <= rightIndex-j; ++i){
				if(array[i].compareTo(array[p]) > 0) p = i;
			}
			swap(array, p, rightIndex-j);
		}
	}
}

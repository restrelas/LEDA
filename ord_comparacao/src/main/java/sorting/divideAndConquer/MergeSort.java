package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(rightIndex < leftIndex || leftIndex < 0 || rightIndex < 0 || rightIndex >= array.length) return;

		T[] aux = (T[]) new Comparable[array.length];
		sort(array, leftIndex, rightIndex, aux);
	}

	public void sort(T[] array, int leftIndex, int rightIndex, T[] aux){
		int mid = (leftIndex + rightIndex)/2;
		if(rightIndex <= leftIndex) return;

        sort(array, leftIndex, mid, aux);
        sort(array, mid+1, rightIndex, aux);
        merge(array, leftIndex, mid, rightIndex, aux);
	}

	public void merge(T[] array, int leftIndex, int mid, int rightIndex, T[] aux){
		int p = leftIndex;
		int m = mid+1;
		int l = leftIndex;
		while(l <= mid || m <= rightIndex){
			if(l > mid){
				aux[p++] = array[m++];
			}else if(m > rightIndex){
				aux[p++] = array[l++];
			}else if(array[l].compareTo(array[m]) < 0){
				aux[p++] = array[l++];
			}else{
				aux[p++] = array[m++];
			}
		}
		for(int i = leftIndex; i <= rightIndex; ++i){
			array[i] = aux[i];
		}
	}
}

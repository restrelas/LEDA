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
		T[] aux = (T[]) new Comparable[array.length];
		sort(array, leftIndex, rightIndex, aux);
	}
	public void sort(T[] array, int leftIndex, int rightIndex, T[] aux){
		int mid = (leftIndex + rightIndex)/2;
		if(rightIndex - leftIndex > 2){
			sort(array, leftIndex, mid, aux);
			sort(array, mid+1, rightIndex, aux);
			merge(array, leftIndex, mid, rightIndex, aux);
		}
	}
	public void merge(T[] array, int leftIndex, int mid, int rightIndex, T[] aux){
		int p = leftIndex;
		int m = mid;
		while(leftIndex <= mid || m <= rightIndex){
			if(leftIndex > mid){
				aux[p++] = array[m++];
			}else if(m > rightIndex){
				aux[p++] = array[leftIndex++];
			}else if(array[leftIndex].compareTo(array[m]) < 0){
				aux[p++] = array[leftIndex++];
			}else{
				aux[p++] = array[m++];
			}
		}
		for(int i = 0; i < array.length; ++i){
			array[i] = aux[i];
		}
	}
}

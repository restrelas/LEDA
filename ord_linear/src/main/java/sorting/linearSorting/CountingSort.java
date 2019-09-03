package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(rightIndex < leftIndex || rightIndex < 0 || leftIndex < 0) return;

		int max = array[leftIndex];

		for(int i = leftIndex; i <= rightIndex; ++i){
			max = Math.max(max, array[i]);
		}
		Integer[] c = new Integer[max+1];
		Arrays.fill(c, 0);
		for(int i = leftIndex; i <= rightIndex; ++i){
			c[array[i]]++;
		}
		int temp = 0;
		for(int i = 0; i < max+1; ++i){
			temp+=c[i];
			c[i] = temp;
		}

		Integer[] answer = Arrays.copyOf(array, array.length);
		for(int i = rightIndex; i >= leftIndex; --i){
			answer[--c[array[i]]] = array[i];
		}
		for(int i = leftIndex; i <= rightIndex; ++i){
			array[i] = answer[i];
		}
	}

}

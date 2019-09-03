package sorting.linearSorting;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(rightIndex < leftIndex || rightIndex < 0 || leftIndex < 0) return;
		int min = array[leftIndex];
		int max = array[leftIndex];

		for(int i = leftIndex; i <= rightIndex; ++i){
			min = Math.min(min, array[i]);
			max = Math.max(max, array[i]);
		}
		Integer[] c = new Integer[max-min+1];
		Arrays.fill(c, 0);
		for(int i = leftIndex; i <= rightIndex; ++i){
			c[array[i]-min]++;
		}
		int temp = 0;
		for(int i = 0; i < max-min+1; ++i){
			temp+=c[i];
			c[i] = temp;
		}

		Integer[] answer = Arrays.copyOf(array, array.length);
		for(int i = rightIndex; i >= leftIndex; --i){
			answer[--c[array[i]-min]] = array[i];
		}
		for(int i = leftIndex; i <= rightIndex; ++i){
			array[i] = answer[i];
		}

	}

}

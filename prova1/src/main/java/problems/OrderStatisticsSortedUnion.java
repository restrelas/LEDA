package problems;


/**
 * Dado dois arrays ordenados em ordem crescente, encontrar a k-esima estatistica de ordem 
 * da uniao ordenada deles. 
 * 
 * Restricoes:
 * - os arrays nao possuem elementos em comum e nem repetidos
 * - k eh um numero compreendido entre 1 e array1.length + array2.length
 * - caso o k-esima estatistica de ordem nao exista, o metodo deve retornar null
 * - voce nao pode usar memoria extra
 * - seu algoritmo deve ter complexidade O(array1.length + array2.length). 
 * - voce nao pode usar nenhum metodo pronto de manipulacao de arrays, exceto length.
 * 
 * @author adalbertocajueiro
 *
 */
public class OrderStatisticsSortedUnion<T extends Comparable<T>> {
	public T statisticsOrder(T[] array1, T[] array2, int k) {
		int p1 = 0, p2 = 0;
		int it = 0;
		if(k > array1.length + array2.length) return null;
		T last = null;
		while((p1 <= array1.length || p2 <= array2.length) && it < k){
			if(p1 == array1.length){
				last = array2[p2++];
			}else if(p2 == array2.length){
				last = array1[p1++];
			}else{
				if(array1[p1].compareTo(array2[p2]) < 0){
					last = array1[p1++];
				}else{
					last = array2[p2++];
				}
			}
			it++;
		}
		return last;
	}
}

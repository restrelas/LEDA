package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
//		return floor(array, 0, array.length-1, x);
		int l = 0, r = array.length-1;
		Integer ans = null;
		while(l <= r){
			int mid = (l+r)/2;
			if(array[mid].compareTo(x) <= 0){
				ans = array[mid];
				l = mid+1;
			}else{
				r = mid-1;
			}
		}
		return ans;
	}


	@Override
	public Integer ceil(Integer[] array, Integer x) {
		int l = 0, r = array.length-1;
		Integer ans = null;
		while(l <= r){
			int mid = (l+r)/2;
			if(array[mid].compareTo(x) >= 0){
				ans = array[mid];
				r = mid-1;
			}else{
				l = mid+1;
			}
		}
		return ans;
	}

}

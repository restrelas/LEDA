package adt.hashtable.closed;

import adt.hashtable.hashfunction.*;
import util.Util;

import java.util.LinkedList;

public class HashtableClosedAddressImpl<T> extends
		AbstractHashtableClosedAddress<T> {

	/**
	 * A hash table with closed address works with a hash function with closed
	 * address. Such a function can follow one of these methods: DIVISION or
	 * MULTIPLICATION. In the DIVISION method, it is useful to change the size
	 * of the table to an integer that is prime. This can be achieved by
	 * producing such a prime number that is bigger and close to the desired
	 * size.
	 * 
	 * For doing that, you have auxiliary methods: Util.isPrime and
	 * getPrimeAbove as documented bellow.
	 * 
	 * The length of the internal table must be the immediate prime number
	 * greater than the given size (or the given size, if it is already prime). 
	 * For example, if size=10 then the length must
	 * be 11. If size=20, the length must be 23. You must implement this idea in
	 * the auxiliary method getPrimeAbove(int size) and use it.
	 * 
	 * @param desiredSize
	 * @param method
	 */

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashtableClosedAddressImpl(int desiredSize,
			HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getPrimeAbove(desiredSize); // real size must the
														// the immediate prime
														// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method,
				realSize);
		this.hashFunction = function;
	}

	// AUXILIARY
	/**
	 * It returns the prime number that is closest (and greater) to the given
	 * number.
	 * If the given number is prime, it is returned. 
	 * You can use the method Util.isPrime to check if a number is
	 * prime.
	 */
	int getPrimeAbove(int number) {
		 while(!Util.isPrime(number)) ++number;
		 return number;
	}

	@Override
	public void insert(T element) {
		int eHash = ((HashFunctionClosedAddress<T>) hashFunction).hash(element);

		if(table[eHash] == null) {
			this.table[eHash] = new LinkedList<>();
		}else if(((LinkedList) this.table[eHash]).size() > 0){
			COLLISIONS++;
		}
		((LinkedList) table[eHash]).add(element);
		elements++;

	}

	@Override
	public void remove(T element) {
		int eHash = ((HashFunctionClosedAddress<T>) hashFunction).hash(element);

		if(table[eHash] != null){
			if(((LinkedList) table[eHash]).contains(element)){
				if(((LinkedList) table[eHash]).size() > 1){
					COLLISIONS--;
				}
				((LinkedList) table[eHash]).removeFirstOccurrence(element);
				elements--;
			}
		}
	}

	@Override
	public T search(T element) {
		int eHash = ((HashFunctionClosedAddress<T>) hashFunction).hash(element);

		if(table[eHash] != null){
			if(((LinkedList) table[eHash]).contains(element)) return element;
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		int eHash = ((HashFunctionClosedAddress<T>) hashFunction).hash(element);

		if(table[eHash] != null){
			if(((LinkedList) table[eHash]).contains(element)) return eHash;
		}
		return -1;
	}

}

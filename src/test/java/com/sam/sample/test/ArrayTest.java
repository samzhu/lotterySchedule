package com.sam.sample.test;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		Integer[] numbers = {12, 5, 11, 25, 31, 19, 2};
		System.out.println("範例1");
		Arrays.stream(numbers).forEach( t -> System.out.println(t));
		System.out.println("範例2");
		Arrays.sort(numbers, 0, 6);
		Arrays.stream(numbers).forEach( t -> System.out.println(t));
	}

}

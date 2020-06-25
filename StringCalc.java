package com.javabrains.NewscapeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalc {
	
	private static String[] newArray;

	public static void main(String[] args){			
		/*
		 * Scanner sc=new Scanner(System.in);
		 * String input=sc.nextLine();
		 */
		
		String input="1,2,3";
		String[] newArray = null;
		int a;
		
		ArrayList<Integer> positiveList=new ArrayList<Integer>(10);
		
		if(input==null || input=="")
			System.out.println("0"); // return '0' for null entry
		else {
			newArray = input.split(",");
			List<String> stringList=Arrays.asList(newArray);			
			for(String value:stringList) {					
				positiveList.add(Integer.parseInt(value));
			}
			System.out.println(Add(positiveList)); // else call method Add
		}
			
	}
	
	// step 1. to create method to take 2 int to add
	public static int Add(ArrayList<Integer> numbers) {
		
		if(numbers.size()> 2) 
			throw new RuntimeException("Only two numbers can be processed");
		else					
			return numbers.stream().filter(x -> x <1000)
				.mapToInt(x ->x ).sum();	 

		}

}

package com.javabrains.NewscapeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//step 5. to check negative nos 
class NegativeNumberNotAllowed extends Exception{
		
	NegativeNumberNotAllowed(List<Integer> x) {
		System.out.println("Negative numbers not allowed"+x);		
	}
}

public class StringCalc {

	private static String[] newArray;

	public static void main(String[] args){			
		/*
		 * Scanner sc=new Scanner(System.in);
		 * String input=sc.nextLine();
		 */
		
		String input="-1,-2";
		String[] newArray = null;
		int a;
		String delimiter=",";
		
		if(input.startsWith("//")) { //if the input starts with "//" the next character will be delimiter and the remaining 
									//input string will be used for further operation
			delimiter=input.substring(2, 3);	
			input=input.substring(4, input.length());
			System.out.println(""+delimiter+" "+input);
		}
				
		
		
		ArrayList<Integer> positiveList=new ArrayList<Integer>(10);
		input=input.replaceAll("[\n]", ",");
		
		if(input==null || input=="" || input.contains(",\n") || input.contains("\n,"))
			System.out.println("0"); // return '0' for null entry
		else {
			newArray = input.split(delimiter);
			List<String> stringList=Arrays.asList(newArray);			
			for(String value:stringList) {					
				positiveList.add(Integer.parseInt(value));
			}
			List<Integer> negativeList=stringList.stream()
					.map(Integer::valueOf)
					.filter(x -> x < 0)
					.collect(Collectors.toList());
			
			try {
				if(negativeList.size()!=0)
					throw new NegativeNumberNotAllowed(negativeList); //to handle negative numbers	
				else{
					System.out.println(Add(positiveList)); // else call method Add			
				}
			}
			catch(NegativeNumberNotAllowed e)	{	}
			
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
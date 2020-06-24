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

//step 2. exception to handle invalid no of arguments
class InvalidnoOfArgument extends Exception{
	
	InvalidnoOfArgument() {
		System.out.println("invalid no of arguments");		
	}
}

public class StringCalculator {

	private static String[] newArray;
	private static int length;

	public static void main(String[] args){
		
		/*
		 * Scanner sc=new Scanner(System.in);
		 * String input=sc.nextLine();
		 */
		
		String input="\2;3000\n";
		String[] newArray = null;
		int a;
		
		
		if(input==null || input=="" || input.contains(",\n") || input.contains("\n,"))
			System.out.println("0");
		
		//Step 3. to remove new lines
		input=input.replaceAll("[\n*;]", ",");
		
		newArray = input.split(",");
		length=newArray.length;
		
		List<String> stringList=Arrays.asList(newArray);
		ArrayList<Integer> positiveList=new ArrayList<Integer>(newArray.length);
		List<Integer> negativeList=stringList.stream().map(Integer::valueOf)
					.filter(x -> x < 0).collect(Collectors.toList());
		
		try {
			if(negativeList.size()!=0)
				throw new NegativeNumberNotAllowed(negativeList);	
			else{
				for(String value:stringList) {					
					positiveList.add(Integer.parseInt(value));
					}
				}				
			}
		catch(NegativeNumberNotAllowed e)	{	}
		
		System.out.println(Add(positiveList));
		
			
	}
	
	// step 1. to create method to take 2 int to add
	public static int Add(ArrayList<Integer> numbers) {	
		try {
			if(numbers.size()>length)
				throw new InvalidnoOfArgument();
		}
		catch(InvalidnoOfArgument e) {}
		
			
		return numbers.stream().filter(x -> x <1000)
				.mapToInt(x ->x ).sum();
	}
}



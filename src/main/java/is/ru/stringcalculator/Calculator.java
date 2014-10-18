package is.ru.stringcalculator;

import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		/*if(text.startsWith("//[")){
			return sum(splitNumbersbyLongDef(text));
		}*/
		if(text.startsWith("//")){
			return sum(splitNumbersbyDef(text));
		}
		else if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else if(text.length() == 1){
			return Integer.parseInt(text);
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	   	 negativeNumberCheck(numbers.split(",|\n"));
		 return removeBigNumbers(numbers.split(",|\n"));
	}
	
	// the commented code was an attempt to understand/do step nr 7
	// it did not work
	/*private static String[] splitNumbersbyLongDef(String numbers){
		//String str = new String(numbers.substring(3,4);
		//String str = new String("1,2,4");
		//return removeBigNumbers(str.split("*"));
		String pat = "1,2,4";
		return removeBigNumbers(pat.split(","));
	}*/

	private static String[] splitNumbersbyDef(String numbers){
		String str = new String(numbers.substring(2,3));
		String stri = new  String(numbers.substring(3));
		negativeNumberCheck(stri.split(str));
		return removeBigNumbers(stri.split(str));
	}

	private static int sum(String[] numbers){
		int total = 0;
        	for(String number : numbers){
		    total += toInt(number);
		}
		return total;
	}

	private static void negativeNumberCheck(String[] numbers){
	String str = new String("");
	for(int i = 0; i < numbers.length; i = i+1){
		if(Integer.parseInt(numbers[i]) < 0){
			if(str.length() == 0){
			str = numbers[i];
			}
			else{
			str = str + "," + numbers[i];
			}
		}
	}
	if(str.length() > 0)
	throw new IllegalArgumentException("Negatives not allowed: " + str);
	}

	private	static String[] removeBigNumbers(String[] numbers){
		for(int i = 0; i < numbers.length; i = i+1){
			if(Integer.parseInt(numbers[i]) > 1000){
			numbers[i] = "0";
			}
		}
		return numbers;
	}

}

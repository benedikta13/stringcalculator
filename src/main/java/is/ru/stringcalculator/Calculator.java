package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.startsWith("//")){
		return sum(splitNumbersbyDef(text));
		}
		else if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	   	 negativeNumberCheck(numbers.split(",|\n"));
		 return numbers.split(",|\n");
	}

	private static String[] splitNumbersbyDef(String numbers){
		String str = new String(numbers.substring(2,3));
		String stri = new String(numbers.substring(3));
		negativeNumberCheck(stri.split(str));
		return stri.split(str);
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



}

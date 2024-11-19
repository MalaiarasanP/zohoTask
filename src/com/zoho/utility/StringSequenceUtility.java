package com.zoho.utility;
import java.util.*;
import com.zoho.customexception.*;
public abstract class StringSequenceUtility {
    public static void validateNonNull(CharSequence... inputs) throws UtilityValidationException {
        for(CharSequence input : inputs) {
            if(input==null) {
                throw new UtilityValidationException("Null String");
            }
        }
    }
    public static void validateNotEmpty(CharSequence... inputs) throws UtilityValidationException {
        for(CharSequence input : inputs) {
            if(input==null) {
                throw new UtilityValidationException("Null string");
            }
            if(input.length()==0) {
                throw new UtilityValidationException("Empty string");
            }
        }
    }
    public static void checkNegativeNumber(int index) throws UtilityValidationException {
        if(index<0) {
            throw new UtilityValidationException("Negative Index");
        }
    }
    public static void checkOutOfRangeIndex(int index,CharSequence input) throws UtilityValidationException {
        validateNotEmpty(input);
        checkNegativeNumber(index);
        if(index>=input.length()) {
            throw new UtilityValidationException("Index out of range for character sequence");
        }
    }
    public static void checkOutOfRangeIndex(int index, List<?> list) throws UtilityValidationException {
    	
    	if (list == null || list.isEmpty()) {
        	throw new UtilityValidationException("List is null or empty");
    	}
    	if (index >= list.size()) {
        	throw new UtilityValidationException("Index out of range for List");
    	}
    }
    public static void exceedsMaxLength(int size,CharSequence input) throws UtilityValidationException {
        validateNotEmpty(input);
        checkNegativeNumber(size);
        if(size>input.length()) {
            throw new UtilityValidationException("Exceed max character");
        }
    }
    private static boolean isInvalidSequenceList(List<? extends CharSequence> list) {
        if (list == null) {
            return true;
        }
        for (CharSequence element : list) {
            if (element != null) {
                return false;
            }
        }
        return true;
    }
    public static void validateSequenceList(List<? extends CharSequence> list) throws UtilityValidationException{
    	if(isInvalidSequenceList(list)){
    		throw new UtilityValidationException("Invalid String list");
    	}
    }
    public static void validateIndexRange(int startIndex,int endIndex,CharSequence input) throws UtilityValidationException {
    	checkOutOfRangeIndex(startIndex,input);
    	checkOutOfRangeIndex(endIndex,input);
    	if(startIndex>endIndex){
    		throw new UtilityValidationException("start index cannot be greater than end index ");	
    	}
    }
    public static int getLength(CharSequence input) throws UtilityValidationException{
	validateNonNull(input);
	return input.length();
    }
    public static int getValidIntegerInput(Scanner scanner, String prompt) {
        int input=0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return input;
    }
    public static String getValidInputString(Scanner scanner,String prompt) {
        System.out.print(prompt);
        String str = scanner.nextLine();
        return str;
    }
}
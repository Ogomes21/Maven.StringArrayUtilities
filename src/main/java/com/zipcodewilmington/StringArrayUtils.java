package com.zipcodewilmington;

import org.hamcrest.core.StringEndsWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            if (array[i].contains(value)) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] reversed = new String[array.length];
        int location = array.length - 1;
        for (String element : array) {
            reversed[location] = element;
            location--;
        }

        return reversed;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {

        return Arrays.equals(array, reverse(array));
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
        String arrayString = Arrays.toString(array).toLowerCase();

        for (int i = 0; i <= alphabet.length - 1; i++) {
            if (!arrayString.contains(alphabet[i])) return false;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (String element : array) {
            if (element.equals(value)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {

        String[] removedArray = new String[array.length - getNumberOfOccurrences(array, valueToRemove)];
        int index = 0;
        for (String element : array) {
            if (!element.equals(valueToRemove)) {
                removedArray[index] = element;
                index++;
            }
        }
        return removedArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String previous = "";
        List removed = new ArrayList();
        for (String element : array) {
            if (!element.equals(previous)) {
                removed.add(element);
                previous = element;
            }
        }
        String[] finalRemoved = new String[removed.size()];
        removed.toArray(finalRemoved);
        return finalRemoved;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        List removed = new ArrayList();
        for (int i = 0; i < array.length; i++) {
            if (i + 1 != array.length) {
                String next = array[i];
                while (array[i].equals(array[i + 1])) {
                    next += array[i];
                    i++;
                    if (i + 1 == array.length) {
                        break;
                    }

                }
                removed.add(next);
            } else {
                removed.add(array[i]);
            }
        }
        String[] combined = new String[removed.size()];
        removed.toArray(combined);
        return combined;
    }

}


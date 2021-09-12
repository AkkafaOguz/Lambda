import jdk.jshell.execution.Util;

import java.util.*;

public class Lambda03 {

    public static void main(String[] args) {

        List<String> l = new ArrayList<>();

        l.add("Ali");
        l.add("Ali");
        l.add("Mark");
        l.add("Amanda");
        l.add("Christopher");
        l.add("Jackson");
        l.add("Mariano");
        l.add("Alberto");
        l.add("Tucker");
        l.add("Benjamin");


        //1) Create a method to print all list elements in uppercase

          l.
          stream().
          map(t-> t.toUpperCase()).
          forEach(Utils::printInTheSameLineWithASpace);
          System.out.println();

        //1.1) Create a method to print all list elements in uppercase

          l.
          stream().
          map(String::toUpperCase).
          forEach(Utils::printInTheSameLineWithASpace);
          System.out.println();

        //1.2 Create a method to print all list elements in uppercase

        l.replaceAll(String::toUpperCase);                            //-> Sometimes we use functional programming without stream()
        System.out.println(l);

        //2) Create a method to print the elements after ordering according to their lengths

          l.
          stream().
          sorted(Comparator.comparing(String::length)).
          forEach(Utils::printInTheSameLineWithASpace);
          System.out.println();

        //3) Create a method to sort the distinct elements by using their last characters

                l.
                stream().
                distinct().
                sorted(Comparator.comparing(t-> t.charAt(t.length()-1))).
                forEach(Utils::printInTheSameLineWithASpace);
                System.out.println();

        //4) Create a method to sort the elements according to their lengths then according to their first character

                l.
                stream().
                sorted(Comparator.comparing(String::length).
                thenComparing(t-> t.charAt(0))).
                forEach(Utils::printInTheSameLineWithASpace);
                System.out.println();

        //5) Remove the elements if the length of the element is greater than 5

        //  l.removeIf(t-> t.length()>5);
        //  System.out.println(l);

        //6) Remove the elements if the element is starting with 'A', 'a' or ending with 'N', 'n'

        //  l.removeIf(t-> t.charAt(0) == 'A' || t.charAt(0) == 'a' || t.endsWith("N") || t.endsWith("n"));
        //  System.out.println(l);

        //7) Create a method which takes the square of the length of every element, prints them distinctly in reverse order

                l.
                stream().
                map(t-> t.length()*t.length()).
                distinct().
                sorted(Collections.reverseOrder()).
                forEach(Utils::printInTheSameLineWithASpace);
                System.out.println();

        //7.1)

                l.
                stream().
                map(String::length).
                map(Utils::makeSquare).
                distinct().
                sorted(Collections.reverseOrder()).
                forEach(Utils::printInTheSameLineWithASpace);
                System.out.println();


        //8) Create a method to check if the lengths of all elements are less than 12 (All Match) Returns whether no elements of this stream match the provided predicate (condition).

          boolean ifLength = l.stream().allMatch(t-> t.length()<12);
          System.out.println(ifLength);

        //9) Create a method to check if the initial of any element is not ‘X’ (Any Match)

          boolean ifX = l.stream().noneMatch(t-> t.startsWith("X"));
          System.out.println(ifX);


        //10) Create a method to check if at least one of the elements ending with "R"

          boolean ifR = l.stream().anyMatch(t-> t.endsWith("R"));
          System.out.println(ifR);

    }
}

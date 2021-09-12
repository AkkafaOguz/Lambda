import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {

    /*
        Method Reference: Class Name :: Method Name without method parenthesis

	 	Example ==>        String     :: length
	 	                   ArrayList  :: size
     */

    public static void main(String[] args) {

        List<Integer> l = new ArrayList<>();

        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);


        //1) Create a method to print the list elements on the console in the same line with a space between two consecutive elements.(Method Reference)
        l.stream().forEach(Utils::printInTheSameLineWithASpace);
        System.out.println();
        //If Java has any method we prefer to use it, if Java does not have it we create the method inside Utils class and use it

        //2) Create a method to print the even list elements on the console in the same line with a space between two consecutive elements.(Method Reference)
        l.stream().filter(Utils::evenElement).forEach(Utils::printInTheSameLineWithASpace);
        System.out.println();

        //3)Create a method to print the square of odd list elements on the console in the same line with a space between two consecutive elements.
        l.stream().filter(Utils::oddElement).map(Utils::makeSquare).forEach(Utils::printInTheSameLineWithASpace);
        System.out.println();

        //4)Create a method to print the cube of distinct odd list elements on the console in the same line with a space between two consecutive elements.
        l.stream().distinct().filter(Utils::oddElement).map(Utils::makeCube).forEach(Utils::printInTheSameLineWithASpace);
        System.out.println();

        //5)Create a method to calculate the sum of the squares of distinct even elements
        Integer sum = l.stream().distinct().filter(Utils::evenElement).map(Utils::makeSquare).reduce(0, Integer::sum);
        System.out.print("1.Way - The sum of the squares of even distinct elements is: "+sum);
        System.out.println();
        Integer sum2 = l.stream().distinct().filter(Utils::evenElement).map(Utils::makeSquare).reduce(0, Math::addExact);
        System.out.print("2.Way - The sum of the squares of even distinct elements is: "+sum2);
        System.out.println();

        //6)Create a method to calculate the product of the cubes of distinct even elements
        Integer product = l.stream().distinct().filter(Utils::evenElement).map(Utils::makeCube).reduce(1,Math::multiplyExact);
        System.out.print("The multiplication of the cubes of even distinct elements is: "+product);
        System.out.println();

        //7)Create a method to find the maximum value from the list elements
        Integer maxElement = l.stream().reduce(Integer.MIN_VALUE, Math::max);
        System.out.print("The maximum element is: "+maxElement);
        System.out.println();

        //8)Create a method to find the minimum value from the list elements
        Integer minElement = l.stream().reduce(Integer.MAX_VALUE, Math::min);
        System.out.print("The minimum element is: "+minElement);
        System.out.println();

        //9)Create a method to find the minimum value which is greater than 7 and even from the list
        Integer greaterThanSeven = l.stream().filter(t-> t>7).filter(Utils::evenElement).reduce(Integer.MAX_VALUE,Math::min);
        System.out.print("1.Way The minimum element which is greater than 7 is: "+greaterThanSeven);
        System.out.println();

        //9.1)
        Integer greaterThanSeven2 = l.stream().filter(Utils::evenElement).filter(t-> t>7).sorted().findFirst().get();
        System.out.print("2.Way The minimum element which is greater than 7 is: " + greaterThanSeven2);
        System.out.println();

        //10) Find the half of the elements which are distinct and greater than 5 in reverse order from the list.
        List <Double> halfOfGreaterThan5= l.stream().distinct().filter(t-> t>5).map(Utils::makeHalf).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.print(halfOfGreaterThan5);
        System.out.println();


    }
}

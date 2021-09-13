import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lambda04 {
    public static void main(String[] args) {

        // AFTER LEARNING INTSTREAM DO NOT USE FOR LOOP IF YOU WANNA BE GOOD AT CODDING.

        List<Integer> l = new ArrayList<Integer>();
        l.add(12);
        l.add(9);
        l.add(13);
        l.add(4);
        l.add(9);
        l.add(2);
        l.add(4);
        l.add(12);
        l.add(15);

        //1) Find the sum of all elements in the list

        Integer sum= l.stream().reduce(0,Integer::sum); // --> There are two kinds of reduce method. We use two parameters to not get an optional output.
        System.out.println(sum);

        //1.1)

        Integer sum2 = l.stream().reduce(0,Math::addExact);
        System.out.println(sum2);

        //2) Find the sum of integers from 7 to 100

        Integer sum7To100 = IntStream.range(7,101).reduce(0,Math::addExact); // --> for range() first parameter is inclusive the second is exclusive.
        System.out.println(sum7To100);

        //2.1))
                                                                 // --> for rangeClosed() both parameters are inclusive. That's why, it is better to use this one.
        Integer sum7To1002 = IntStream.rangeClosed(7,100).sum(); // --> This is a terminal operation. Returns:the sum of elements in this stream
        System.out.println(sum7To1002);

        //3) Find the multiplication of the integers from 2(inc) to 11(inc)

        Integer multiplication = IntStream.rangeClosed(2,11).reduce(1,Math::multiplyExact);
        System.out.println(multiplication);

        //4) Calculate the factorial of a given number.(5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)

        Integer factorial = IntStream.rangeClosed(1,5).reduce(1,Math::multiplyExact);
        System.out.println("5! = "+factorial);

        //5) Calculate the sum of even integers between given two integers

        Integer sumOfEven = IntStream.rangeClosed(4,11).filter(Utils::evenElement).sum();
        System.out.println(sumOfEven);

        //6)Create a method to calculate the sum of digits of every integers between given two integers

        Integer sumOfDigits = IntStream.rangeClosed(123,127).map(Utils::digit).sum();
        System.out.println(sumOfDigits);

    }
}

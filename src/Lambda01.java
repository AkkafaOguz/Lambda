import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {

    /*

    Lambda (Functional Programming)
    JAVA (Structured Programming)


    1-) Nasil yaparim degil, ne yaparim.  (Lambda)
    1-) Ne yaparimdan cok nasil yaparim   (JAVA)

    2-) Kod kisaligi, okunabilirligi ve minimum hata      (Lambda)
    2-) Kod genelde uzundur dolayisiyla hataya aciktir    (JAVA)

    3-) Lambda sadece Collection'lar ve Array'lar icin gecerlidir maplarde kullanilmaz. (Lambda)

    */


    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();

        l.add(12);
        l.add(9);
        l.add(131);
        l.add(14);
        l.add(9);
        l.add(10);
        l.add(4);
        l.add(12);
        l.add(15);

        // If you wanna change ant element in your collection you should use map method
        // using distinct method before is much more method for speed
        // In reduce method, the number of elements is reducing (1) because of that the name of method is reduce


        //1) Print the list element on the console in the same line with a spoace between two consecutive elements.
        l.stream().forEach(t-> System.out.print(t + " "));
        System.out.println();

        //2) Print the even list elements on the console in the same line with a spoace between two consecutive elements.
        l.stream().filter(t-> t%2==0).forEach(t-> System.out.print(t + " "));
        System.out.println();

        //3) Print the square of odd  list elements on the console in the same line with a spoace between two consecutive elements.
        l.stream().filter(t-> t%2==1).map(t-> t*t).forEach(t-> System.out.print(t + " "));
        System.out.println();

        //4) Print the cube if distinct odd list elements on the console in the same line with a spoace between two consecutive elements.
        l.stream().distinct().filter(t-> t%2==1).map(t-> t*t*t).forEach(t-> System.out.print(t + " "));
        System.out.println();

        //5) Print the calculation of the sum of squares of distinct even elements
        System.out.print(l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (t,u)-> t+u));
        System.out.println();

        //6) Print the calculation of the product of the cubes of distinct even elements
        Integer product = l.stream().distinct().filter(t-> t%2==0).map(t-> t*t*t).reduce(1,(t,u)-> t*u);
        System.out.print(product);
        System.out.println();

        //7) Print the maximum value from the list elements
        Integer maxElement = l.stream().reduce(Integer.MIN_VALUE, (t,u)-> t>u ? t : u);
        System.out.print("Birinci yol ile maksimum element -> "+maxElement);
        System.out.println();

        //8) Print the minimum value from the list elements
        Integer minElement = l.stream().reduce(Integer.MAX_VALUE, (t,u)-> t<u ? t : u);
        System.out.print("Birinci yol ile minimum element -> "+minElement);
        System.out.println();

        //7.1)
        Integer maxElement2 = l.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t,u)-> u);
        System.out.print("Ikinci yol ile maksimum element -> "+maxElement2);
        System.out.println();

        //8.1)
        Integer minElement2 = l.stream().distinct().sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE, (t,u) -> u);
        System.out.print("Ikinci yol ile minimum element -> "+minElement2);
        System.out.println();

        //9) Find the minimum value which is greater than seven and even
        Integer minGreaterThanSeven = l.stream().distinct().filter(t-> t%2==0 && t>7).sorted(Comparator.reverseOrder()).reduce(0,(t,u)->u);
        System.out.print(minGreaterThanSeven);
        System.out.println();

        //9.1)
        Integer minGreaterThanSeven2 = l.stream().distinct().filter(t-> t%2==0 && t>7).reduce(Integer.MAX_VALUE, (t,u) -> t>u ? u : t);
        System.out.print(minGreaterThanSeven2);
        System.out.println();

        //9.2)
        // Do not forget to use find() method together with get() method. If you do not use get() you can not assigne it to the Integer type variable.
        Integer minGreaterThanSeven3 = l.stream().distinct().filter(t-> t%2==0 && t>7).sorted().findFirst().get();
        System.out.print(minGreaterThanSeven3);
        System.out.println();

        //10) Find the half of the elements which are distinct and greater than 5 in reverse order from the list.
        l.stream().distinct().filter(t -> t > 5).map(t-> t/2).sorted(Collections.reverseOrder()).forEach(t-> System.out.print(t + " "));
        System.out.println();
        List <Double> resultList = l.stream().distinct().filter(t -> t > 5).map(t-> t/2.0).sorted(Collections.reverseOrder()).collect(Collectors.toList()); // We can use also Collectors.set. By doing that our list will be unique. However, Collectors.toList is using more.
        System.out.println("Half of the elements list: "+resultList);
        //Functional programming is working in stream but as a result we prefer to have list when you have list it will be a Java object it is better to have. If we use only sorted method it will give us a stream but we can not use it in structured programming. When we have list we can use it in a structured programming as well.

    }
}

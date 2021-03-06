import java.util.List;

public class Utils {

    public static void printInTheSameLineWithASpace (Object o) {
        System.out.print(o + " ");
    }

    public static boolean evenElement(int x) {
       return x%2==0;
    }

    public static boolean oddElement(int x) {
        return x%2==1;
    }

    public static int makeSquare(int x) {
        return x*x;
    }

    public static int makeCube(int x) {
        return x*x*x;
    }

    public static double makeHalf(double x) {
        return x/2;
    }

    public static int digit (int x) {

        int rakam = 0;

        while(x!=0){

            rakam += x%10;
            x/=10;
        }

        return rakam;
    }


}

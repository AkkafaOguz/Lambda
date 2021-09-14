import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Lambda06 {
    public static void main(String[] args) throws IOException {

        //How to read text from the file
        Files.lines(Paths.get("C:\\Users\\90534\\eclipse-workspace\\LambdaSuleymanHoca\\src\\TextFile.txt")).forEach(System.out::println);

        System.out.println("==============================");

        //How to convert all characters in the file to upper case
        Files.lines(Paths.get("C:\\Users\\90534\\eclipse-workspace\\LambdaSuleymanHoca\\src\\TextFile.txt")).map(String::toUpperCase).forEach(System.out::println);

        System.out.println("==============================");

        boolean lambda = Files.lines(Paths.get("C:\\Users\\90534\\eclipse-workspace\\LambdaSuleymanHoca\\src\\TextFile.txt")).anyMatch(t-> t.contains("Lambda"));
        System.out.println(lambda);

        System.out.println("==============================");

        //****** Print distinct words on the console in the file
        Files.lines(Paths.get("C:\\Users\\90534\\eclipse-workspace\\LambdaSuleymanHoca\\src\\TextFile.txt")).map(t-> t.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        System.out.println("==============================");

        //Get the words which end with "e" and print them on the console
        Files.
                lines(Paths.get("C:\\Users\\90534\\eclipse-workspace\\LambdaSuleymanHoca\\src\\TextFile.txt")).
                map(t-> t.split(" ")).
                flatMap(Arrays::stream).
                filter(t-> t.endsWith("e")).
                forEach(System.out::println);

    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda05 {

    //LAMBDA FOR OBJECTS

    public static void main(String[] args) {

        //When you create a method make it flexible in order to make it reusable. (For instance use parameters).
        //It is very important in big projects. By doing that you can also help your friends in the project.

        Course courseTurkishDay = new Course("Summer", "Turkish Day", 97, 128);
        Course courseTurkishNight = new Course("Winter", "Turkish Night", 98, 154);
        Course courseEnglishDay = new Course("Spring", "English Day", 95, 132);
        Course courseEnglishNight = new Course("Winter", "English Night", 93, 144);

        List<Course> coursesList = new ArrayList<>();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseEnglishNight);

        //1) Check if all average scores are greater than 91
        boolean scores = coursesList.stream().allMatch(t-> t.getAverageScore()>91);
        System.out.println(scores);

        //2) Create a method to check if at least one of the course names contains "Turkish" word
        boolean courseName = coursesList.stream().anyMatch(t-> t.getCourseName().contains("Turkish"));
        System.out.println(courseName);

        //3) Print the course whose average score is the highest
        Course result = coursesList.stream().sorted(Comparator.comparing(t -> t.getAverageScore())).reduce((t, u) -> u).get(); //--> By using lambda expression we can not use reversed() method.
        System.out.println(result);

        //3.1))
        Course result2 = coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore).reversed()).findFirst().get();
        System.out.println(result2);
        System.out.println();

        //4)Sort the list elements according to the average score in ascending order and skip first 2 elements
        System.out.println(coursesList.stream().sorted(Comparator.comparing(t -> t.getAverageScore())).skip(2).collect(Collectors.toList()));
        System.out.println();

        //4.1)
        coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(2).collect(Collectors.toList()).forEach(Utils::printInTheSameLineWithASpace);
        System.out.println("\n");

        //5)Sort the list elements according to the average score in ascending order and print just 3rd one
        coursesList.stream().sorted(Comparator.comparing(Course::getAverageScore)).skip(2).limit(1).collect(Collectors.toList()).forEach(Utils::printInTheSameLineWithASpace);



    }
}

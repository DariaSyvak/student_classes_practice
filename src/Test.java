import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */

        Scanner input = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        do {
            System.out.println(UserQuestions.askToJoin);

            if (input.next().toLowerCase().startsWith("y")) {
                try {
                    System.out.println(UserQuestions.askFirstName);
                    String firstN = input.next();
                    System.out.println(UserQuestions.askLastName);
                    String lastN = input.next();
                    System.out.println(UserQuestions.askAge);
                    int age = input.nextInt();
                    Permission.checkAge(age);
                    System.out.println(UserQuestions.askGender);
                    String gender = input.next();
                    System.out.println(UserQuestions.askClassName);
                    String classN = input.next();
                    Permission.checkClassName(classN);

                    students.add(classN.equalsIgnoreCase("math") ?
                            new MathStudent(firstN, lastN, age, gender, classN) :
                            new ScienceStudent(firstN, lastN, age, gender, classN));

                    System.out.println("Congratulations! You are registered for " + classN + " class .");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }

        } while (students.size() < 3);

        int mathC = 0, scienceC = 0;
        for (Student student : students) {
            if (student.getClassName().equalsIgnoreCase("math")) mathC++;
            else scienceC++;
            System.out.println(student);
        }

        System.out.println("Math students = " + mathC +
                "\nScience students = " + scienceC);

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr3part2;

import com.sun.javafx.fxml.expression.BinaryExpression;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author PC
 */
public class PR3part2 {
    // فرع \b 

    static String strTOUper(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        // a,b,c,d حل السؤال الاول بأفرعه 
        //aفرع 
        Consumer<Integer> display = value -> System.out.printf("%d ", value);
        display.accept(50);
        System.out.println(" ");
        //c فرع
        Supplier<String> sup1 = () -> {
            return "Welcome to lambdas!";
        };

        System.out.println(sup1.get());

        System.out.println(strTOUper("aisha dader"));
        //d فرع
        Consumer<Integer> cup = val -> System.out.printf("%d ", val * val * val);
        cup.accept(5);
        System.out.println(" \n End Q1");
//السؤال الثاني 
        final Path file = Paths.get("test.text");
        try (final Stream<String> lines = Files.lines(file)) {
            final Map<Character, Integer> count = lines.
                    flatMap(line -> IntStream.range(0, line.length()).mapToObj(line::charAt)).
                    filter(Character::isLetter).
                    map(Character::toLowerCase).
                    collect(TreeMap::new, (m, c) -> m.merge(c, 1, Integer::sum), Map::putAll);
            count.forEach((letter, c) -> System.out.println(letter + ": " + c));
        } catch (IOException e) {
            System.out.println("Failed to read file.");
            e.printStackTrace(System.out);
        }

        Employee[] employees = {
            new Employee(1, "Ahmad", "IT", 1201),
            new Employee(2, "Sami", "Sales", 950.8),
            new Employee(5, "Huda", "IT", 1010.5),
            new Employee(7, "Ali", "Marketing", 1300),
            new Employee(4, "Hani", "Sales", 1050)
        };

        /* 
        *_*حل السؤال الثالث  
         salry>800&&salary<1200  قام بفلترة الليست حيث جمع من راتبهم 
         map ثم انشأ هذه العناصر بواسط 
       new Stream ثم خزن مجموعة الليست في 
        ثم امر بطباعة  كل العناصر التي تم فلترتها طبع ال التخصص وعدد الموظفين الي تابعين لنفس التخصص
         Dept: Sales, Count: 2
         Dept: IT, Count: 1
         */
        List<Employee> listEmployees = Arrays.asList(employees);
        listEmployees.stream()
                .filter(e -> e.getSalary() >= 800 && e.getSalary() < 1200)
                .map(e -> new Employee(e.getId(), e.getName(), e.getDepartment(), e.getSalary() * 1.02))
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((d, c) -> System.out.println("Dept: " + d + ", Count: " + c));
    }

}

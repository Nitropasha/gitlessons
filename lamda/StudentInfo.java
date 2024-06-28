package lamda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class StudentInfo {
    void  testStudent (ArrayList<Student> a1, Predicate<Student> pr) {
        for(Student s: a1) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }
    }

}
class Test {
    private static double avgOfSmth(List<Student> list, Function<Student, Double> f) {
        double result = 0;
        for (Student st: list) {
            result +=f.apply(st);
        }
        return result / list.size();
    }
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 1, 7.3);
        Student st2 = new Student("Nikolay", 'm', 24, 3, 4.3);
        Student st3 = new Student("Sergey", 'm', 21, 5, 8.9);
        Student st4 = new Student("Elena", 'f', 29, 4, 9.8);
        Student st5 = new Student("Vika", 'f', 22, 2, 8.1);
        ArrayList <Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        StudentInfo info = new StudentInfo();

        //Function<Student, Double> f = student -> student.avgGrade;

        double res = avgOfSmth(students, student1 -> (double) student1.age);
        System.out.println(res);



//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.courece-s2.courece;
//            }
//        });
//        Collections.sort(students, (stu1, stu2) -> stu1.courece-stu2.courece);
//        System.out.println(students);
//        info.testStudent(students, new CheckOverGrade());
//        System.out.println("-----------");

//        info.testStudent(students, new StudentCheck() {
//            @Override
//            public boolean check(Student s) {
//                return s.age< 23;
//            }
//        });

//        System.out.println("------0 -----");
//       Predicate<Student> sc =  (Student p) -> {return p.avgGrade>8;};
//       info.testStudent(students, sc);
//        System.out.println("------1 -----");
//        info.testStudent(students, (Student p) -> {return p.avgGrade>8;});
//        System.out.println("------1.1 -----");
//        info.testStudent(students, p ->  p.avgGrade>8);
//        System.out.println("------2-----");
//        info.testStudent(students, (Student p) -> {return p.age< 23;});
//        System.out.println("-------3----");
//        info.testStudent(students, (Student p) -> {return p.age> 20 && p.avgGrade>8 && p.sex== 'm' ;});


//        StudentInfo info = new StudentInfo();
//        info.printStudentsOverGrade(students,8);
//        System.out.println("----------------");
//        info.printStudentsUnderAge(students, 30);
//        System.out.println("----------------");
//        info.printStudentsMix(students, 20, 8, 'm');
    }
}
//
//interface StudentCheck {
//    boolean check(Student s);
//}
//class CheckOverGrade implements StudentCheck {
//    @Override
//    public  boolean check (Student s) {
//        return s.avgGrade>8;
//    }
//}

package Stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream_two {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 1, 7.3);
        Student st2 = new Student("Nikolay", 'm', 24, 3, 4.3);
        Student st3 = new Student("Sergey", 'm', 21, 5, 8.9);
        Student st4 = new Student("Alina", 'f', 29, 4, 9.8);
        Student st5 = new Student("Vika", 'f', 22, 2, 8.1);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        students = students.stream().sorted((x,y) ->
                x.getName().compareTo(y.getName())).collect(Collectors.toList());
        System.out.println(students);

//        students = students.stream().filter(element
//                ->element.getAge()>22 && element.getAvgGrade()<7.7)
//                .collect(Collectors.toList());
//        System.out.println(students);

        Stream<Student> myStream = Stream.of(st1, st2, st3, st4, st5);
        System.out.println(
                myStream.filter(
                        element ->element.getAge()>22 && element.getAvgGrade()<7.7)
                        .collect(Collectors.toList())
        );

    }
}
class Student {
    private String name;
    private char sex;
    private int age;
    private int courece;
    private double avgGrade;

    public Student(String name, char sex, int age, int courece, double avgGrade) {
        this.setName(name);
        this.setSex(sex);
        this.setAge(age);
        this.setCourece(courece);
        this.setAvgGrade(avgGrade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourece() {
        return courece;
    }

    public void setCourece(int courece) {
        this.courece = courece;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", courece=" + courece +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
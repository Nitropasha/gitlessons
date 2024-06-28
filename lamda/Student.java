package lamda;

public class Student {
    String name;
    char sex;
    int age;
    int courece;
    double avgGrade;

    public Student(String name, char sex, int age, int courece, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.courece = courece;
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

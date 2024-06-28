package comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class comparable_test {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Zaur", "Tregulov", 1000);
        Employee emp2 = new Employee(15, "Ivan", "Petrov", 2000);
        Employee emp3 = new Employee(10, "Avan", "Durak", 1000);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println(list);
        System.out.println("     ");
        Collections.sort(list);
        System.out.println(list);
    }
}

class Employee implements Comparable <Employee> {
    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    int id;
    String name;
    String surname;
    int salary;

    @Override
    public String toString() {
        return "Работник номер " +
                 id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }


    @Override
    public int compareTo(Employee o) {
//        if (this.id == o.id) {
//        return 0; } else if (this.id < o.id) {
//            return -1;
//
//        }
//        else {
//            return 1;
//        }
        // а можно вот так
        return this.name.compareTo(o.name);
    }
}

package comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparator_test  {
    public static void main(String[] args) {
        List<Employee2> list = new ArrayList<>();
        Employee2 emp1 = new Employee2(100, "Zaur", "Tregulov", 1000);
        Employee2 emp2 = new Employee2(15, "Avan", "Petrov", 2000);
        Employee2 emp3 = new Employee2(10, "Ivan", "Durak", 1000);

        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println(list);
        System.out.println("     ");
        Collections.sort(list, new idComparator());
        System.out.println(list);
        Collections.sort(list, new nameComparator());
        System.out.println(list);
    }
}

class Employee2
//        implements Comparable <Employee>
        {
    public Employee2(int id, String name, String surname, int salary) {
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




}

class idComparator implements Comparator<Employee2> {
    @Override
    public int compare(Employee2 o1, Employee2 o2) {
        if (o1.id == o2.id) {
            return 0; } else if (o1.id < o2.id) {
            return -1;

        }
        else {
            return 1;
        }
    }
}

class nameComparator implements Comparator<Employee2> {
    @Override
    public int compare(Employee2 o1, Employee2 o2) {
         return o1.name.compareTo(o2.name);
    }
}
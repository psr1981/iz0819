package com.iz0819.www.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student implements Comparable<Student> {
    String name;
    int age;
    int phone;
    Student(String name, int age, int phone) {
        this.name=name;
        this.age=age;
        this.phone=phone;
    }

    @Override
    public String toString(){
        return "[ name : " + this.name + ", age :"  + this.age +", phone : " + this.phone + "]";
    }

    int getAge(){
        return this.age;
    }

    int getPhone() {
        return this.phone;
    }

    @Override
    public int compareTo(Student o) {
        if (this.age<o.age) {
            return -1;
        }
        else if (this.age>o.age) {
            return 1;
        }
        return 0;
    }
}

class nameComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class StudentsList {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("ram", 20, 123123123));
        studentList.add(new Student("bharat", 18, 89323123));
        studentList.add(new Student("abhishek", 10, 345323123));
        studentList.add(new Student("hanuman", 28, 90323123));

        List<Student> st1 =  studentList.stream().filter(x -> x.age>10).collect(Collectors.toList());
        st1.stream().forEach(System.out::println);
        System.out.println();

        Collections.sort(studentList);
        studentList.stream().forEach(System.out::println);

        System.out.println();
        System.out.println(studentList.stream().min(Comparator.comparing(Student::getAge)).get());

        System.out.println();
        System.out.println(studentList.stream().max(Comparator.comparing(Student::getAge)).get());

        // name comparator
        System.out.println();
        Collections.sort(studentList, new nameComparator());
        studentList.stream().forEach(System.out::println);

        System.out.println();
        System.out.println(studentList.stream().map(x -> x.getAge()).reduce( (a,b) -> a + b ).get());

    }
}

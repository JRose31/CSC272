// Student & Instructor

public static class Person {
    public String name;
    public int birth_year;
}

public static class Student extends Person {
    public String major;

    @Override
    public String toString() {
        return name + "\nBorn: " + birth_year + "\nMajor: " + major;
    };
}

public static class Instructor extends Person {
    public int salary;

    @Override
    public String toString() {
        return name + "\nBorn: " + birth_year + "\nSalary (USD): " + salary;
    };
}

void main() {
    Student student = new Student();
    student.name = "Jamaine Roseborough";
    student.birth_year = 1998;
    student.major = "Computer Science";
    System.out.println("========= Student ==========");
    System.out.println(student.toString());

    Instructor instructor = new Instructor();
    instructor.name = "Robin Yang";
    instructor.birth_year = 1987;
    instructor.salary = 90000;
    System.out.println("\n========= Instructor ==========");
    System.out.println(instructor.toString());
}

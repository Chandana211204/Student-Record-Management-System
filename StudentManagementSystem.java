import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting program.");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No records found.");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : studentList) {
                s.display();
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());
                System.out.print("Enter new marks: ");
                s.setMarks(sc.nextDouble());
                System.out.println("Student record updated.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = studentList.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
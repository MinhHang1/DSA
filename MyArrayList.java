/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagerApp2;

/**
 *
 * @author Minh Hang
 */
import java.util.ArrayList;
import java.util.Stack;

public class MyArrayList {
    private ArrayList<Student> students = new ArrayList<>();
    private Stack<Student> deletedStudents = new Stack<>(); // Stack chứa sinh viên đã xóa

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Added student: " + student);
    }

    public boolean editStudent(int id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.id == id) {
                student.name = newName;
                student.marks = newMarks;
                System.out.println("Updated student with ID: " + id);
                return true;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return false;
    }

    public boolean deleteStudent(int id) {
        for (Student student : students) {
            if (student.id == id) {
                deletedStudents.push(student); // Thêm vào stack deletedStudents
                students.remove(student);      // Xóa khỏi danh sách chính
                System.out.println("Deleted student with ID: " + id);
                return true;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return false;
    }

    public Student popDeletedStudent() {
        if (deletedStudents.isEmpty()) {
            System.out.println("No deleted students to restore.");
            return null;
        }
        Student restoredStudent = deletedStudents.pop();
        students.add(restoredStudent);
        System.out.println("Restored deleted student: " + restoredStudent);
        return restoredStudent;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.println("Students in List:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
// Sắp xếp sinh viên theo điểm bằng thuật toán Bubble Sort
    public void bubbleSortByMarks() {
        int n = students.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).marks < students.get(j + 1).marks) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Students sorted by marks.");
    }
    
    // Sắp xếp sinh viên theo tên bằng thuật toán Bubble Sort
    public void bubbleSortByName() {
        int n = students.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // So sánh tên sinh viên tại vị trí j và j+1
                if (students.get(j).name.compareTo(students.get(j + 1).name) > 0) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Students sorted by name.");
    }


    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
        return null;
    }
}

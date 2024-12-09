/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManagerApp2;

import java.util.ArrayList;
import java.util.InputMismatchException;
  import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyArrayList myArrayList = new MyArrayList();

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Sort Students by Name"); // Thêm tùy chọn sắp xếp theo tên
            System.out.println("7. Search for Student by ID");
            System.out.println("8. Pop Last Deleted Student");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
             
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ dòng còn lại sau khi nhập số

                switch (choice) {
                    case 1: // Thêm sinh viên
                        int id = 0;
                        while (true) {
                            try {
                                System.out.print("Enter Student ID: ");
                                id = scanner.nextInt();
                                scanner.nextLine(); // Đọc bỏ dòng còn lại
                                break; // Nếu nhập đúng, thoát khỏi vòng lặp
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter a valid ID.");
                                scanner.nextLine(); // Đọc bỏ dòng lỗi
                            }
                        }

                        String name = "";
                        while (true) {
                            try {
                                System.out.print("Enter Student Name: ");
                                name = scanner.nextLine();
                                if (!name.matches("[a-zA-Z ]+")) { // Kiểm tra tên có phải là chữ cái
                                    throw new IllegalArgumentException("Name must contain only letters and spaces.");
                                }
                                break; // Nếu tên hợp lệ, thoát khỏi vòng lặp
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        double marks = 0;
                        while (true) {
                            try {
                                System.out.print("Enter Student Marks: ");
                                marks = scanner.nextDouble();
                                scanner.nextLine(); // Đọc bỏ dòng còn lại
                                if (marks < 0 || marks > 10) {
                                    throw new IllegalArgumentException("Marks must be between 0 and 10.");
                                }
                                break; // Nếu điểm hợp lệ, thoát khỏi vòng lặp
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter a valid mark.");
                                scanner.nextLine(); // Đọc bỏ dòng lỗi
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        myArrayList.addStudent(new Student(id, name, marks));
                        break;

                    case 2: // Chỉnh sửa sinh viên
                        int editId = 0;
                        while (true) {
                            try {
                                System.out.print("Enter Student ID to edit: ");
                                editId = scanner.nextInt();
                                scanner.nextLine();
                                break; // Nếu nhập đúng ID, thoát khỏi vòng lặp
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter a valid ID.");
                                scanner.nextLine(); // Đọc bỏ dòng lỗi
                            }
                        }

                        String newName = "";
                        while (true) {
                            try {
                                System.out.print("Enter new name: ");
                                newName = scanner.nextLine();
                                if (!newName.matches("[a-zA-Z ]+")) { // Kiểm tra tên hợp lệ
                                    throw new IllegalArgumentException("Name must contain only letters and spaces.");
                                }
                                break; // Nếu tên hợp lệ, thoát khỏi vòng lặp
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        double newMarks = 0;
                        while (true) {
                            try {
                                System.out.print("Enter new marks: ");
                                newMarks = scanner.nextDouble();
                                scanner.nextLine(); // Đọc bỏ dòng còn lại
                                if (newMarks < 0 || newMarks > 10) {
                                    throw new IllegalArgumentException("Marks must be between 0 and 10.");
                                }
                                break; // Nếu điểm hợp lệ, thoát khỏi vòng lặp
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter a valid mark.");
                                scanner.nextLine(); // Đọc bỏ dòng lỗi
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        myArrayList.editStudent(editId, newName, newMarks);
                        break;

                    case 3: // Xóa sinh viên
                        int deleteId = 0;
                        while (true) {
                            try {
                                System.out.print("Enter Student ID to delete: ");
                                deleteId = scanner.nextInt();
                                scanner.nextLine();
                                break; // Nếu nhập đúng ID, thoát khỏi vòng lặp
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter a valid ID.");
                                scanner.nextLine(); // Đọc bỏ dòng lỗi
                            }
                        }

                        myArrayList.deleteStudent(deleteId);
                        break;

                    case 4: // Hiển thị tất cả sinh viên
                        myArrayList.displayStudents();
                        break;

                    case 5: // Sắp xếp theo điểm
                        myArrayList.bubbleSortByMarks();
                        System.out.println("Sorted Students by Marks:");
                        myArrayList.displayStudents();
                        break;

                    case 6: // Sắp xếp theo tên
                        myArrayList.bubbleSortByName();
                        System.out.println("Sorted Students by Name:");
                        myArrayList.displayStudents();
                        break;

                    case 7: // Tìm kiếm theo ID
                        int searchId = 0;
                        while (true) {
                            try {
                                System.out.print("Enter Student ID to search: ");
                                searchId = scanner.nextInt();
                                scanner.nextLine();
                                break; // Nếu nhập đúng ID, thoát khỏi vòng lặp
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Please enter a valid ID.");
                                scanner.nextLine(); // Đọc bỏ dòng lỗi
                            }
                        }

                        Student foundStudent = myArrayList.searchStudent(searchId);
                        if (foundStudent != null) {
                            System.out.println("Found student: " + foundStudent);
                        }
                        break;

                    case 8: // Khôi phục sinh viên bị xóa
                        Student restoredStudent = myArrayList.popDeletedStudent();
                        if (restoredStudent != null) {
                            System.out.println("Restored student: " + restoredStudent);
                        }
                        break;

                    case 9: // Thoát
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice! Please enter a number between 1 and 9.");
                scanner.nextLine(); // Đọc bỏ dòng lỗi
            }
        }
    }
}
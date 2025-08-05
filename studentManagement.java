
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

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getMarks(){
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}
class studentManagement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

         while (true) {
            System.out.println("\n====== Student Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
         

         switch (choice){
             case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    students.add(new Student(id, name, marks));
                    System.out.println("Student added successfully.");
                 break;
            case 2:
                    if(students.isEmpty()){
                        System.out.println("No students found.");
                    } 
                    else {
                        System.out.println("List of Students:");
                        for (Student stud : students) {
                            System.out.println(stud);
                        }
                    }
                 break;
            case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    boolean found = false;
                    for (Student stud : students) {
                        if (stud.getId() == updateId) {
                            found = true;
                            sc.nextLine(); 
                            System.out.print("Enter new Name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter new Marks: ");
                            double newMarks = sc.nextDouble();
                            stud.setName(newName);
                            stud.setMarks(newMarks);
                            System.out.println("Student updated successfully.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
            case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = sc.nextInt();
                    found = false;
                    for(Student stud : students) {
                        if (stud.getId() == deleteId) {
                            found = true;
                            students.remove(stud);
                            System.out.println("Student deleted successfully.");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
            case 5:
                    System.out.println("Exiting the Student Management System.");
                    sc.close();
                    System.exit(0);
                    break;

                    
             default:
                    System.out.println("Invalid choice. Please try again.");
         }
        }
    }
}
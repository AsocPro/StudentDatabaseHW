/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.Scanner;

/**
 *
 * @author Zachary Pratt Gibbs
 */
public class Backend 
{
    private BinarySearchTree data;
    private Scanner scr;
    public Backend()
    {
        data = new BinarySearchTree();
        scr = new Scanner(System.in);
    }
    public boolean mainMenu()
    {
        System.out.println("Student Database");
        System.out.println("");
        System.out.println("1. Add a Student");
        System.out.println("2. Delete a Student");
        System.out.println("--List Students by:");
        System.out.println("3. All Students");
        System.out.println("4. A Specific Major");
        System.out.println("5. GPA above a value");
        System.out.println("6. BPA below a value");
        System.out.println("");
        System.out.println("Other Key will Exit");
        String choice = scr.next();
        switch(choice)
        {
            case "1":
                this.add();
                break;
            case "2":
                this.delete();
                break;
            case "3":
                this.list(1);
                break;
            case "4":
                this.list(2);
                break;
            case "5":
                this.list(3);
                break;
            case "6":
                this.list(4);
                break;
            default:
                System.out.println("Invalid Input\nProgram Exiting");
                return false;
        }
        return true;
    }
    private void add()
    {
        System.out.println("Enter a student number.");
        int num = scr.nextInt();
        System.out.println("Enter a last name for the student");
        String last = scr.next();
        scr.reset();
        System.out.println("Enter a first name for the student");
        String first = scr.next();
        scr.reset();
        System.out.println("Enter a major for the student");
        String major = scr.next();
        scr.reset();
        System.out.println("Enter a GPA for the student");
        double gpa = scr.nextDouble();
        data.add(new Student(num, last, first, major, gpa));
    }
    private void delete()
    {
        System.out.println("Enter the student number to delete");
        int num = scr.nextInt();
        BSTNode<Student> stu = data.find(new Student(num, "",""));
        Student deleted = new Student(stu.getElement().getNumber(),
                stu.getElement().getLastName(), stu.getElement().getFirstName(),
                stu.getElement().getMajor(), stu.getElement().getGpa());
        boolean worked = data.remove(stu);
        System.out.println("You deleted this student");
        System.out.println(deleted);
    }
    private void list(int type)
    {
        switch(type)
        {
            case 1:
                data.traverseInOrder(new StudentAll());
                break;
            case 2:
                
                StudentMajor visitMajor = new StudentMajor();
                System.out.println("Type the major to search for and press enter.");
                String major = scr.next();
                visitMajor.setMajor(major);
                data.traverseInOrder(visitMajor);
                
                break;
            case 3:
                StudentGPAHigher visitGPAHigh = new StudentGPAHigher();
                System.out.println("Enter the GPA threshhold.");
                double thresh = scr.nextDouble();
                visitGPAHigh.setThreshhold(thresh);
                data.traverseInOrder(visitGPAHigh);
                
                break;
            case 4:
                StudentGPALower visitGPALow = new StudentGPALower();
                System.out.println("Enter the GPA threshhold.");
                double thresh2 = scr.nextDouble();
                visitGPALow.setThreshhold(thresh2);
                data.traverseInOrder(visitGPALow);
                break;
        }
    }
}

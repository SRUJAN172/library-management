import  java.util.*;
public class Student {
    public  String stdName;
    public String regNum;
    List<Book> borrowedBooks = new ArrayList<>();

    Student()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Student name: ");
        this.stdName = sc.nextLine();
        System.out.println("Enter the register number:");
        this.regNum = sc.nextLine();
    }


    public  void getDetails()
    {
        System.out.println("Student name: "+this.stdName);
        System.out.println("Student registered number:"+this.regNum);
    }




}


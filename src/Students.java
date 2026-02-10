
import java.awt.desktop.SystemEventListener;
import  java.util.*;
public class Students {
    Scanner sc = new Scanner(System.in);
    public  List<Student> TheStudents = new ArrayList<>();

    public  void addStudent(Student s)
    {
        for(Student std:TheStudents)
        {
            if(s.regNum.equalsIgnoreCase(std.regNum))
            {
                System.out.println("The student is already registered");
                return;
            }
        }

        TheStudents.add(s);


    }

    public  void showAllStudents()
    {
        System.out.println("|  Student name  |  registered number |");
        for(Student std:TheStudents)
        {
            System.out.println("|  "+std.stdName+"  |  "+std.regNum+"  |");
        }
        System.out.println();
    }


    public  int isStudent()
    {
        System.out.println("Enter the registered number");
        String  s = sc.nextLine();
        for(Student std:TheStudents)
        {
            if(s.equalsIgnoreCase(std.regNum))
            {
                return TheStudents.indexOf(std) ;
            }
        }

        return  -1;
    }

    public  void checkOutBook(Books book)
    {
        int index = this.isStudent();

        if(index != -1) {
            book.showAllBooks();
            Book b = book.checkOut();

            if (b != null)
                if (TheStudents.get(index).borrowedBooks.size() < 3) {
                    TheStudents.get(index).borrowedBooks.add(b);
                } else {

                    System.out.println("the Student had  already borrowed three books");
                }
        }
        else
        {
            System.out.println("the student is not registered");
        }

    }


    public void checkInBook(Books book)
    {

        int index = this.isStudent();
        if(index == -1)
        {
            System.out.println("The book is not available");
            return;
        }

        Student s = TheStudents.get(index);

        if(s.borrowedBooks.isEmpty())
        {
            System.out.println("the student has not borrowed any book");
            return;
        }

        System.out.println("enter the serial number of the book for return: ");
        int sno = sc.nextInt();

        Iterator<Book> it = s.borrowedBooks.iterator();

        while (it.hasNext())
        {
            Book a = it.next();
            if(a.sNo == sno)
            {
                book.checkIn(a);
                it.remove();

                System.out.println("the book checked successfully");
                return;
            }
        }



    System.out.println("this student did'nt borrow book");
    }



}

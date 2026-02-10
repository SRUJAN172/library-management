import  java.util.*;

public class Book {
    // book class is created

    public  int sNo;
    public  String bookName;
    public String author;
    public  int  bookQty;
    public int bookPhotocopy;




    // book attributes are initialized

    Scanner sc = new Scanner(System.in);

    Book()
    {
        System.out.println("Enter the serial number : ");
        this.sNo = sc.nextInt();
        sc.nextLine();

        System.out.println("enter the bookName: ");
        this.bookName = sc.nextLine();

        System.out.println("Enter the author name: ");
        this.author = sc.nextLine();

        System.out.println("Enter the Quantity of books:");
        this.bookQty = sc.nextInt();
        this.bookPhotocopy = bookQty;
    }


    public int getsNo()
    {
        return  this.sNo;
    }

    public  String getBookName()
    {
        return  this.bookName;
    }

    public  String getAuthor()
    {
        return  this.author;
    }

    public  int getBookQty()
    {
        return  this.bookQty;
    }





    public void getDetails()
    {
        System.out.println("--------------------");
        System.out.println("Serial no: " + sNo);
        System.out.println("Book name: " + bookName);
        System.out.println("Author: " + author);
        System.out.println("Available quantity: " + bookQty);
    }


}

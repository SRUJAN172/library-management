import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Books {

    public  List<Book> TheBooks= new  ArrayList<>();

    public  int compareBookObj(Book b1, Book b2)
    {
        if(b1.bookName.equalsIgnoreCase(b2.bookName))
        {
            System.out.println("The book of this Name already exists");
            return 0;
        }

        if(b1.sNo == b2.sNo)
        {
            System.out.println("The book of serial number already exixts");
            return 0;
        }

        return 1;
    }


    public  void addBook(Book b)
    {
        for(Book b2:TheBooks) {
            if (this.compareBookObj(b, b2) == 0)
                return;
        }

        TheBooks.add(b);
    }

    public  void searchBySno()
    {
        int sno;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the serial number to search: ");
        sno = sc.nextInt();
        boolean flag = false;
        for(Book a:TheBooks)
        {
            if(sno == a.sNo)
            {
                a.getDetails();
                flag = true;
                return;
            }
        }

        if(!flag)
        {
            System.out.println("no book is found");
        }
    }

    public  void searchByAuthor()
    {
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a author name to search: ");
        name = sc.nextLine();

        for(Book b:TheBooks)
        {
            if (b.author.equalsIgnoreCase(name)) {
                b.getDetails();
                return;
            }
        }

        System.out.println("no author is found");
    }

    public  void showAllBooks()
    {
        System.out.println("The List of books");
        System.out.println("|"+"sNo"+"|"+"bookName"+"|"+"author"+"|"+"quantity"+"|");
        for(Book b:TheBooks)
        {
            System.out.println("|"+b.getsNo()+"|"+b.getBookName()+"|"+b.getAuthor()+"|"+b.bookPhotocopy+"|");
        }
        System.out.println();
    }



    public void UpgradeBookQty()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\t\t\t\tUpgrade book quantity\t\t\t\t\t");
        System.out.println("Enter the serial number of book to add in the library: ");
        int sno = sc.nextInt();
        for(Book b:TheBooks)
        {
            if(sno == b.sNo)
            {
                System.out.print("Enter the quantity to add: ");
                int addQuantity =  sc.nextInt();
                b.bookQty += addQuantity;
                b.bookPhotocopy = b.bookQty;
                return;
            }
        }

        System.out.println("the book not found");

    }


    public  int isAvailable(int sno){

        for(int i=0;i<TheBooks.size();i++)
        {
            Book b = TheBooks.get(i);
            if(sno == b.sNo)
            {
                if(b.bookPhotocopy > 0) {
                    return i;
                }
            }
        }

        return -1;
    }


    public Book checkOut()
    {
        int sno;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book serial to Check out: ");
        sno = sc.nextInt();
        int index = isAvailable(sno);
        if(index == -1)
        {
            System.out.println("The book is not available");
            return  null;
        }

        Book  b = TheBooks.get(index);
        b.bookPhotocopy--;
        return b;

    }


    public void checkIn(Book b)
    {

       for(Book a:TheBooks)
       {
           if(a.sNo == b.sNo)
           {
               a.bookPhotocopy++;
               return;
           }
       }

    }


    public  void displayMenu() {
        System.out.println();
        System.out.println("1 Add Book");
        System.out.println("0 Exit Application");
        System.out.println("2 Upgrade the quantity of the books");
        System.out.println("3 Search for the book");
        System.out.println("4 Show All books ");
        System.out.println("5 Register a  Student");
        System.out.println("6 Show all registered Students");
        System.out.println("7 CheckOut Book");
        System.out.println("8 CheckIn Book");
        System.out.println();
    }

}

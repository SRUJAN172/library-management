
import java.util.*;

public class Main {

    
    public static void main(String[] args)
    {
       
        Scanner input = new Scanner(System.in);

        System.out.println(
                "********************Welcome to the  Library!********************");
        System.out.println(
                "                  Select From The Following Options:               ");
        System.out.println(
                "**********************************************************************");

        
        Books ob = new Books();
      
        Students obStudent = new Students();

        int choice;
        int searchChoice;

     
        do {

            ob.displayMenu();
            choice = input.nextInt();

 
            switch (choice) {

 
                case 1:
                    Book b = new Book();
                    ob.addBook(b);
                    break;


                case 2:
                    ob.UpgradeBookQty();
                    break;

                case 3:

                    System.out.println(
                            " press 1 to Search with Book Serial No.");
                    System.out.println(
                            " Press 2 to Search with Book's Author Name.");
                    searchChoice = input.nextInt();

               
                    switch (searchChoice) {


                        case 1:
                            ob.searchBySno();
                            break;

                 
                        case 2:
                            ob.searchByAuthor();
                    }
                    break;

           
                case 4:
                    ob.showAllBooks();
                    break;

            
                case 5:
                    Student s = new Student();
                    obStudent.addStudent(s);
                    break;

          
                case 6:
                    obStudent.showAllStudents();
                    break;

           
                case 7:
                    obStudent.checkOutBook(ob);
                    break;

           
                case 8:
                    obStudent.checkInBook(ob);
                    break;

                
                default:

                   
                    System.out.println("ENTER BETWEEN 0 TO 8.");
            }

        }

        // Checking condition at last where we are
        // checking case entered value is not zero
        while (choice != 0);
    }
}

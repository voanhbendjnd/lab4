
import java.util.ArrayList;
import java.util.Scanner;
// Locale.setDefault(Locale.US);

/**
 *
 * @author Vo Anh Ben - CE190709
 */
public class JavaApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean checkBigRing = true;
        BookManagement bk = new BookManagement();
        while (checkBigRing) {
            System.out.println("----- BOOK MANAGEMENT -----");
            System.out.println("1. Adds new book.");
            System.out.println("2. Shows all books.");
            System.out.println("3. The biggest size book.");
            System.out.println("4. Search a book by ID.");
            System.out.println("5. Sort the list of books ascending by size.");
            System.out.println("6. Quit.");
            System.out.print("Please select a function: ");
            String n = sc.nextLine();
            switch (n) {
                case "1":
                    bk.entryData(); 
                    break;
                case "2":
                    bk.printData();
                    break;
                case "3":
                    ArrayList<Book> list = new ArrayList<>();
                    list.addAll(bk.biggestSize());
                    int cnt = 1;
                    for (Book x : list) {
                        System.out.print(cnt++);
                        x.showInfor();
                    }
                    break;
                case "4":
                    System.out.print(">>> Please enter book's ID to search: ");
                    String id = sc.nextLine();
                    System.out.print("Search Results: ");
                    if (bk.searchBookById(id) == -1) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("");
                        System.out.print("1");
                        bk.searchBookObjectById(id).showInfor();
                    }
                    break;
                case "5":
                    bk.sort();
                    break;
                case "6":
                    System.out.println("THANK FOR USING OUR APPLICATION!");
                    System.out.println("SEE YOU AGAIN");
                    checkBigRing = false;
                default:
                    System.out.println("The function of application must be from 1 to 6!");

            }
        }
    }
}

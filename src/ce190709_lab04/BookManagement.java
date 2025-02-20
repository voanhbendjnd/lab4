
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;
// Locale.setDefault(Locale.US);

/**
 *
 * @author Vo Anh Ben - CE190709
 */
public class BookManagement {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Book> listEBook = new ArrayList<>();

    public BookManagement() {
    }

    public BookManagement(ArrayList<Book> listBook) {
        this.listEBook = listBook;
    }

    public void entryData() {
        boolean check = true;
        while (check) {
            System.out.println("---- Add new ebook ----");
            String id;
            while (true) {
                // kiểm tra id xem có bị trùng hem
                boolean checkValidateId = true;
                System.out.print("Input ID: ");
                id = sc.nextLine();
                for(Book x : this.listEBook){
                    if(id.equals(x.getId())){
                        checkValidateId = false;
                    }
                }
                if (id.length() != 5 || !checkValidateId) {
                    System.out.println("ID must be exactly 5 characters and no duplicated with exist ID in Database(your list).");
                    continue;
                } else {
                    break;
                }
            }
            String name;
            while (true) {
                System.out.print("Input name: ");
                name = sc.nextLine();
                if (name.trim().isEmpty()) {
                    System.out.println("Name not empty");
                    continue;
                } else {
                    break;
                }
            }
            int year;
            while (true) {
                System.out.print("Input year: ");
                year = sc.nextInt();
                if (year < 1800 || year > 2025) {
                    System.out.println("Year must be in range 1800 to 2025 and not empty");
                    continue;
                } else {
                    break;
                }
            }
            sc.nextLine();
            String author;
            while (true) {
                System.out.print("Input authors: ");
                author = sc.nextLine();
                if (author.trim().isEmpty()) {
                    System.out.println("Author not empty");
                    continue;
                } else {
                    break;
                }
            }
            int size;
            while (true) {
                System.out.print("Input size (kilobyte): ");
                String sizeIn = sc.nextLine();
                if(sizeIn.trim().isEmpty()){
                    System.out.println("Size must be greater than 0 and not empty");
                    continue;
                }
                size = Integer.parseInt(sizeIn);
                if (size <= 0) {
                    System.out.println("Size must be greater than 0 and not empty");
                    continue;
                }
                else{
                    break;
                }
            }
            this.listEBook.add(new Book(id, name, year, author, size));
            System.out.println("Ebook created and added to list of ebooks successful!");
            break;
        }

    }

    public ArrayList<Book> getListBook() {
        return listEBook;
    }

    public void setListBook(ArrayList<Book> listBook) {
        this.listEBook = listBook;
    }

    public void printData() {
        int cnt = 1;
        for (Book x : this.listEBook) {
            System.out.print(cnt++);
            x.showInfor();
        }
    }

    public void sort() {
        ArrayList<Book> list = new ArrayList<>();
        for (Book x : this.listEBook) {
            list.add(x);
        }
        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getSize() - o2.getSize();
            }

        });

        int cnt = 1;
        for (Book x : list) {
            System.out.print(cnt++);
            x.showInfor();
        }

    }

    public int searchBookById(String id) {
        for (int i = 0; i < this.listEBook.size(); i++) {
            if (id.equals(this.listEBook.get(i).getId())) {
                return i;
            }
        }
        return -1;

    }

    public Book searchBookObjectById(String id) {
        int cnt = 1;
        for (Book x : this.listEBook) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        return null;
    }

    public ArrayList<Book> biggestSize() {
        int maxSize = -1;
        for (Book x : this.listEBook) {
            if (maxSize <= x.getSize()) {
                maxSize = x.getSize();
            }
        }
        ArrayList<Book> book = new ArrayList<>();
        for (Book x : this.listEBook) {
            if (x.getSize() == maxSize) {
                book.add(x);
            }
        }
        return book;
    }
}

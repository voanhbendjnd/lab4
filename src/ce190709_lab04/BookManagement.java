
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.stream.Collectors;
import java.io.PrintStream;
import static java.lang.Character.isDigit;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.List;
// Locale.setDefault(Locale.US);

/**
 *
 * @author Vo Anh Ben - CE190709
 */
public class BookManagement {

    Scanner sc = new Scanner(System.in);
    private ArrayList<Book> listBook = new ArrayList<>();

    public BookManagement() {
    }

    public BookManagement(ArrayList<Book> listBook) {
        this.listBook = listBook;
    }

    public void entryData() {
        System.out.println("---- Add new ebook ----");
        System.out.print("Input ID: ");
        String id = sc.nextLine();
        System.out.print("Input name: ");
        String name = sc.nextLine();
        System.out.print("Input year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Input authors: ");
        String author = sc.nextLine();
        System.out.print("Input size: ");
        int size = sc.nextInt();
        sc.nextLine();
        this.listBook.add(new Book(id, name, year, author, size));
    }

    public ArrayList<Book> getListBook() {
        return listBook;
    }

    public void setListBook(ArrayList<Book> listBook) {
        this.listBook = listBook;
    }

    public void printData() {
        int cnt = 1;
        for (Book x : this.listBook) {
            System.out.print(cnt++);
            x.showInfor();
        }
    }

    public void sort() {
        Collections.sort(this.listBook, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getSize() - o2.getSize();
            }

        });
        int cnt = 1;
        for (Book x : this.listBook) {
            System.out.print(cnt++);
            x.showInfor();
        }
    }

    public int searchBookById(String id) {
        for (int i = 0; i < this.listBook.size(); i++) {
            if (id.equals(this.listBook.get(i).getId())) {
                return i;
            }
        }
        return -1;

    }

    public Book searchBookObjectById(String id) {
        int cnt = 1;
        for (Book x : this.listBook) {
            if (id.equals(x.getId())) {
                x.showInfor();
                break;
            }
        }
        return new Book();

    }

    public ArrayList<Book> biggestSize() {
        int maxSize = -1;
        for (Book x : this.listBook) {
            if (maxSize <= x.getSize()) {
                maxSize = x.getSize();
            }
        }
        ArrayList<Book> book = new ArrayList<>();
        for (Book x : this.listBook) {
            if (x.getSize() == maxSize) {
                book.add(x);
            }
        }
        int cnt = 1;
        BookManagement mn = new BookManagement();
        for (Book x : book) {
            System.out.print(cnt++);
            x.showInfor();
        }
        return book;
    }
}

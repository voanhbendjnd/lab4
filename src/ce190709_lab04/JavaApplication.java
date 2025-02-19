/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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
                    System.out.println("Ebook created and added to list of ebooks successful!");
                    break;
                case "2":
                    bk.printData();
                    break;
                case "3":
                    bk.biggestSize();
                    break;
                case "4":
                    System.out.print(">>> Please enter book's ID to search: ");
                    String id = sc.nextLine();
                    System.out.print("Search Results: ");
                    if (bk.searchBookById(id) == -1) {
                        System.out.print("Not found");
                    }
                    else{
                        System.out.println("");
                        bk.searchBookObjectById(id);
                       }
                  break;
                case "5":
                    bk.sort();
                case "6":
                    System.out.println("THANK FOR USING OUR APPLICATION!");
                    System.out.println("SEE YOU AGAIN");
                default:

            }
        }
    }
}

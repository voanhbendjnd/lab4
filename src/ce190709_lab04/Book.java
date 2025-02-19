/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vo Anh Ben - CE190709
 */
public class Book {
    private String ID;
    private String name;
    private int year;
    private String author;
    private int size;

    public Book(String id, String name, int year, String author, int size) {
        this.ID = id;
        this.name = name;
        this.year = year;
        this.author = author;
        this.size = size;
    }

    public Book() {
    }

    public String getId() {
        return ID;
    }

    public void setId(String id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void showInfor(){
        System.out.println(String.format(". [%s]%s - (%d) - %s - %sKB", this.ID, this.author, this.year, this.name, this.size));
    }
}
package com.horizon.labspring.repository;

import com.horizon.labspring.model.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookRepository {


    private final List<Book> books = new ArrayList<>();


    public void add(Book book) {
        books.add(book);
    }


    public Book get(int id) {
        for (Book book : books) {
            if (book.getId() == id)
            {
                return book;
            }
        }
        return null; // Not found
    }


    public boolean SearchTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }


    public int SearchCategory(String category) {
        int count = 0;
        for (Book book : books) {
            if (book.getCategory() != null && book.getCategory().equalsIgnoreCase(category)) {
                count++;
            }
        }
        return count;
    }


    public List<Book> getAll() {
        return books;
    }


    public void UpdatePrice(int id, double newPrice) {
        for (Book book : books) {
            if (book.getId() == id)
            {
                book.setPrice(newPrice);
                break;
            }
        }
    }


    public void Delete(String isbn) {
        books.removeIf(book -> book.getISBN().equalsIgnoreCase(isbn));
    }
}

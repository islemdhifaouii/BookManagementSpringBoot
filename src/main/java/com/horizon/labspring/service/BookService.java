package com.horizon.labspring.service;

import com.horizon.labspring.model.Book;

import com.horizon.labspring.repository.BookReposotory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookReposotory bookRepository;


    public BookService(BookReposotory bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void SaveBook(Book book) {
        boolean exists = bookRepository.existsByTitle(book.getTitle());
       System.out.println(book);
        if (!exists) {
            bookRepository.save(book);
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Book already exists: " + book.getTitle());
        }
    }


    public int Inventory(String category) {
        int total = 0;
        for (Book b : bookRepository.findAll()) {
            if (b.getCategory() != null && b.getCategory().equalsIgnoreCase(category)) {
                total += b.getQuantity();
            }
        }
        return total;
    }


    public void update() {
        List<Book> books = bookRepository.findAll();
        for (Book b : books) {
            b.setPrice(b.getPrice() * 1.10); // +10%
        }
        System.out.println("All book prices increased by 10%");
    }


    public void deleteBook(String isbn) {
        for (Book b : bookRepository.findAll()) {
            if(b.getIsbn().equalsIgnoreCase(isbn)) {
                bookRepository.delete(b);
            }
            }
    }
}

package com.horizon.labspring.service;

import com.horizon.labspring.model.Book;
import com.horizon.labspring.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void SaveBook(Book book) {
        boolean exists = bookRepository.getAll().stream()
                .anyMatch(b -> b.getISBN().equalsIgnoreCase(book.getISBN()));

        if (!exists) {
            bookRepository.add(book);
            System.out.println("Book added: " + book.getTitle());
        } else {
            System.out.println("Book already exists: " + book.getTitle());
        }
    }


    public int Inventory(String category) {
        int total = 0;
        for (Book b : bookRepository.getAll()) {
            if (b.getCategory() != null && b.getCategory().equalsIgnoreCase(category)) {
                total += b.getQuantity();
            }
        }
        return total;
    }


    public void update() {
        List<Book> books = bookRepository.getAll();
        for (Book b : books) {
            b.setPrice(b.getPrice() * 1.10); // +10%
        }
        System.out.println("All book prices increased by 10%");
    }


    public void deleteBook(String isbn) {
        bookRepository.Delete(isbn);
        System.out.println("Book deleted with ISBN: " + isbn);
    }
}

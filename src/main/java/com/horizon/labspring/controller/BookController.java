package com.horizon.labspring.controller;

import com.horizon.labspring.model.Book;
import com.horizon.labspring.service.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")

public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/saveBook")
    public void addBook(@RequestBody Book book){
        bookService.SaveBook(book);

    }
    @GetMapping("/inventory")
    public int getAllBooks(@RequestParam String category) {
        return bookService.Inventory(category);
    }
    @PutMapping("/updateBook")
    public void updatePrice() {
        bookService.update();
    }
    @DeleteMapping("/DeleteBook/{isbn}")
    public void deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
    }



}

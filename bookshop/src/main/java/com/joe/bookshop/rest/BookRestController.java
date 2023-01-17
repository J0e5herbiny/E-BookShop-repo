package com.joe.bookshop.rest;

import com.joe.bookshop.domain.dto.BookDTO;
import com.joe.bookshop.domain.model.Book;
import com.joe.bookshop.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/book_api")
public class BookRestController {

    private BookServiceImpl bookService;

    @Autowired
    public BookRestController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDTO> getAllBooks(){
        List<BookDTO> bookDTOS = new ArrayList(bookService.getAll());
        return bookDTOS;
    }

    @GetMapping("/{id}")
    public BookDTO getBook(@PathVariable("id") Integer id){
        Optional<Book> book = bookService.getById(id);
        BookDTO bookDTO =
                new BookDTO(book.get().getTitle(),
                            book.get().getYear(),
                            book.get().getAuthorName(),
                            book.get().getPrice(),
                            book.get().getCategory()
                           );
        return bookDTO;
    }

    @PostMapping("/book")
    public BookDTO addBook(@RequestBody BookDTO bookDTO){
        bookService.save(bookDTO);
        return bookDTO;
    }

}

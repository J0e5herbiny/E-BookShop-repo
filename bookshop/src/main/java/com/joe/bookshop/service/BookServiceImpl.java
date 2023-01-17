package com.joe.bookshop.service;

import com.joe.bookshop.domain.dto.BookDTO;
import com.joe.bookshop.domain.model.Book;
import com.joe.bookshop.reposietpry.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl{

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    public List<Book> getAll() {            //Read
        return bookRepository.findAll();
    }

    public Optional<Book> getById(int id){  // Read by id
        return bookRepository.findById(id);
    }

    public void save(BookDTO bookDTO){       // Create, Update
        Book book = new Book(bookDTO.getTitle(),
                             bookDTO.getYear(),
                             bookDTO.getAuthorName(),
                             bookDTO.getPrice(),
                             bookDTO.getCategory()
                    );
        book.setId(0);
        bookRepository.save(book);
    }

    public String delete(int id){
        bookRepository.deleteById(id);
        return "Deleted";
    }

}

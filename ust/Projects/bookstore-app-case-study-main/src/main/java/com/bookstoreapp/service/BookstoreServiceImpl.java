package com.bookstoreapp.service;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreServiceImpl implements BookstoreService{


    private BookRepository bookRepository;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        // check if book exists
        // if book exists return book
        // else throw exception book not found
        if(!bookRepository.existsById(id))
            throw new BookNotFoundException("Book with id: " + id + "not found!");
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveBook(Book book) {

        if(bookRepository.existsById(book.getId())){
            throw new BookAlreadyExistsException("Book with id: " + book.getId() + " already exits!");
        }

        return bookRepository.save(book);

        // check if book exists
        // if book exists throw exception book already exists
        // else save book

    }

    @Override
    public Book updateBook(int id, Book book) {

        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException("Book with id: " + id + " already exits!");
        }

        return bookRepository.save(book);

        // check if book exists
        // if book exists update book
        // else throw exception book not found


    }

    @Override
    public void deleteBook(int id) {

        if(!bookRepository.existsById(id))
            throw new BookNotFoundException("Book with id: " + id + "not found!");
        bookRepository.deleteById(id);

            // check if book exists
            // if book exists delete book
            // else throw exception book not found

    }


}

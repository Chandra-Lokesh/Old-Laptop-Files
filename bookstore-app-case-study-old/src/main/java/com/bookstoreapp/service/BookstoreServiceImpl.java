package com.bookstoreapp.service;

import com.bookstoreapp.exception.BookAlreadyExistsException;
import com.bookstoreapp.exception.BookNotFoundException;
import com.bookstoreapp.model.Book;
import com.bookstoreapp.repository.BookRepository;
import com.bookstoreapp.repository.BookRepositoryImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class BookstoreServiceImpl implements BookstoreService{


    private BookRepository bookRepository = new BookRepositoryImpl();

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        bookList = bookRepository.findAll();
        if(bookList.isEmpty()){
            System.out.println("No Books available!");
            return null;
        }
        else
            return bookList;
    }

    @Override
    public Book getBookById(int id) {
        // check if book exists
        // if book exists return book
        // else throw exception book not found
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent())
            return book.get();
        else
            throw new BookNotFoundException("Enter valid book id");
    }

    @Override
    public Book saveBook(Book book) {

        // check if book exists
        // if book exists throw exception book already exists
        // else save book
        if(isBookExists(book.getId())){
            throw new BookAlreadyExistsException("Book already exists!");
        }
        else{
            bookRepository.save(book);
            return book;
        }
    }

    @Override
    public Book updateBook(int id, Book book) {

        // check if book exists
        // if book exists update book
        // else throw exception book not found
        if(isBookExists(book.getId())){
            bookRepository.update(book);
            return book;
        }
        throw new BookNotFoundException("Book doesn't exist!");
    }

    @Override
    public void deleteBook(int id) {

            // check if book exists
            // if book exists delete book
            // else throw exception book not found
        if(isBookExists(id))
            bookRepository.deleteById(id);
        else
            throw new BookNotFoundException("Book doesn't exist!");
    }

    public boolean isBookExists(int id){
        Optional<Book> bookInStore = bookRepository.findById(id);
        return bookInStore.isPresent();
    }


}

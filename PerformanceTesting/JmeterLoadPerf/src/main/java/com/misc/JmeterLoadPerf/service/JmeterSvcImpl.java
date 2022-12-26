package com.misc.JmeterLoadPerf.service;

import com.misc.JmeterLoadPerf.entities.Books;
import com.misc.JmeterLoadPerf.repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JmeterSvcImpl implements JmeterSvc {

    @Autowired
    private BooksRepo booksRepo;

    @Override
    public void saveAllBooks() {
        for (int i = 0; i < 100; i++) {
            Books books = new Books();
            books.setBookName("Book Name " + i);
            books.setBookAuthor("Book Author " + i);
            booksRepo.save(books);
        }
    }

    @Override
    public List<Books> getBooksList() {
        return booksRepo.findAll();
    }
}

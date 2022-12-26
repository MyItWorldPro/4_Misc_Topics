package com.misc.JmeterLoadPerf.service;

import com.misc.JmeterLoadPerf.entities.Books;

import java.util.List;

public interface JmeterSvc {

    void saveAllBooks();
    List<Books> getBooksList();

}

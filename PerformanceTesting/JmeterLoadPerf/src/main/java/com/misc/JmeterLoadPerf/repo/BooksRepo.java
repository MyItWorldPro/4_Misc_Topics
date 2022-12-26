package com.misc.JmeterLoadPerf.repo;

import com.misc.JmeterLoadPerf.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends JpaRepository<Books, Integer> {
}

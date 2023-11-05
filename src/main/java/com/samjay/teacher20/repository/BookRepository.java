package com.samjay.teacher20.repository;

import com.samjay.teacher20.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findFirstByBookName(String bookName);
}

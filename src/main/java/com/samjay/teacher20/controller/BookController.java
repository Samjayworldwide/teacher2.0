package com.samjay.teacher20.controller;

import com.samjay.teacher20.dto.request.BookRequestDto;
import com.samjay.teacher20.entity.Book;
import com.samjay.teacher20.implementation.BookServiceImplementation;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private final BookServiceImplementation bookServiceImplementation;

    @Autowired
    public BookController(BookServiceImplementation bookServiceImplementation) {
        this.bookServiceImplementation = bookServiceImplementation;
    }

    @GetMapping("/addBook")
    public String getBookStorePage() {
        return "addToBookStorePage";
    }

    @PostMapping("/addBook")
    public String addBookToBookStore(@RequestBody BookRequestDto bookRequestDto, HttpSession session) {
        System.out.println(bookRequestDto);
        Long id = (Long) session.getAttribute("teacherId");
        Book addedBook = bookServiceImplementation.addBook(bookRequestDto, id);
        return addedBook == null ? "errorPage" : "successfulBookCreation";
    }
}

package com.samjay.teacher20.service;

import com.samjay.teacher20.dto.request.BookRequestDto;
import com.samjay.teacher20.entity.Book;

public interface BookService {
    Book addBook(BookRequestDto bookRequestDto, Long id);
}

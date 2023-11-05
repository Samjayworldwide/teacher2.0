package com.samjay.teacher20.implementation;

import com.samjay.teacher20.dto.request.BookRequestDto;
import com.samjay.teacher20.entity.Book;
import com.samjay.teacher20.entity.Teacher;
import com.samjay.teacher20.repository.BookRepository;
import com.samjay.teacher20.repository.TeacherRepository;
import com.samjay.teacher20.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {
    private BookRepository bookRepository;
    private TeacherRepository teacherRepository;
    @Autowired
    public BookServiceImplementation(BookRepository bookRepository, TeacherRepository teacherRepository) {
        this.bookRepository = bookRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Book addBook(BookRequestDto bookRequestDto, Long id) {
        if (bookRequestDto.getBookName() == null || bookRequestDto.getPrice() == null){
            throw new InputMismatchException("invalid data");
        }

        if (bookRepository.findFirstByBookName(bookRequestDto.getBookName()).isPresent()){
            throw new InputMismatchException("book already exists");
        }
        Optional<Teacher> teacherId = teacherRepository.findById(id);
        if (teacherId.isEmpty()){
            throw new InputMismatchException("invalid id");
        }
        Book book = new Book();
        book.setBookName(bookRequestDto.getBookName());
        book.setAuthor(bookRequestDto.getAuthor());
        book.setPrice(bookRequestDto.getPrice());
        teacherId.get().addBook(book);

        return bookRepository.save(book);

    }
}

package com.example.w3project.Controller;


import com.example.w3project.DTO.Api;
import com.example.w3project.Service.BookService;
import com.example.w3project.model.Loan;
import com.example.w3project.model.OneToMany.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/bookstore")
public class BookController {

    private final BookService bookService ;


    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.status(200).body(bookService.getBooks());
    }



    @PostMapping
    public ResponseEntity<Api> addBook(@RequestBody @Valid Book book){
        bookService.addBook(book);


        return ResponseEntity.status(201).body(new Api("New Book Added" , 201));
    }


    @PostMapping("/lend")
    public ResponseEntity<Api> lendBook(@RequestBody @Valid Loan loan){
         bookService.lendBook(loan);
        return ResponseEntity.status(200).body(new Api("book lended ",200));

    }

    }









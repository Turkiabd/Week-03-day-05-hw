package com.example.w3project.Service;

import com.example.w3project.Exceptions.InvalidIdException;
import com.example.w3project.Repository.BookRepository;
import com.example.w3project.Repository.UserRepository;
import com.example.w3project.model.Loan;
import com.example.w3project.model.OneToMany.BUser;
import com.example.w3project.model.OneToMany.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository ;
    private final UserRepository userRepository;
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book findBookId(Integer bookId){
        return bookRepository.findById(bookId).orElseThrow(()-> new InvalidIdException("WRONG  book id!!"));
    }


    public void lendBook(Loan loan){
        // find the user id
        BUser user = userRepository.findById(loan.getUserId()).orElseThrow(()-> new InvalidIdException("wrong user id"));
        //find book id
        Book book = bookRepository.findById(loan.getBookId()).orElseThrow(()-> new InvalidIdException("wrong book id"));

        // check loans

        if(book.getLoanSet()==null){
            book.setLoanSet(book.getLoanSet().add(loan));
        }
        // check books

        if(loan.getBookSet()== null){
            loan.setBookSet(loan.getBookSet().add(book));
        }

    }



}

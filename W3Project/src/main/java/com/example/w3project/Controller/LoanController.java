package com.example.w3project.Controller;

import com.example.w3project.DTO.Api;
import com.example.w3project.Service.LoanService;
import com.example.w3project.model.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/loanbook")
public class LoanController {

    private final LoanService loanService ;





    @GetMapping
    public ResponseEntity<List<Loan>> getLoans(){
        return ResponseEntity.status(200).body(loanService.getLoans());
    }


    @PostMapping
    public ResponseEntity<Api> addLoan(@RequestBody @Valid Loan loan){
        loanService.addLoan(loan);
        return ResponseEntity.status(201).body(new Api("New Loan added",201));
    }




}



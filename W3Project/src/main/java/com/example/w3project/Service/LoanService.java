package com.example.w3project.Service;


import com.example.w3project.Repository.LoanRepository;
import com.example.w3project.model.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository ;


    public List<Loan> getLoans() {
        return loanRepository.findAll();
    }


    public void addLoan(Loan loan){
        loanRepository.save(loan);
    }
}

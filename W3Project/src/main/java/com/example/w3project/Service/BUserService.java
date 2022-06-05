package com.example.w3project.Service;

import com.example.w3project.Repository.UserRepository;
import com.example.w3project.model.OneToMany.BUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BUserService {

    private final UserRepository userRepository;
    public List<BUser> getUsers() {
        return userRepository.findAll();

    }

    public void addUser(BUser buser) {
        userRepository.save(buser);
    }
}

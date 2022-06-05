package com.example.w3project.Controller;

import com.example.w3project.DTO.Api;
import com.example.w3project.Service.BUserService;
import com.example.w3project.model.OneToMany.BUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/bookuser")
public class BUserController {


    private final BUserService bUserService ;

    @GetMapping
    public ResponseEntity<List<BUser>> getUsers(){
        return ResponseEntity.status(200).body(bUserService.getUsers());
    }


    @PostMapping
    public ResponseEntity<Api> addUser(@RequestBody @Valid BUser bUser){
        bUserService.addUser(bUser);
        return ResponseEntity.status(201).body(new Api("New User added",201));
    }
}

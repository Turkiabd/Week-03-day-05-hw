package com.example.w3project.Repository;

import com.example.w3project.model.OneToMany.BUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BUser , Integer> {
}

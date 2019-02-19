package com.project.lunchTime.repository;


import com.project.lunchTime.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

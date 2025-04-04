package com.example.mdClone.repository;

import com.example.mdClone.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Integer> {

    Optional<Manager> findByFirstNameAndLastName(String firstName, String lastName);
}

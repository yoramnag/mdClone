package com.example.mdClone.repository;

import com.example.mdClone.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagertRepository extends JpaRepository<Manager,Integer> {
}

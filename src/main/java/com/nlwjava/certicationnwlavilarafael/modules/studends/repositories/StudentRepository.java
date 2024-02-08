package com.nlwjava.certicationnwlavilarafael.modules.studends.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlwjava.certicationnwlavilarafael.modules.studends.entities.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
    public Optional<StudentEntity> findByEmail(String email);
}

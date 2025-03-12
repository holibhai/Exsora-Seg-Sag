package com.crudoperation.jw.repo;

import com.crudoperation.jw.dto.Response;
import com.crudoperation.jw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<Object> findByUsername(String username);
    boolean existsByUsername(String username);


}

package com.example.Software_Advance.repositories;

import com.example.Software_Advance.models.Tables.User;
import com.example.Software_Advance.models.Enums.userRole;
import com.example.Software_Advance.models.Enums.userType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(userRole role);

    List<User> findByType(userType type);

    List <User> findByName(String name);

    boolean existsByEmail(String email) ;

}
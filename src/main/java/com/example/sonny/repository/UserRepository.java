package com.example.sonny.repository;

import com.example.sonny.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("""
        Select u FROM User u where u.name like %:name%
    """)
    List<User> findUserByName1(@Param("name") String name);


    List<User> findUserByNameContaining(String name, Pageable pageable);
}

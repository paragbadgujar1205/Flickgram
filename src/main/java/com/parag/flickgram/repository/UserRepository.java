package com.parag.flickgram.repository;

import com.parag.flickgram.model.User;  //user model
import org.springframework.data.jpa.repository.JpaRepository;  // this is JpaRepository interface which provide build in method for performing CRUD operations in spring without writting sql queries
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

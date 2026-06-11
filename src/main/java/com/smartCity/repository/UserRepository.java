package com.smartCity.repository;

import com.smartCity.objects.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserID(Integer userID);

    User findByUsername(String username);
}


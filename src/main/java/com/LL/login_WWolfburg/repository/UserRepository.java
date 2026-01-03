package com.LL.login_WWolfburg.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.LL.login_WWolfburg.model.User;

public interface UserRepository extends JpaRepository<User, Integer>  {
    
}

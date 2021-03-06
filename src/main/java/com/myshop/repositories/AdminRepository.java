package com.myshop.repositories;

import com.myshop.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByLoginAndPassword(String login, String password);
}

package com.aziz.dta.repositories;

import com.aziz.dta.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

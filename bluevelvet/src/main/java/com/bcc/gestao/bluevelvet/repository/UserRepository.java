package com.bcc.gestao.bluevelvet.repository;

import com.bcc.gestao.bluevelvet.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public boolean existsByEmail(String email);
}

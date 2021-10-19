package com.marta.challenge.createUser.userAdm;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

    public User findByLoginAndPassword(String login, String password);
}

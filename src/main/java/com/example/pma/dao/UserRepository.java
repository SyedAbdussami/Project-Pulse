package com.example.pma.dao;

import com.example.pma.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserAccount,Long> {

}

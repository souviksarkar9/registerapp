package com.example.registerspringappdatabase.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, String> {

}

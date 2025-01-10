package com.ust.app.service;

import com.ust.app.model.UserModel;
import com.ust.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserCrudService {

    public UserModel saveUser(UserModel userModel);
}

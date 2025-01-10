package com.ust.app.service;

import com.ust.app.dto.JwtToken;
import com.ust.app.dto.UserCredential;
import com.ust.app.model.UserModel;
import com.ust.app.repository.UserRepository;
import com.ust.app.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtToken loginUser(UserCredential userCredential){

        UserModel userModel = userRepository.findByUsername(userCredential.username())
                .orElseThrow(() -> new UsernameNotFoundException("user with name: " + userCredential.username() + "not found!"));
        if(!passwordEncoder.matches(userCredential.password(), userModel.getPassword())){
            throw new RuntimeException("Incorrect Credentials");
        }

        String jwt = jwtUtil.generateToken(userCredential.username());
        return new JwtToken(jwt);
    }
}

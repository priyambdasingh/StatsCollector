package com.example.StatsCollector.service;

import com.example.StatsCollector.config.JwtProvider;
import com.example.StatsCollector.model.Users;
import com.example.StatsCollector.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UsersRepository usersRepository;
    private JwtProvider jwtprovider;
    @Override
    public Users findUsersByJwtToken(String jwt) throws Exception {
    String email=   jwtprovider.getEmailFromJwtToken(jwt);
     Users users=findUsersByEmail(email);
     return users;
    }

    @Override
    public Users findUsersByEmail(String email) throws Exception {
        Users users=usersRepository.findByEmail(email);
        if (users==null){
            throw new Exception("user not found");
        }
        return users;
    }
}

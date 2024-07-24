package com.example.StatsCollector.service;


import com.example.StatsCollector.model.Users;

public interface UserService {
    public Users findUsersByJwtToken(String jwt)throws Exception;
    public Users findUsersByEmail(String email) throws Exception;
}

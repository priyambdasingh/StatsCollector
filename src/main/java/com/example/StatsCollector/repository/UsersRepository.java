package com.example.StatsCollector.repository;

import com.example.StatsCollector.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long>{
     public Users findByEmail(String username);
}

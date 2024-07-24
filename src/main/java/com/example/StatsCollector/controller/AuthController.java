package com.example.StatsCollector.controller;

import com.example.StatsCollector.config.JwtProvider;
import com.example.StatsCollector.model.Cart;
import com.example.StatsCollector.model.USER_ROLE;
import com.example.StatsCollector.model.Users;
import com.example.StatsCollector.repository.CartRepository;
import com.example.StatsCollector.repository.UsersRepository;
import com.example.StatsCollector.request.LoginRequest;
import com.example.StatsCollector.response.AuthResponse;
import com.example.StatsCollector.service.CustomerUserDetailsService;
import org.apache.coyote.BadRequestException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;
    @Autowired
    private CartRepository cartRepository;
    @PostMapping("/signup")
    public ResponseEntity<AuthResponse>createUsersHandler(@RequestBody Users users) throws Exception {
        Users isEmailExist=usersRepository.findByEmail(users.getEmail());
        if (isEmailExist!=null){
            throw new Exception("Email is already with another account");
        }
        Users createdUser=new Users();
        createdUser.setEmail(users.getEmail());
        createdUser.setName(users.getName());
        createdUser.setRole(users.getRole());
        createdUser.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedUser=usersRepository.save(createdUser);
        Cart cart=new Cart();
        cart.setCustomer(savedUser);
        cartRepository.save(cart);
        Authentication authentication=new UsernamePasswordAuthenticationToken(users.getEmail(),users.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt=jwtProvider.generateToken(authentication);
        AuthResponse authResponse=new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("Register success");
        authResponse.setRole(savedUser.getRole());
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }
    @PostMapping("/sigin")
    public ResponseEntity<AuthResponse>singin(@RequestBody LoginRequest req){
        String username=req.getEmail();
        String password = req.getPassword();
        Authentication authentication=authenticate(username,password);

        Collection<? extends GrantedAuthority>authorities=authentication.getAuthorities();
        String role=authorities.isEmpty()?null:authorities.iterator().next().getAuthority();

        String jwt=jwtProvider.generateToken(authentication);

        AuthResponse authResponse=new AuthResponse();
        authResponse.setJwt(jwt);
        authResponse.setMessage("login success");


        authResponse.setRole(USER_ROLE.valueOf(role));
        return new ResponseEntity<>(authResponse, HttpStatus.OK);


    }

    private Authentication authenticate(String username, String password) {
        UserDetails userDetails=customerUserDetailsService.loadUserByUsername(username);
        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username..");
        }
         if (!passwordEncoder.matches(password,userDetails.getPassword())){
             throw new BadCredentialsException("Invalid password..");
         }
         return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        }
    }




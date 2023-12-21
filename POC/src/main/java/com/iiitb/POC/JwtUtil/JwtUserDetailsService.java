package com.iiitb.POC.JwtUtil;

//import com.iiitb.spe.repositories.MovieDetailsRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    public JwtUserDetailsService(){

    }
    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
        authList.add(new SimpleGrantedAuthority("verifyOTP"));
        User userByName = new User(mobile, "1234", authList);
        return new org.springframework.security.core.userdetails.User(userByName.getUsername(), userByName.getPassword(), userByName.getAuthorities());
    }

}
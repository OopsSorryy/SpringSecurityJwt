package com.yunusemre.springsecurity.user.service;

import com.yunusemre.springsecurity.user.User;
import com.yunusemre.springsecurity.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsManager implements UserDetailsService {

   private UserRepository userRepository;

   @Autowired
   public UserDetailsManager(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<User> user = userRepository.findByEmail(username);

      return user.orElseThrow(() ->  new UsernameNotFoundException("Invalid Credentials"));

   }
}

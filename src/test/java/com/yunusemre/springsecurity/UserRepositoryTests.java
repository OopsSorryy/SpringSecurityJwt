package com.yunusemre.springsecurity;


import com.yunusemre.springsecurity.user.Role;
import com.yunusemre.springsecurity.user.User;
import com.yunusemre.springsecurity.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testCreateUser(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = "muslera261";
        String encodedPassword = passwordEncoder.encode(rawPassword);

        User newUser = new User("muslera1@gmail.com", encodedPassword);

        User savedUser = userRepository.save(newUser);
    }

    @Test
    public void testAssignRoleToUser() {
        Integer userId = 1;
        User user = userRepository.findById(userId).get();
        user.addRole(new Role(3));



        User updatedUser = userRepository.save(user);

    }
}

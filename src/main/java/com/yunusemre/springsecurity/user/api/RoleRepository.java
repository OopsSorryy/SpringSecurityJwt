package com.yunusemre.springsecurity.user.api;

import com.yunusemre.springsecurity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}

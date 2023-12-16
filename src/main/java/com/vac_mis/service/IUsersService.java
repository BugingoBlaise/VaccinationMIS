package com.vac_mis.service;

import com.vac_mis.model.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface IUsersService {
    void saveUser(Users user);
    void deleteUser(Users user);
    List<Users>usersList();

    Users getUserByUsername(String username);

    boolean authenticateUser(String username, String password);
//    Users getLoggedInUser();

//    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}

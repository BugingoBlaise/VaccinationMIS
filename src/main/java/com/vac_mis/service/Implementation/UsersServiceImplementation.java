package com.vac_mis.service.Implementation;


import com.vac_mis.model.Users;
import com.vac_mis.repo.IUsersDao;
import com.vac_mis.service.IUsersService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UsersServiceImplementation implements IUsersService {
    @Autowired
    private IUsersDao dao;


    @Override
    public void saveUser(Users user) {
        dao.save(user);
    }

    @Override
    public void deleteUser(Users user) {
        dao.delete(user);
    }

    @Override
    public List<Users> usersList() {
        return dao.findAll();
    }
/*
    @Override
    public Users getLoggedInUser() {
        return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) dao.findAccountByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
*/


}

package com.vac_mis.service.Implementation;


import com.vac_mis.model.Users;
import com.vac_mis.repo.IUsersDao;
import com.vac_mis.service.IUsersService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Users getUserByUsername(String username) {
        return dao.getUserByUsername(username);
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        Users user = dao.getUserByUsername(username);

        // Check if the user exists and the password matches
        return user != null && user.getPassword().equals(password);
    }




}

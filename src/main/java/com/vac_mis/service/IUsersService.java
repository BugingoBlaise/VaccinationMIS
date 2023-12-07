package com.vac_mis.service;

import com.vac_mis.model.Users;

import java.util.List;

public interface IUsersService {
    void saveUser(Users user);
    void deleteUser(Users user);

    List<Users>usersList();
}

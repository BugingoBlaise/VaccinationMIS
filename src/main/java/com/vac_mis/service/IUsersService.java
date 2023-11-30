package com.vac_mis.service;

import com.vac_mis.model.Users;

public interface IUsersService {
    Users saveUser(Users user);
    void deleteUser(Users user);

}

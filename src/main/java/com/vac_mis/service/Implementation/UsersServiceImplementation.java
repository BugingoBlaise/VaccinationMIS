package com.vac_mis.service.Implementation;


import com.vac_mis.model.Users;
import com.vac_mis.repo.IUsersDao;
import com.vac_mis.service.IUsersService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class UsersServiceImplementation implements IUsersService {
    @Autowired
    IUsersDao iUsersDao;


    @Override
    public Users saveUser(Users user) {
        return iUsersDao.save(user);
    }

    @Override
    public void deleteUser(Users user) {
        iUsersDao.delete(user);
    }
}

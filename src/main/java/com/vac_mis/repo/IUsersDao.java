package com.vac_mis.repo;

import com.vac_mis.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface IUsersDao extends JpaRepository<Users, UUID> {
    @Query("SELECT  u FROM Users  u WHERE u.username=?1 and u.password=?2")
    Optional<Users> findByUsernameAndPassword(String username, String password);

    Users findByUsername(String username);
}

package com.vac_mis.repo;

import com.vac_mis.model.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IInformationDao extends JpaRepository<Information, UUID> {

}

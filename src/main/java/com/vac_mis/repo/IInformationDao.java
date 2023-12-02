package com.vac_mis.repo;

import com.vac_mis.model.Information;
import com.vac_mis.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IInformationDao extends JpaRepository<Information, UUID> {
    @Query("SELECT i FROM Information i WHERE i.patientName=?1")
    Information findInformationByName(String name);

}

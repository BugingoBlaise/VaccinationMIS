package com.vac_mis.repo;

import com.vac_mis.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IVaccineDao extends JpaRepository<Vaccine, UUID> {
}

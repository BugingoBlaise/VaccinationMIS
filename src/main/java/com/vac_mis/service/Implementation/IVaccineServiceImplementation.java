package com.vac_mis.service.Implementation;

import com.vac_mis.model.Vaccine;
import com.vac_mis.repo.IVaccineDao;
import com.vac_mis.service.IVaccineService;
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
public class IVaccineServiceImplementation implements IVaccineService {
    @Autowired
    IVaccineDao dao;

    @Override
    public Vaccine saveVaccine(Vaccine vaccine) {
        return dao.save(vaccine);
    }

    @Override
    public List<Vaccine> vaccineList() {
        return dao.findAll();
    }

    @Override
    public void deleteVaccine(Vaccine vaccine) {
        dao.delete(vaccine);
    }

    @Override
    public Vaccine findVaccineByName(String name) {
        return null;
    }
}

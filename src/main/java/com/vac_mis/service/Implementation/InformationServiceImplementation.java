package com.vac_mis.service.Implementation;

import com.vac_mis.model.Information;
import com.vac_mis.repo.IInformationDao;
import com.vac_mis.service.IInformationService;
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
public class InformationServiceImplementation implements IInformationService {
    @Autowired
    private IInformationDao dao;

    @Override
    public void saveInformation(Information information) {
        dao.save(information);
    }

    @Override
    public List<Information> informationList() {
        return dao.findAll();
    }

    @Override
    public void deleteInformation(Information information) {
        dao.delete(information);
    }

    @Override
    public void updateInformation(Information information) {
        Information updatedInformation = this.dao.findById(information.getId())
                .orElseThrow(() -> new RuntimeException("Information of Id:" + information.getId() + "Not found"));

        updatedInformation.setId(information.getId());
        updatedInformation.setIdNumber(information.getIdNumber());
        updatedInformation.setPatientName(information.getPatientName());
        updatedInformation.setEGender(information.getEGender());
        updatedInformation.setDob(information.getDob());
        updatedInformation.setVaccine(information.getVaccine());
        updatedInformation.setNurse(information.getNurse());

        dao.save(updatedInformation);
    }

    @Override
    public Information findInformationByName(String name) {
        return dao.findInformationByName(name);
    }
}

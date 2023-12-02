package com.vac_mis.service;

import com.vac_mis.model.Vaccine;

import java.util.List;

public interface IVaccineService {
    Vaccine saveVaccine(Vaccine vaccine);
    List<Vaccine> vaccineList();
    void deleteVaccine(Vaccine vaccine);
    Vaccine findVaccineByName(String name);

}

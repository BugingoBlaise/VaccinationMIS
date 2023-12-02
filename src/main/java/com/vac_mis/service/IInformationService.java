package com.vac_mis.service;

import com.vac_mis.model.Information;
import com.vac_mis.model.Vaccine;

import java.util.List;

public interface IInformationService {
    Information saveInformation(Information information);
    List<Information> informationList();
    void deleteInformation(Information information);
    Information findInformationByName(String name);
}

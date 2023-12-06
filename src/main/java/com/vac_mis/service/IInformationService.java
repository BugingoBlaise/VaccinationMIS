package com.vac_mis.service;

import com.vac_mis.model.Information;

import java.util.List;

public interface IInformationService {
    void saveInformation(Information information);
    List<Information> informationList();
    void deleteInformation(Information information);

    void updateInformation(Information information);
    Information findInformationByName(String name);
}

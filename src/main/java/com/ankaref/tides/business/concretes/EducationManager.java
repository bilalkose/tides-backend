package com.ankaref.tides.business.concretes;

import com.ankaref.tides.dataAccess.abstracts.EducationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationManager {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }
}

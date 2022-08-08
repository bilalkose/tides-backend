package com.ankaref.tides.business.abstracts;

import com.ankaref.tides.core.utilities.results.DataResult;
import com.ankaref.tides.core.utilities.results.Result;
import com.ankaref.tides.entities.concretes.Education;

import java.util.List;

public interface EducationService {

    DataResult<List<Education>> getAll();

    Result add(Education education);

    Result delete(int educationId);

}

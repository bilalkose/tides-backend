package com.ankaref.tides.dataAccess.abstracts;

import com.ankaref.tides.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education,Integer> {


}

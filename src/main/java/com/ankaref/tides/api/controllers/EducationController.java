package com.ankaref.tides.api.controllers;
import com.ankaref.tides.business.abstracts.EducationService;
import org.springframework.beans.factory.annotation.Autowired;

public class EducationController {

   private EducationService educationService;

   @Autowired
   public EducationController(EducationService educationService) {
      this.educationService = educationService;
   }
}

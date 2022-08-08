package com.ankaref.tides.api.controllers;
import com.ankaref.tides.business.abstracts.EducationService;
import com.ankaref.tides.core.utilities.results.DataResult;
import com.ankaref.tides.core.utilities.results.Result;
import com.ankaref.tides.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class EducationController {

   private EducationService educationService;

   @Autowired
   public EducationController(EducationService educationService) {
      this.educationService = educationService;
   }

   @GetMapping("education-list")
   public DataResult<List<Education>> getAll(){
      return this.educationService.getAll();
   }
   @PostMapping("education-add")
   public Result add(@RequestBody Education education){
      return this.educationService.add(education);
   }

   @DeleteMapping("delete-education")
   public Result delete(int educationId){
      return this.educationService.delete(educationId);
   }

}

package com.ankaref.tides.business.concretes;

import com.ankaref.tides.business.abstracts.EducationService;
import com.ankaref.tides.core.utilities.file.FileService;
import com.ankaref.tides.core.utilities.results.DataResult;
import com.ankaref.tides.core.utilities.results.Result;
import com.ankaref.tides.core.utilities.results.SuccessDataResult;
import com.ankaref.tides.core.utilities.results.SuccessResult;
import com.ankaref.tides.dataAccess.abstracts.EducationDao;
import com.ankaref.tides.dataAccess.abstracts.VideoDao;
import com.ankaref.tides.entities.concretes.Education;
import com.ankaref.tides.entities.concretes.Video;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

@RestController
public class EducationManager implements EducationService {

    private EducationDao educationDao;
    private VideoDao videoDao;
    private FileService fileService;

    @Autowired
    public EducationManager(EducationDao educationDao, FileService fileService,VideoDao videoDao) {
        this.educationDao = educationDao;
        this.fileService=fileService;
        this.videoDao=videoDao;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(),"Datalar Listelendi");
    }

    @SneakyThrows
    @Override
    public Result add(Education education) {

        if (education.getImage() !=null){
            String ımageName=fileService.writeBase64StringtoFile(education.getImage());
            education.setImage(ımageName);
        }
        this.educationDao.save(education);
        return new SuccessResult("Eğitim başarıyla eklendi");
    }

    //TODO: Eğitim silindiğinde veya videolar silindiğinde dosya şeklinde tutulan image ve video yapılarıda silinmeli buraya dön !!
    @Override
    public Result delete(int educationId) {
        List<Video> videos= videoDao.getByEducationId(educationId);
        videos.forEach((thisVideo) ->{
            int numberId=thisVideo.getId();
            this.videoDao.deleteById(numberId);
        });
        this.educationDao.deleteById(educationId);
        return new SuccessResult("Eğitim silme işlemi başarılı");
    }
}

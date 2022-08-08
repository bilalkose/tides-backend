package com.ankaref.tides.business.concretes;
import com.ankaref.tides.business.abstracts.VideoService;
import com.ankaref.tides.core.utilities.file.FileService;
import com.ankaref.tides.core.utilities.results.DataResult;
import com.ankaref.tides.core.utilities.results.Result;
import com.ankaref.tides.core.utilities.results.SuccessDataResult;
import com.ankaref.tides.core.utilities.results.SuccessResult;
import com.ankaref.tides.dataAccess.abstracts.VideoDao;
import com.ankaref.tides.entities.concretes.Education;
import com.ankaref.tides.entities.concretes.Video;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoManager implements VideoService {

    public VideoDao videoDao;
    public FileService fileService;

    @Autowired
    public VideoManager(VideoDao videoDao, FileService fileService) {
        this.videoDao = videoDao;
        this.fileService= fileService;
    }

    @SneakyThrows
    @Override
    public Result add(Video video) {
        if (video.getVideo() !=null){
            String ımageName=fileService.writeBaseVideo64StringtoFile(video.getVideo());
            video.setVideo(ımageName);
        }
        this.videoDao.save(video);
        return new SuccessResult("Video başarıyla eklendi");
    }

    @Override
    public DataResult<List<Video>> getAllVideos(int education_id) {
        return new SuccessDataResult<>(this.videoDao.getByEducationId(education_id),"Videolar başarıyla getirildi");
    }

    @Override
    public Result delete(int videoId) {
        String videoName=videoDao.findById(videoId).get().getName();
        this.videoDao.deleteById(videoId);
        return new SuccessResult(videoName+" isimli video silindi");


    }


}

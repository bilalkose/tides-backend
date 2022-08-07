package com.ankaref.tides.business.concretes;
import com.ankaref.tides.business.abstracts.VideoService;
import com.ankaref.tides.core.utilities.results.DataResult;
import com.ankaref.tides.core.utilities.results.Result;
import com.ankaref.tides.core.utilities.results.SuccessDataResult;
import com.ankaref.tides.core.utilities.results.SuccessResult;
import com.ankaref.tides.dataAccess.abstracts.VideoDao;
import com.ankaref.tides.entities.concretes.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoManager implements VideoService {

    public VideoDao videoDao;

    @Autowired
    public VideoManager(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

    @Override
    public Result add(Video video) {

        this.videoDao.save(video);
        return new SuccessResult("Video Eklendi");

    }

    @Override
    public DataResult<List<Video>> getAllVideos(int education_id) {
        return new SuccessDataResult<>(this.videoDao.getByEducationId(education_id),"Videolar başarıyla getirildi");
    }


}

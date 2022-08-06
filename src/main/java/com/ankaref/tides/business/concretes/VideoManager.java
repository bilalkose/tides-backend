package com.ankaref.tides.business.concretes;

import com.ankaref.tides.dataAccess.abstracts.VideoDao;
import org.springframework.beans.factory.annotation.Autowired;

public class VideoManager {

    public VideoDao videoDao;

    @Autowired
    public VideoManager(VideoDao videoDao) {
        this.videoDao = videoDao;
    }

}

package com.ankaref.tides.api.controllers;

import com.ankaref.tides.business.abstracts.VideoService;
import org.springframework.beans.factory.annotation.Autowired;

public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }
}

package com.ankaref.tides.api.controllers;
import com.ankaref.tides.business.abstracts.VideoService;
import com.ankaref.tides.core.utilities.results.DataResult;
import com.ankaref.tides.core.utilities.results.Result;
import com.ankaref.tides.entities.concretes.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin //FRONT END İÇİN BAĞLANTIYI AÇTIM //TODO: AÇIKLAMAYI SİLMEYİ UNUTMA
public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Video video){

        return this.videoService.add(video);
    }
    @PostMapping("/getAllVideos")
    public DataResult<List<Video>> getAllVideos(@RequestParam int education_id){
        return this.videoService.getAllVideos(education_id);
    }

}

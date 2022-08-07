package com.ankaref.tides.business.abstracts;
import com.ankaref.tides.core.utilities.results.DataResult;
import com.ankaref.tides.core.utilities.results.Result;
import com.ankaref.tides.entities.concretes.Video;

import java.util.List;

public interface VideoService {

    Result add(Video video);

    DataResult<List<Video>> getAllVideos(int education_id);

}

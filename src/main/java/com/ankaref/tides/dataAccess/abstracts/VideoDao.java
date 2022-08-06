package com.ankaref.tides.dataAccess.abstracts;

import com.ankaref.tides.entities.concretes.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoDao extends JpaRepository<Video,Integer> {

    
}


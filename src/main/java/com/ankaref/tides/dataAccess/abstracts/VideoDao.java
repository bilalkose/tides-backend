package com.ankaref.tides.dataAccess.abstracts;

import com.ankaref.tides.entities.concretes.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoDao extends JpaRepository<Video,Integer> {
    List<Video> getByEducationId(int educationId);


}


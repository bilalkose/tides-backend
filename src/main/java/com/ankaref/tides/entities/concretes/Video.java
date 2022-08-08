package com.ankaref.tides.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table(name="videos")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","education"})
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "video_id",nullable = false)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "educationId",nullable = false)
    private int educationId;

    @Column(name = "video",nullable = false)
    private String video;



}

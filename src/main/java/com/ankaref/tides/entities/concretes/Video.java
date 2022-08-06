package com.ankaref.tides.entities.concretes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table(name="videos")
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;
    @Column(name = "name",nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "id")
    private Education education;


    //TODO: BURAYA DÖNÜLECEK VİDEOLAR VERİTABANINDA NASIL SAKLANIR BAKILACAK.
    private String video;



}

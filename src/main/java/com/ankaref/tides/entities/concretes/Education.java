package com.ankaref.tides.entities.concretes;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.xml.bind.v2.TODO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="educations")
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="explanation",nullable = false)
    private String explanation;

    @Column(name="image",nullable = false)
    //TODO veritabanına görüntü nasıl kayıt olacak araştır. gerekli notasyonları araştır
    private String image;

    @OneToMany
    private List<Video> videos;

}

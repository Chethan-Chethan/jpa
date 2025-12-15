package com.xworkz.movies.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@Entity
@ToString

@Table(name = "movie_info")
public class MoviesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name =  "gener")
    private String gener;

    @Column(name = "release_year")
    private int releaseYear;

}


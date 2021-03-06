package com.example.alkemy.disney.service;

import com.example.alkemy.disney.model.dto.MovieSeriesDTO;
import com.example.alkemy.disney.model.dto.MovieSeriesDTOImageTitleDate;

import java.util.List;

public interface MovieSeriesServiceInterface {
    MovieSeriesDTO createMovieSeries(MovieSeriesDTO movieSeriesDTO, Boolean isAnUpdate);
    MovieSeriesDTO readMovieSeriesById(Long id);

    MovieSeriesDTO updateMovieSeries(MovieSeriesDTO movieSeriesDTO);

    MovieSeriesDTO deleteMovieSeries(Long id);

    MovieSeriesDTO addCharacterToMovieSeries(Long idMovie, Long idCharacter);

    MovieSeriesDTO removeCharacterToMovieSeries(Long idMovie, Long idCharacter);

    List<MovieSeriesDTOImageTitleDate> readMoviesSeriesWithFilters(String name, Long genreId, String order);
}

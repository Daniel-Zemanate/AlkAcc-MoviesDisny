package com.example.alkemy.disney.service.implementation;

import com.example.alkemy.disney.exception.MyCreationWithIdException;
import com.example.alkemy.disney.model.dto.GenreDTO;
import com.example.alkemy.disney.service.GenreServiceInterface;
import com.example.alkemy.disney.model.mapper.GenreMapper;
import com.example.alkemy.disney.repository.GenreRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImplementation implements GenreServiceInterface {

    final static Logger LOGGER = Logger.getLogger(GenreServiceImplementation.class);
    private GenreRepository genreRepository;
    private GenreMapper genreMapper;

    @Autowired
    public GenreServiceImplementation(GenreRepository genreRepository, GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {
        LOGGER.info("Executing genre creation in class: GenreServiceImplementation");

        //VALIDATION: AUTOINCREMENT ID. NO NEEDED.
        if (genreDTO.getIdGenre() != null){
            throw new MyCreationWithIdException("Something went wrong when createGenre in -GenreServiceImplementation-");
        }

        return genreMapper.toGenreDTO(genreRepository.save(genreMapper.toGenreEntity(genreDTO)));
    }
}
package com.example.alkemy.disney.model.mapper;

import com.example.alkemy.disney.model.dto.CharacterDTO;
import com.example.alkemy.disney.model.dto.CharacterDTOImageName;
import com.example.alkemy.disney.model.entity.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


//    private Long idCharacter;
//    private String image;
//    private String name;
//    private Integer age;
//    private Integer weight;
//    private String history;
//    private List<MovieSeriesDTO> movieSeriesDTOList;

@Component
public class CharacterMapper {

    @Autowired
    private MovieSeriesMapper movieSeriesMapper;

//    @Autowired
//    public CharacterMapper(MovieSeriesMapper movieSeriesMapper) {
//        this.movieSeriesMapper = movieSeriesMapper;
//    }

    //-------------- FROM DTO TO ENTITY --------------

    public CharacterEntity toCharacterEntity(CharacterDTO dto){
        CharacterEntity characterEntity = new CharacterEntity();

        characterEntity.setIdCharacter(dto.getIdCharacter());
        characterEntity.setImage(dto.getImage());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());

        return characterEntity;
    }

    public List<CharacterEntity> toListCharacterEntity(List<CharacterDTO> dtoList){
        List<CharacterEntity> characterEntityList = new ArrayList<>();

        for (CharacterDTO characterDTO : dtoList) {

            characterEntityList.add(toCharacterEntity(characterDTO));
        }

        return characterEntityList;
    }
    //-------------- FROM DTO TO ENTITY --------------

    //-------------- FROM ENTITY TO DTO --------------
    public CharacterDTO toCharacterDTO(CharacterEntity entity, Boolean loadMovieSeriesList){
        CharacterDTO characterDTO = new CharacterDTO();

        characterDTO.setIdCharacter(entity.getIdCharacter());
        characterDTO.setImage(entity.getImage());
        characterDTO.setName(entity.getName());
        characterDTO.setAge(entity.getAge());
        characterDTO.setWeight(entity.getWeight());
        characterDTO.setHistory(entity.getHistory());
        if (loadMovieSeriesList){

            characterDTO.setMovieSeriesList(movieSeriesMapper.toListMovieSeriesDTO(entity.getMovieSeriesList()));
        }

        return characterDTO;
    }

    public List<CharacterDTOImageName> toListCharacterDTOImageName(List<CharacterEntity> entityList){
        List<CharacterDTOImageName> characterDTOImageNameList = new ArrayList<>();
        CharacterDTOImageName characterDTOImageName = new CharacterDTOImageName();

        for (CharacterEntity characterEntity: entityList) {
            characterDTOImageName.setImage(characterEntity.getImage());
            characterDTOImageName.setName(characterEntity.getName());

            characterDTOImageNameList.add(characterDTOImageName);
        }

        return characterDTOImageNameList;
    }

    //-------------- FROM ENTITY TO DTO --------------


}
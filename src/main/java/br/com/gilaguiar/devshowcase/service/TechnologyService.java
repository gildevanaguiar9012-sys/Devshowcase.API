package br.com.gilaguiar.devshowcase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gilaguiar.devshowcase.dto.TechnologyRequestDTO;
import br.com.gilaguiar.devshowcase.dto.TechnologyResponseDTO;
import br.com.gilaguiar.devshowcase.entity.Technology;
import br.com.gilaguiar.devshowcase.repository.TechnologyRepository;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public TechnologyResponseDTO create(TechnologyRequestDTO dto) {

        Technology technology = new Technology();

        technology.setName(dto.getName());

        Technology savedTechnology =
                technologyRepository.save(technology);

        return toResponseDTO(savedTechnology);
    }

    public List<TechnologyResponseDTO> findAll() {

        return technologyRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private TechnologyResponseDTO toResponseDTO(
            Technology technology) {

        return new TechnologyResponseDTO(
                technology.getId(),
                technology.getName()
        );
    }
}
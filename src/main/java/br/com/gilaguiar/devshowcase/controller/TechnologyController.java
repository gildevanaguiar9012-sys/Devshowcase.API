package br.com.gilaguiar.devshowcase.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gilaguiar.devshowcase.dto.TechnologyRequestDTO;
import br.com.gilaguiar.devshowcase.dto.TechnologyResponseDTO;
import br.com.gilaguiar.devshowcase.service.TechnologyService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping
    public ResponseEntity<TechnologyResponseDTO> create(
            @Valid @RequestBody TechnologyRequestDTO dto) {

        TechnologyResponseDTO technology =
                technologyService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(technology);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponseDTO>> findAll() {

        return ResponseEntity.ok(
                technologyService.findAll()
        );
    }
}
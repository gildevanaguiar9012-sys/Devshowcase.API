package br.com.gilaguiar.devshowcase.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.gilaguiar.devshowcase.dto.ProfileRequestDTO;
import br.com.gilaguiar.devshowcase.dto.ProfileResponseDTO;
import br.com.gilaguiar.devshowcase.service.ProfileService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> create(
            @Valid @RequestBody ProfileRequestDTO dto) {

        ProfileResponseDTO profile = profileService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profile);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> findById(
            @PathVariable Long id) {

        ProfileResponseDTO profile = profileService.findById(id);

        return ResponseEntity.ok(profile);
    }
}
package br.com.gilaguiar.devshowcase.service;

import org.springframework.stereotype.Service;

import br.com.gilaguiar.devshowcase.dto.ProfileRequestDTO;
import br.com.gilaguiar.devshowcase.dto.ProfileResponseDTO;
import br.com.gilaguiar.devshowcase.entity.Profile;
import br.com.gilaguiar.devshowcase.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileResponseDTO create(ProfileRequestDTO dto) {

        Profile profile = new Profile();

        profile.setName(dto.getName());
        profile.setEmail(dto.getEmail());
        profile.setBio(dto.getBio());
        profile.setGithubUrl(dto.getGithubUrl());
        profile.setLinkedinUrl(dto.getLinkedinUrl());

        Profile savedProfile = profileRepository.save(profile);

        return toResponseDTO(savedProfile);
    }

    public ProfileResponseDTO findById(Long id) {

        Profile profile = profileRepository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Perfil não encontrado")
                );

        return toResponseDTO(profile);
    }

    private ProfileResponseDTO toResponseDTO(Profile profile) {

        return new ProfileResponseDTO(
                profile.getId(),
                profile.getName(),
                profile.getEmail(),
                profile.getBio(),
                profile.getGithubUrl(),
                profile.getLinkedinUrl()
        );
    }
}
package br.com.gilaguiar.devshowcase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gilaguiar.devshowcase.dto.ProjectRequestDTO;
import br.com.gilaguiar.devshowcase.dto.ProjectResponseDTO;
import br.com.gilaguiar.devshowcase.entity.Profile;
import br.com.gilaguiar.devshowcase.entity.Project;
import br.com.gilaguiar.devshowcase.entity.Technology;
import br.com.gilaguiar.devshowcase.repository.ProfileRepository;
import br.com.gilaguiar.devshowcase.repository.ProjectRepository;
import br.com.gilaguiar.devshowcase.repository.TechnologyRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProfileRepository profileRepository;
    private final TechnologyRepository technologyRepository;

    public ProjectService(
            ProjectRepository projectRepository,
            ProfileRepository profileRepository,
            TechnologyRepository technologyRepository) {

        this.projectRepository = projectRepository;
        this.profileRepository = profileRepository;
        this.technologyRepository = technologyRepository;
    }

    public ProjectResponseDTO create(ProjectRequestDTO dto) {

        Profile profile = profileRepository.findById(dto.getProfileId())
                .orElseThrow(() ->
                        new RuntimeException("Perfil não encontrado"));

        List<Technology> technologies =
                technologyRepository.findAllById(dto.getTechnologyIds());

        Project project = new Project();

        project.setTitle(dto.getTitle());
        project.setDescription(dto.getDescription());
        project.setRepositoryUrl(dto.getRepositoryUrl());
        project.setDemoUrl(dto.getDemoUrl());
        project.setProfile(profile);
        project.setTechnologies(technologies);

        Project savedProject = projectRepository.save(project);

        return toResponseDTO(savedProject);
    }

    public List<ProjectResponseDTO> findAll() {

        return projectRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private ProjectResponseDTO toResponseDTO(Project project) {

        List<Long> technologyIds = project.getTechnologies()
                .stream()
                .map(Technology::getId)
                .toList();

        return new ProjectResponseDTO(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getRepositoryUrl(),
                project.getDemoUrl(),
                project.getProfile().getId(),
                technologyIds
        );
    }
}
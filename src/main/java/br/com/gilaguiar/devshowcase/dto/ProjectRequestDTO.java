package br.com.gilaguiar.devshowcase.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ProjectRequestDTO {

    @NotBlank(message = "O título do projeto é obrigatório")
    private String title;

    @NotBlank(message = "A descrição do projeto é obrigatória")
    private String description;

    @NotBlank(message = "A URL do repositório é obrigatória")
    @Pattern(
        regexp = "^https?://.+$",
        message = "A URL do repositório deve ser válida"
    )
    private String repositoryUrl;

    @Pattern(
        regexp = "^https?://.+$",
        message = "A URL da demonstração deve ser válida"
    )
    private String demoUrl;

    @NotNull(message = "O perfil é obrigatório")
    private Long profileId;

    private List<Long> technologyIds;

    public ProjectRequestDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getDemoUrl() {
        return demoUrl;
    }

    public void setDemoUrl(String demoUrl) {
        this.demoUrl = demoUrl;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public List<Long> getTechnologyIds() {
        return technologyIds;
    }

    public void setTechnologyIds(List<Long> technologyIds) {
        this.technologyIds = technologyIds;
    }
}
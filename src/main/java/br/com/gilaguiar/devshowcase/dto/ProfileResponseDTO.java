package br.com.gilaguiar.devshowcase.dto;

public class ProfileResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String bio;
    private String githubUrl;
    private String linkedinUrl;

    public ProfileResponseDTO() {
    }

    public ProfileResponseDTO(
            Long id,
            String name,
            String email,
            String bio,
            String githubUrl,
            String linkedinUrl) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.githubUrl = githubUrl;
        this.linkedinUrl = linkedinUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getLinkedinUrl() {
        return linkedinUrl;
    }

    public void setLinkedinUrl(String linkedinUrl) {
        this.linkedinUrl = linkedinUrl;
    }
}
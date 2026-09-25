package br.com.gilaguiar.devshowcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gilaguiar.devshowcase.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
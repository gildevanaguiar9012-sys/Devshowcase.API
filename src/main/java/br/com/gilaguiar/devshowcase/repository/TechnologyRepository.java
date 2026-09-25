package br.com.gilaguiar.devshowcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gilaguiar.devshowcase.entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

}
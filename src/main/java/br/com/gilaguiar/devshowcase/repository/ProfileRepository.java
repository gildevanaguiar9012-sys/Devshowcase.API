package br.com.gilaguiar.devshowcase.repository;

import br.com.gilaguiar.devshowcase.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
package br.com.gilaguiar.devshowcase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.gilaguiar.devshowcase.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
package org.javaguru.travel.insurance.core.repository;

import org.javaguru.travel.insurance.core.domain.Classifier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassifierRepository extends JpaRepository<Classifier,Long> {

    Optional<Classifier> findByTitle(String title);

}

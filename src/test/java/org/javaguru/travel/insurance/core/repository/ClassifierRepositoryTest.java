package org.javaguru.travel.insurance.core.repository;

import org.javaguru.travel.insurance.core.domain.Classifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ClassifierRepositoryTest {

    @Autowired
    private ClassifierRepository classifierRepository;


    @Test
    void shouldFindRiskTypeClassifier(){
        Optional<Classifier> result = classifierRepository.findByTitle("RISK_TYPE");
        assertTrue(result.isPresent());
        assertEquals(result.get().getTitle(), "RISK_TYPE");
    }

    @Test
    void shouldNotFindRiskTypeClassifier(){
        Optional<Classifier> result = classifierRepository.findByTitle("RISKI_TYPE");
        assertTrue(result.isEmpty());

    }


}

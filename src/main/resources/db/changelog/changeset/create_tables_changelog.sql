--changeset artei:1
CREATE SCHEMA IF NOT EXISTS "java_real_practice_insurance";

SET search_path TO "java_real_practice_insurance";

CREATE TABLE IF NOT EXISTS classifiers (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(200) NOT NULL UNIQUE,
  description VARCHAR(100) NOT NULL
);


CREATE TABLE IF NOT EXISTS classifier_values (
  id BIGSERIAL PRIMARY KEY,
  classifier_id BIGINT NOT NULL,
  ic VARCHAR(200) NOT NULL UNIQUE,
  description VARCHAR(500) NOT NULL,
  CONSTRAINT fk_classifier FOREIGN KEY (classifier_id) REFERENCES classifiers (id) ON DELETE CASCADE
);


-- Устанавливаем схему (если нужно)
SET search_path TO "java_real_practice_insurance";

-- Вставляем классификатор RISK_TYPE, если его нет
INSERT INTO classifiers (title, description)
VALUES ('RISK_TYPE', 'Risk type classifier')
ON CONFLICT (title) DO NOTHING;

-- Добавляем значения в classifier_values, если их нет
INSERT INTO classifier_values (classifier_id, ic, description)
SELECT cl.id, 'TRAVEL_MEDICAL', 'Travel policy medical risk type'
FROM classifiers cl WHERE cl.title = 'RISK_TYPE'
                      AND NOT EXISTS (SELECT 1 FROM classifier_values WHERE ic = 'TRAVEL_MEDICAL');

INSERT INTO classifier_values (classifier_id, ic, description)
SELECT cl.id, 'TRAVEL_CANCELLATION', 'Travel policy trip cancellation risk type'
FROM classifiers cl WHERE cl.title = 'RISK_TYPE'
                      AND NOT EXISTS (SELECT 1 FROM classifier_values WHERE ic = 'TRAVEL_CANCELLATION');

INSERT INTO classifier_values (classifier_id, ic, description)
SELECT cl.id, 'TRAVEL_LOSS_BAGGAGE', 'Travel policy baggage lose risk type'
FROM classifiers cl WHERE cl.title = 'RISK_TYPE'
                      AND NOT EXISTS (SELECT 1 FROM classifier_values WHERE ic = 'TRAVEL_LOSS_BAGGAGE');

INSERT INTO classifier_values (classifier_id, ic, description)
SELECT cl.id, 'TRAVEL_THIRD_PARTY_LIABILITY', 'Travel policy third party liability risk type'
FROM classifiers cl WHERE cl.title = 'RISK_TYPE'
                      AND NOT EXISTS (SELECT 1 FROM classifier_values WHERE ic = 'TRAVEL_THIRD_PARTY_LIABILITY');

INSERT INTO classifier_values (classifier_id, ic, description)
SELECT cl.id, 'TRAVEL_EVACUATION', 'Travel policy evacuation risk type'
FROM classifiers cl WHERE cl.title = 'RISK_TYPE'
                      AND NOT EXISTS (SELECT 1 FROM classifier_values WHERE ic = 'TRAVEL_EVACUATION');

INSERT INTO classifier_values (classifier_id, ic, description)
SELECT cl.id, 'TRAVEL_SPORT_ACTIVITIES', 'Travel policy sport activities risk type'
FROM classifiers cl WHERE cl.title = 'RISK_TYPE'
                      AND NOT EXISTS (SELECT 1 FROM classifier_values WHERE ic = 'TRAVEL_SPORT_ACTIVITIES');

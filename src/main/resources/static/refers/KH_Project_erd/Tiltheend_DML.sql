INSERT INTO QUESTION (QUESTION_ID, QUESTION, ORDERS)
VALUES ('Q1', "현대 자동차의 브랜드 이미지에 만족하십니까?", 1);

INSERT INTO QUESTION (QUESTION_ID, QUESTION, ORDERS)
VALUES ('Q2', "현대 차량의 주행성능에 만족하십니까?", 2);

INSERT INTO QUESTION (QUESTION_ID, QUESTION, ORDERS)
VALUES ('Q3', "현대 차량의 가격에 만족하십니까?", 3);

INSERT INTO QUESTION (QUESTION_ID, QUESTION, ORDERS)
VALUES ('Q4', "현대 차량의 디자인에 만족하십니까?", 4);

INSERT INTO QUESTION (QUESTION_ID, QUESTION, ORDERS)
VALUES ('Q5', "현대 차량의 내구성에 만족하십니까?", 5);

INSERT INTO QUESTION (QUESTION_ID, QUESTION, ORDERS)
VALUES ('Q6', "현대 직원의 응대에 만족하십니까?", 6);

INSERT INTO ANSWER (ANSWER_ID, ANSWER, ORDERS)
VALUES ('E1', "매우만족", 1); 

INSERT INTO ANSWER (ANSWER_ID, ANSWER, ORDERS)
VALUES ('E2', "만족", 2); 

INSERT INTO ANSWER (ANSWER_ID, ANSWER, ORDERS)
VALUES ('E3', "보통", 3); 

INSERT INTO ANSWER (ANSWER_ID, ANSWER, ORDERS)
VALUES ('E4', "불만족", 4); 

INSERT INTO ANSWER (ANSWER_ID, ANSWER, ORDERS)
VALUES ('E5', "매우불만족", 5); 

INSERT SURVEY (QUESTION_ID, ANSWER_ID)
VALUES ('Q1', 'E1'),('Q1', 'E2'),('Q1', 'E3'),('Q1', 'E4'),('Q1', 'E5'),
('Q2', 'E1'),('Q2', 'E2'),('Q2', 'E3'),('Q2', 'E4'),('Q2', 'E5'),
('Q3', 'E1'),('Q3', 'E2'),('Q3', 'E3'),('Q3', 'E4'),('Q3', 'E5'),
('Q4', 'E1'),('Q4', 'E2'),('Q4', 'E3'),('Q4', 'E4'),('Q4', 'E5'),
('Q5', 'E1'),('Q5', 'E2'),('Q5', 'E3'),('Q5', 'E4'),('Q5', 'E5'),
('Q6', 'E1'),('Q6', 'E2'),('Q6', 'E3'),('Q6', 'E4'),('Q6', 'E5');
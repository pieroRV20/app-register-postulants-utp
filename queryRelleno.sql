
INSERT INTO postulants (id,birthday,dni,email,last_name,name,name_school,degree_id,observation) 
VALUES (9,'2003-11-05','5235235','renzo3@gmail.com','Lima','Renzo','Trilce',1,"Soy estudioso");

INSERT INTO postulants (id,birthday,dni,email,last_name,name,name_school,degree_id,observation) 
VALUES (10,'2003-11-05','3463453','clau@gmail.com','Manrique','Claudia','Newton',2,"Primer Puesto");

INSERT INTO postulants (id,birthday,dni,email,last_name,name,name_school,degree_id,observation) 
VALUES (11,'2001-11-05','834645123','marceS@gmail.com','Marcelo','Stefano','Merced',1,"Repito 1 año");

INSERT INTO postulants (id,birthday,dni,email,last_name,name,name_school,degree_id,observation) 
VALUES (12,'2002-11-05','81238123','luisS@gmail.com','Castillo','Luis','Saco Oliveros',4,"Quinto Superior");

INSERT INTO postulants (id,birthday,dni,email,last_name,name,name_school,degree_id,observation) 
VALUES (13,'2004-07-15','41532101','carla@gmail.com','Romero','Alexandra','Innova School',5,"Primero pusto toda la secundaria");

INSERT INTO postulants (id,birthday,dni,email,last_name,name,name_school,degree_id,observation) 
VALUES (14,'2003-07-25','47536123','camila@gmail.com','Arco','Camila','Prolog',3,"Campeona de Matematicas 2022");

INSERT INTO registers  
(id,send_day,origin_id,postulant_id,status_id,evaluator_id)
VALUES (8,'2022-02-01',1,9,1,1);

INSERT INTO registers  
(id,send_day,origin_id,postulant_id,status_id,evaluator_id)
VALUES (9,'2022-12-11',1,10,1,2);

INSERT INTO registers  
(id,send_day,origin_id,postulant_id,status_id)
VALUES (10,'2022-12-01',1,11,1);

INSERT INTO registers  
(id,send_day,origin_id,postulant_id,status_id,evaluator_id)
VALUES (11,'2023-01-10',1,12,1,2);

INSERT INTO registers  
(id,send_day,origin_id,postulant_id,status_id)
VALUES (12,'2022-12-01',1,13,1);

INSERT INTO registers  
(id,send_day,origin_id,postulant_id,status_id)
VALUES (13,'2022-12-01',1,14,1);
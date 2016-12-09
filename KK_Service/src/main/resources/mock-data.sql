insert into employee(name, last_name, id_number) values ('Pepito', 'Rodriguez', '32165487'), ('Juanchito', 'Pendejez', '98765432');

insert into user (user,password,user_type,employee_id) values ('m', 'pwd', 'm', 1),('a', 'pwd', 'a', 2);

insert into ingredient (description, measure_unit, ingredient_type, current_stock) values ('lechuga', 'u', 'verdura',50), ('tomate', 'k', 'verdura',20),
('arroz', 'k', 'grano',20), ('platano', 'k', 'fruta',20), ('carne', 'k', 'carne',100);

insert into dish (name, description, price, daily_stock) values ('Ensalada', 'Rica ensalada de lechuga y tomates.', 5.00, 10),('Arroz a la cubana', 'Arroz con plátano.', 12.00, 20);

insert into ingredient_dish (dish_id,ingredient_id,amount) values (1,1,0.25), (1,2,0.2), (2,2,0.3), (2,3,0.1);

insert into krusty_table (number) values (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12),(13),(14),(15),(16),(17),(18),(19),(20),(21),(22),(23),(24),(25),(26),(27),(28),(29),(30),(31),(32),(33),(34),(35),(36),(37),(38),(39),(40),(41),(42),(43),(44),(45),(46),(47),(48),(49),(50),(51),(52),(53),(54),(55),(56),(57),(58),(59),(60),(61),(62),(63),(64),(65),(66),(67),(68),(69),(70),(71),(72),(73),(74),(75),(76),(77),(78),(79),(80),(81),(82),(83),(84),(85),(86),(87),(88),(89),(90),(91),(92),(93),(94),(95),(96),(97),(98),(99),(100);
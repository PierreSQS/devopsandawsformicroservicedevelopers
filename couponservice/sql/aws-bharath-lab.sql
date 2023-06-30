drop DATABASE IF Exists `aws-bharath-db` ;
create DATABASE  IF NOT EXISTS `aws-bharath-db`;

use `aws-bharath-db`;

create table product(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);

create table coupon(
id int AUTO_INCREMENT PRIMARY KEY,
code varchar(20) UNIQUE,
discount decimal(8,3),
exp_date date 
);

#UPDATE user SET password=PASSWORD('Galerien3?') WHERE User='root' AND Host = 'localhost';

#ALTER USER 'root'@'localhost' IDENTIFIED BY 'Galerien3?';
#flush privileges;
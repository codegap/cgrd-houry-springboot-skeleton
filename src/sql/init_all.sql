/*!40101 SET character_set_client = utf8 */;

drop database if exists cgrd_houry;
create database cgrd_houry; 
use cgrd_houry;
source _create_schema.sql

drop database if exists cgrd_houry_test;
create database cgrd_houry_test; 
use cgrd_houry_test;
source _create_schema.sql
source _create_testdata.sql
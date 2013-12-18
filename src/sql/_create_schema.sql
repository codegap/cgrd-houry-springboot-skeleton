/*!40101 SET character_set_client = utf8 */;


--
-- Table structure for table `project`
--
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `task`
--
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `project_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_task_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `entry`
--
DROP TABLE IF EXISTS `entry`;
CREATE TABLE `entry` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `start` bigint NOT NULL,
  `end` bigint DEFAULT '0',
  `description` varchar(255) DEFAULT '',
  `task_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_entry_task` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `games` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `version` INT NOT NULL DEFAULT 0,
  `created` TIMESTAMP NOT NULL DEFAULT NOW(),
  `modified` TIMESTAMP NOT NULL DEFAULT NOW(),
  `status` VARCHAR(45) NOT NULL,
  `bet_amount` INT NOT NULL,
  `action` ENUM('HIT', 'STAND') NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `users` (`id`));

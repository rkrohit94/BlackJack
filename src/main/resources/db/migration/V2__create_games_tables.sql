CREATE TABLE `games` (
  `id`                     INT                  NOT NULL AUTO_INCREMENT,
  `user_id`                INT                  NOT NULL,
  `version`                INT                  NOT NULL DEFAULT 0,
  `dealer_card`            VARCHAR(45)          NULL,
  `player_card`            VARCHAR(45)          NULL,
  `player_card_value`      INT                  NULL,
  `dealer_card_value`      INT                  NULL,
  `created`                TIMESTAMP            NOT NULL DEFAULT NOW(),
  `modified`               TIMESTAMP            NOT NULL DEFAULT NOW(),
  `status`                 VARCHAR(45)          NULL,
  `bet_amount`             INT                  NOT NULL,
  `action`                 ENUM('HIT', 'STAND') NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `users` (`id`));

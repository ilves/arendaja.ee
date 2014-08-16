CREATE TABLE IF NOT EXISTS `ad` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `active` enum('1','0') COLLATE utf8_bin NOT NULL,
  `title` varchar(255) COLLATE utf8_bin NOT NULL,
  `summary` text COLLATE utf8_bin,
  `content` longtext COLLATE utf8_bin,
  `company_title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `company_country` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `company_city` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date_created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1;
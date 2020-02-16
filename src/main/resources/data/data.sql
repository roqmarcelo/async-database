DROP TABLE IF EXISTS application_log;

CREATE TABLE application_log (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  log_date TIMESTAMP NOT NULL,
  log_message VARCHAR(250) NOT NULL
);
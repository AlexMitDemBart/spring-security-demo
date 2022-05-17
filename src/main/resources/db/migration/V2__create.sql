CREATE TABLE users
(
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  INT      NOT NULL DEFAULT 1,
    PRIMARY KEY (username)
);

CREATE TABLE authorities
(
    id        INT         NOT NULL AUTO_INCREMENT,
    authority VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE users_authorities
(
    users_entity_username VARCHAR(50)  NOT NULL,
    authorities_id INT          NOT NULL,
    PRIMARY KEY (users_entity_username, authorities_id)
);
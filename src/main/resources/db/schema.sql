CREATE TABLE post
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    title        VARCHAR(128) NOT NULL,
    summary      VARCHAR(128),
    post_text    VARCHAR(256) NOT NULL,
    created_date DATETIME         NOT NULL,
    updated_date DATETIME         NOT NULL,
    PRIMARY KEY (id)
);
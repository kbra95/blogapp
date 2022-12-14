DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS post_tag;

CREATE TABLE post
(
    id           SERIAL      NOT NULL ,
    title        VARCHAR(128) NOT NULL,
    summary      VARCHAR(128),
    post_text    VARCHAR(256) NOT NULL,
    created_date TIMESTAMP WITH TIME ZONE     NOT NULL,
    updated_date TIMESTAMP WITH TIME ZONE      NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tag
(
    id       SERIAL      NOT NULL ,
    tag_name VARCHAR(128) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE post_tag
(
    post_id INTEGER      NOT NULL,
    tag_id  INTEGER NOT NULL,

    PRIMARY KEY (post_id, tag_id)
);

CREATE UNIQUE INDEX uidx_tag_name
    ON tag (tag_name);
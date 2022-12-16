DROP TABLE IF EXISTS post_tag;
DROP TABLE IF EXISTS user_role;

DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE post
(
    id           SERIAL                   NOT NULL,
    title        VARCHAR(128)             NOT NULL,
    summary      VARCHAR(128),
    post_text    VARCHAR(256)             NOT NULL,
    created_by    VARCHAR(256),
    created_date TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_date TIMESTAMP WITH TIME ZONE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tag
(
    id       SERIAL       NOT NULL,
    tag_name VARCHAR(128) NOT NULL,

    PRIMARY KEY (id)
);

CREATE TABLE post_tag
(
    post_id INTEGER NOT NULL REFERENCES post (id),
    tag_id  INTEGER NOT NULL REFERENCES tag (id),

    PRIMARY KEY (post_id, tag_id)
);

CREATE TABLE users
(
    id           serial PRIMARY KEY,
    name         VARCHAR(128),
    user_name    VARCHAR(128),
    password     VARCHAR(128),
    created_date TIMESTAMP WITH TIME ZONE NOT NULL,
    updated_date TIMESTAMP WITH TIME ZONE NOT NULL
);

CREATE TABLE roles
(
    id   serial PRIMARY KEY,
    name VARCHAR(128) NOT NULL
);

CREATE TABLE user_role
(
    user_id int not null REFERENCES users (id),
    role_id int not null REFERENCES roles (id),
    PRIMARY KEY (user_id, role_id)
);

CREATE UNIQUE INDEX uidx_tag_name
    ON tag (tag_name);
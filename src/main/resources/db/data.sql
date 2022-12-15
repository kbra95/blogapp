INSERT INTO post(id, title,
                 summary,
                 post_text,
                 created_date,
                 updated_date)
VALUES (1000, 'Post 1', 'Post 1 Summary',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. ',
        NOW(), NOW());


INSERT INTO post(id, title,
                 summary,
                 post_text,
                 created_date,
                 updated_date)
VALUES (2000, 'Post 2', 'Post 2 Summary',
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. ',
        NOW(), NOW());

INSERT INTO tag(id, tag_name)
VALUES (1000, 'Test Tag');
INSERT INTO tag(id, tag_name)
VALUES (2000, 'Test Tag 2');

INSERT INTO post_tag(post_id, tag_id)
VALUES (1000, 1000);
INSERT INTO post_tag(post_id, tag_id)
VALUES (2000, 1000);


INSERT INTO roles(id, name)
VALUES (1000, 'ROLE_USER');
INSERT INTO roles(id, name)
VALUES (2000, 'ROLE_ADMIN');
INSERT INTO roles(id, name)
VALUES (3000, 'ROLE_SUPER_ADMIN');


INSERT INTO users(id,
                  name,
                  user_name,
                  password,
                  created_date,
                  updated_date)
VALUES (1000, 'John Tra', 'john123', '1234', NOW(), NOW()),
       (2000, 'Will Smith', 'will123', '1234', NOW(), NOW()),
       (3000, 'Jim Carry', 'jim123', '1234', NOW(), NOW());

INSERT INTO user_role(user_id, role_id) VALUES
                                            (1000, 1000),
                                            (1000, 2000),
                                            (1000, 3000),
                                            (2000, 1000),
                                            (3000, 1000);
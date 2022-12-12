INSERT INTO post(id,title,
                 summary,
                 post_text,
                 created_date,
                 updated_date) VALUES (1000,'Post 1', 'Post 1 Summary' , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. ' , NOW(), NOW());


INSERT INTO post(id,title,
                 summary,
                 post_text,
                 created_date,
                 updated_date) VALUES (2000,'Post 2', 'Post 2 Summary' , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. ' , NOW(), NOW());

INSERT INTO tag(id,tag_name) VALUES (1000,'Test Tag');
INSERT INTO tag(id,tag_name) VALUES (2000,'Test Tag 2');

INSERT INTO post_tag(post_id,tag_id) VALUES (1000,1000);
INSERT INTO post_tag(post_id,tag_id) VALUES (2000,1000);
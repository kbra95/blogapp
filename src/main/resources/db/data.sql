INSERT INTO post(id,title,
                 summary,
                 post_text,
                 created_date,
                 updated_date) VALUES (1,'Post 1', 'Post 1 Summary' , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. ' , NOW(), NOW());


INSERT INTO post(id,title,
                 summary,
                 post_text,
                 created_date,
                 updated_date) VALUES (2,'Post 2', 'Post 2 Summary' , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. ' , NOW(), NOW());

INSERT INTO tag(id,tag_name) VALUES (1,'Test Tag');
INSERT INTO tag(id,tag_name) VALUES (2,'Test Tag 2');

INSERT INTO post_tag(post_id,tag_id) VALUES (1,1);
INSERT INTO post_tag(post_id,tag_id) VALUES (2,1);
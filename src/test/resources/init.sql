INSERT INTO post(id,title,
                 summary,
                 post_text,
                 created_date,
                 updated_date) VALUES (100,'Post 1', 'Post 1 Summary' , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. ' , NOW(), NOW());


INSERT INTO post(id,title,
                 summary,
                 post_text,
                 created_date,
                 updated_date) VALUES (200,'Post 2', 'Post 2 Summary' , 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam. ' , NOW(), NOW());

INSERT INTO tag(id,tag_name) VALUES (100,'Test Tag');
INSERT INTO tag(id,tag_name) VALUES (200,'Test Tag 2');

INSERT INTO post_tag(post_id,tag_id) VALUES (100,100);
INSERT INTO post_tag(post_id,tag_id) VALUES (200,100);
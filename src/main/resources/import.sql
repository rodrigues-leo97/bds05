INSERT INTO tb_user (name, email, password) VALUES ('Bob Brown', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Brown', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre(name) VALUES ('Heróis');
INSERT INTO tb_genre(name) VALUES ('Ação');


INSERT INTO tb_movie(title, sub_title, year, img_uri, synopsis, genre_id) VALUES ('Vingadores', 'Ultimato', 2019, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT3JKq4Xne_J5_X-n0iHColGkmVpIYmyfBfmyUvocXD4ijZSftuLyMvhwzye38F6eYIRAY&usqp=CAU', 'Sinopse não revelada', 1);


INSERT INTO tb_review(text, user_id, movie_id) VALUES ('Texto de exemplo', 1, 1);


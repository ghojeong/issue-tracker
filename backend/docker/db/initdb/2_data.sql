INSERT INTO `pyrodb`.`user`(id, `name`, avatarUrl)
VALUES ('ink-0', 'ink-0',
        'https://avatars.githubusercontent.com/u/71919983?v=4'),
       ('sanhee', '노을',
        'https://avatars.githubusercontent.com/u/73760074?v=4'),
       ('juddroid', 'Raccoon',
        'https://avatars.githubusercontent.com/u/70361152?v=4'),
       ('HoonHaChoi', '최훈하',
        'https://avatars.githubusercontent.com/u/33626693?v=4'),
       ('ghojeong', '고정완',
        'https://avatars.githubusercontent.com/u/38595650?v=4'),
       ('honux77', 'Hoyoung Jung',
        'https://avatars.githubusercontent.com/u/2168702?v=4'),
       ('godrm', 'Jung Kim',
        'https://avatars.githubusercontent.com/u/278988?v=4'),
       ('crongro', 'crong',
        'https://avatars.githubusercontent.com/u/1456761?v=4');

INSERT INTO `pyrodb`.`email`(email, userId)
VALUES ('ink@codesquad.com', 'ink-0'),
       ('sanhee@codesquad.com', 'sanhee'),
       ('juddroid@codesquad.com', 'juddroid'),
       ('HoonHaChoi@codesquad.com', 'HoonHaChoi'),
       ('ghojeong@codesquad.com', 'ghojeong'),
       ('honux77@codesquad.com', 'honux77'),
       ('godrm@codesquad.com', 'godrm'),
       ('crongro@codesquad.com', 'crongro');

INSERT INTO `pyrodb`.`status` (`id`)
VALUES ('OPEN'),
       ('CLOSE'),
       ('ALL'),
       ('EXPIRED');

create table user
(
    id            int auto_increment
        primary key,
    time          mediumtext                      not null,
    ip            text                            not null,
    userName      text collate utf8mb4_general_ci not null,
    userPassword  text collate utf8mb4_general_ci not null,
    userSignature text collate utf8_croatian_ci   not null,
    userTag       text collate utf8mb4_general_ci null
)
    collate = utf8_bin;


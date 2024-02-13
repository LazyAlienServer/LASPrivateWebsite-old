create table violations
(
    id             int auto_increment
        primary key,
    MinecraftUUID text not null,
    WebsiteUUID   text not null,
    reason         text not null,
    BannedTime    text not null,
    PermitTime    text not null,
    constraint violations_id_uindex
        unique (id)
);


create table bd_sms_record
(
    id            int auto_increment
        primary key,
    user_id       bigint       null comment 'id',
    type          int          null comment 'sso',
    relative_id   bigint       null comment 'id',
    phone         varchar(13)  null,
    description   text         null,
    send_date     datetime     null,
    batch_id      varchar(255) null comment 'id',
    status        int          null,
    complete_date datetime     null,
    update_date   datetime     null,
    create_date   datetime     null,
    delete_flag   int(2)       null
)
    charset = utf8;


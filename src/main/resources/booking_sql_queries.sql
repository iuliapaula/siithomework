create table accomodation
(
    id integer
        constraint accomodation_pk
            primary key,
    type varchar(32),
    bed_type varchar(32),
    max_guests integer,
    description varchar(512)
);

create table room_fair
(
    id integer
        constraint room_fair_pk
        primary key,
    value double precision,
    season varchar(32)
);

create table accomodation_fair_relation
(
    id integer
        constraint accommodation_fair_relation_pk
        primary key,
    id_accomodation integer references  accomodation(id),
    id_room_fair integer references room_fair(id)
)
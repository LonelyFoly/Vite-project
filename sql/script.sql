DROP SCHEMA if exists BASE cascade;
CREATE SCHEMA BASE;

CREATE TABLE BASE.t_role(
    id TEXT PRIMARY KEY
);

CREATE TABLE BASE.t_user
(
    id uuid,
    login              text,
    encrypted_password text,
    email text,
    PRIMARY KEY (id)
);

CREATE TABLE BASE.t_users_roles
(
    user_id uuid,
    role_id text    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references BASE.t_user (id),
    foreign key (role_id) references BASE.t_role (id)
);
CREATE TABLE BASE.t_project
(
    short_name text,
    name text,
    creator_id uuid,
    primary key (short_name),
    foreign key (creator_id) references BASE.t_user (id)

);
drop table BASE.t_task;
CREATE TABLE BASE.t_task
(
    id bigserial,
    number bigint,
    project_short_name text,
    status text,
    title text,
    description text,
    due_date date,
    creator_id uuid,
    primary key (id),
    foreign key (creator_id) references BASE.t_user (id),
    foreign key (project_short_name) references BASE.t_project (short_name),

    unique(project_short_name, number)
);
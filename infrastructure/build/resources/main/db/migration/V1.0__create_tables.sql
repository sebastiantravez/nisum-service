CREATE TABLE users (
	id uuid NOT NULL,
	name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	password varchar(100) NOT NULL,
	created timestamp NOT NULL,
	modified timestamp NULL,
	last_login timestamp NULL,
	token varchar(300) NOT NULL,
	active boolean NOT NULL,
	CONSTRAINT user_email_pkey UNIQUE (email),
	CONSTRAINT user_pkey PRIMARY KEY (id)
);

CREATE TABLE phones (
	id uuid NOT NULL,
	number varchar(150) NOT NULL,
	city_code varchar(100) NOT NULL,
	country_code varchar(100) NOT NULL,
	user_id uuid NOT NULL,
	CONSTRAINT phone_pkey PRIMARY KEY (id),
	CONSTRAINT fk_user_phone FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE expression_configs (
	id uuid  default random_uuid() NOT NULL,
	name varchar(150) NOT NULL,
	description varchar(100) NOT NULL,
	pattern varchar(100) NOT NULL,
	CONSTRAINT global_configurations_pkey PRIMARY KEY (id),
	CONSTRAINT global_configurations_name UNIQUE (name)
);

INSERT INTO expression_configs (name, description, pattern)
	   VALUES('PASSWORD_REGULAR_EXPRESSION', 'Pattern that validate password', '^(?=\w*\d)(?=\w*[A-Z])(?=\w*[a-z])\S{8,16}$');

INSERT INTO expression_configs (name, description, pattern)
	   VALUES('EMAIL_REGULAR_EXPRESSION', 'Pattern that validate email', '^[^@]+@[^@]+\.[a-zA-Z]{2,}$');
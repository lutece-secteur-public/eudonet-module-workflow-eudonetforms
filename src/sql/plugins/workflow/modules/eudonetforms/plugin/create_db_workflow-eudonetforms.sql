DROP TABLE IF EXISTS workflow_task_eudonetforms_cf;
CREATE TABLE workflow_task_eudonetforms_cf
(
	id_task INT NOT NULL,
	id_form INT DEFAULT 0 NOT NULL,
	base_url varchar(255) default NULL,
	subscriber_login varchar(255) default NULL,
	subscriber_password varchar(255) default NULL,
	base_name varchar(255) default NULL,
	user_login varchar(255) default NULL,
	user_password varchar(255) default NULL,
	user_lang varchar(255) default NULL,
	product_name varchar(255) default NULL,
	PRIMARY KEY (id_task)
);
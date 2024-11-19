ALTER TABLE `product`
ADD picture_url VARCHAR(255),
ADD short_description VARCHAR(128),
ADD full_description VARCHAR(255),
ADD stock BOOLEAN DEFAULT TRUE,
ADD length DOUBLE NOT NULL,
ADD width DOUBLE NOT NULL,
ADD height DOUBLE NOT NULL,
ADD weight DOUBLE NOT NULL,
ADD cost DOUBLE NOT NULL,
ADD detail_name VARCHAR(128),
ADD detail_value VARCHAR(128);
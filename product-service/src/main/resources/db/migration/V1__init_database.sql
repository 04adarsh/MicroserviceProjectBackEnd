CREATE TABLE products (
  product_id BIGINT NOT NULL,
   product_name VARCHAR(255) NULL,
   product_description VARCHAR(255) NULL,
   product_image_url VARCHAR(255) NULL,
   CONSTRAINT pk_products PRIMARY KEY (product_id)
);
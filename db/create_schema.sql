CREATE TABLE product (
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    name text NOT NULL,
    description text,
    category text,
    price NUMERIC(8,2),
    unit text,
    available_amount int,
    image_path text,
    PRIMARY KEY(id)
);

CREATE INDEX idx_product_category ON product (category);
CREATE INDEX idx_product_image_path ON product (image_path);

CREATE TYPE account_status AS ENUM ('ACTIVE', 'INACTIVE', 'SUSPENDED', 'OTHER');

CREATE TABLE account (
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    username text UNIQUE NOT NULL,
    password_hash text NOT NULL,
    created_at timestamptz NOT NULL,
    status account_status NOT NULL,
    PRIMARY KEY(id)
);

CREATE INDEX idx_account_username ON account (username);

CREATE TYPE shopping_cart_status AS ENUM ('NEW', 'PURCHASED', 'DELIVERED', 'OTHER');

CREATE TABLE shopping_cart (
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    account_id BIGINT NOT NULL,
    product_id BIGINT UNIQUE NOT NULL,
    amount int NOT NULL,
    total_price NUMERIC(8,2), -- max is 999_999.99
    status shopping_cart_status NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT fk_account FOREIGN KEY(account_id) REFERENCES account(id),
    CONSTRAINT fk_product FOREIGN KEY(product_id) REFERENCES product(id)
);

CREATE INDEX idx_shopping_cart_account_id ON shopping_cart (account_id);
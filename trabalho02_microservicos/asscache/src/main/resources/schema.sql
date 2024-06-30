CREATE TABLE signature (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    app_id BIGINT NOT NULL,
    client_id BIGINT NOT NULL,
    active BOOLEAN NOT NULL,
    expiry_date TIMESTAMP NOT NULL
);

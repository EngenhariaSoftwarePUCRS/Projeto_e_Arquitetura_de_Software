DROP TABLE app IF EXISTS;
CREATE TABLE app (id BIGINT, name VARCHAR(255), monthlyCost DECIMAL(4,2), PRIMARY KEY(id));

DROP TABLE client IF EXISTS;
CREATE TABLE client (id BIGINT, name VARCHAR(255), email VARCHAR(255), PRIMARY KEY(id));

DROP TABLE signature IF EXISTS;
CREATE TABLE signature (id BIGINT, appId BIGINT, clientId BIGINT, startDate DATE, endDate DATE, PRIMARY KEY(id), FOREIGN KEY(appId) REFERENCES app(id), FOREIGN KEY(clientId) REFERENCES client(id));

DROP TABLE payment IF EXISTS;
CREATE TABLE payment (id BIGINT, signatureId BIGINT, payedValue DECIMAL(4,2), paymentDate DATE, promotion VARCHAR(100), PRIMARY KEY(id), FOREIGN KEY(signatureId) REFERENCES signature(id));

DROP TABLE user IF EXISTS;
CREATE TABLE user (id BIGINT, username VARCHAR(255), password VARCHAR(255), PRIMARY KEY(id));
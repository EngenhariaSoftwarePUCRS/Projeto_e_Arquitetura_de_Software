DROP TABLE apps IF EXISTS;
CREATE TABLE apps (id BIGINT AUTO_INCREMENT, name VARCHAR(255), monthlyCost DECIMAL(4,2), PRIMARY KEY(id));

DROP TABLE clients IF EXISTS;
CREATE TABLE clients (id BIGINT, name VARCHAR(255), email VARCHAR(255), PRIMARY KEY(id));

DROP TABLE signatures IF EXISTS;
CREATE TABLE signatures (id BIGINT, appId BIGINT, clientId BIGINT, startDate DATE, endDate DATE, PRIMARY KEY(id), FOREIGN KEY(appId) REFERENCES apps(id), FOREIGN KEY(clientId) REFERENCES clients(id));

DROP TABLE payments IF EXISTS;
CREATE TABLE payments (id BIGINT, signatureId BIGINT, payedValue DECIMAL(4,2), paymentDate DATE, promotion VARCHAR(100), PRIMARY KEY(id), FOREIGN KEY(signatureId) REFERENCES signatures(id));

DROP TABLE users IF EXISTS;
CREATE TABLE users (id BIGINT, username VARCHAR(255), password VARCHAR(255), PRIMARY KEY(id));
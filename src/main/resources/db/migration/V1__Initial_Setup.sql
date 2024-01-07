-- Create user table

CREATE TABLE user (
                       id SERIAL PRIMARY KEY,
                       login VARCHAR(255) NOT NULL,
                       lastLoginDate TIMESTAMP,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(255) NOT NULL
);

INSERT INTO user (login, lastLoginDate, password, role, shapes)
ALTER TABLE user Add CONSTRAINT fk_companyHR_ID FOREIGN KEY (companyHR_ID) REFERENCES companyHR (companyHR_ID)
CREATE TABLE companyHR (
                      id SERIAL PRIMARY KEY,
                      login VARCHAR(255) NOT NULL,
                      lastLoginDate TIMESTAMP,
                      password VARCHAR(255) NOT NULL,
                      role VARCHAR(255) NOT NULL
);

INSERT INTO companyHR (login, lastLoginDate, password, role, shapes)
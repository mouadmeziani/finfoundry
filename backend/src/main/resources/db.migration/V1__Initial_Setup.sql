CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL UNIQUE,
                            description TEXT
);

CREATE TABLE transactions (
                              id SERIAL PRIMARY KEY,
                              user_id INTEGER NOT NULL,
                              amount NUMERIC(10, 2) NOT NULL,
                              description TEXT,
                              category INTEGER,
                              date DATE NOT NULL,
                              type VARCHAR(19) NOT NULL CHECK (type IN ('income', 'expense')),
                              CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id),
                              CONSTRAINT fk_category FOREIGN KEY (category) REFERENCES categories(id)
);

CREATE TABLE budgets (
                         id SERIAL PRIMARY KEY,
                         user_id INTEGER NOT NULL,
                         period VARCHAR(10) NOT NULL CHECK (period IN ('monthly', 'annual')),
                         total_budget NUMERIC(10, 2) NOT NULL,
                         created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                         CONSTRAINT fk_user_budget FOREIGN KEY(user_id) REFERENCES users(id)
);
CREATE TABLE tags (
                      id SERIAL PRIMARY KEY,
                      name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE transaction_tags (
                                  transaction_id INTEGER NOT NULL,
                                  tag_id INTEGER NOT NULL,
                                  PRIMARY KEY (transaction_id, tag_id),
                                  CONSTRAINT fk_transaction FOREIGN KEY(transaction_id) REFERENCES transactions(id),
                                  CONSTRAINT fk_tag FOREIGN KEY(tag_id) REFERENCES tags(id)
);


CREATE INDEX idx_transactions_user_id ON transactions(user_id);
CREATE INDEX idx_transactions_date ON transactions(date);
CREATE INDEX idx_transactions_category ON transactions(category);
CREATE INDEX idx_budgets_user_id ON budgets(user_id);
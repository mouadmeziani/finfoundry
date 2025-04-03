-- ============================
-- 1. USERS (base table)
-- ============================
INSERT INTO users (name, email, password) VALUES ('Alice Johnson', 'alice@example.com', 'hashed_pwd1');
INSERT INTO users (name, email, password) VALUES ('Bob Smith', 'bob@example.com', 'hashed_pwd2');
INSERT INTO users (name, email, password) VALUES ('Carol Davis', 'carol@example.com', 'hashed_pwd3');
INSERT INTO users (name, email, password) VALUES ('David Wilson', 'david@example.com', 'hashed_pwd4');
INSERT INTO users (name, email, password) VALUES ('Eva Brown', 'eva@example.com', 'hashed_pwd5');
INSERT INTO users (name, email, password) VALUES ('Frank Miller', 'frank@example.com', 'hashed_pwd6');
INSERT INTO users (name, email, password) VALUES ('Grace Lee', 'grace@example.com', 'hashed_pwd7');
INSERT INTO users (name, email, password) VALUES ('Henry Martin', 'henry@example.com', 'hashed_pwd8');
INSERT INTO users (name, email, password) VALUES ('Ivy Clark', 'ivy@example.com', 'hashed_pwd9');
INSERT INTO users (name, email, password) VALUES ('Jack White', 'jack@example.com', 'hashed_pwd10');

-- ============================
-- 2. CATEGORIES (for transactions)
-- ============================
INSERT INTO categories (name, description) VALUES ('Food', 'Expenses on food, dining, and groceries.');
INSERT INTO categories (name, description) VALUES ('Utilities', 'Electricity, water, and other utilities.');
INSERT INTO categories (name, description) VALUES ('Entertainment', 'Movies, concerts, and leisure activities.');
INSERT INTO categories (name, description) VALUES ('Travel', 'Trips, fuel, and transportation.');
INSERT INTO categories (name, description) VALUES ('Health', 'Medical expenses and health-related costs.');
INSERT INTO categories (name, description) VALUES ('Education', 'Tuition fees, books, and courses.');
INSERT INTO categories (name, description) VALUES ('Shopping', 'Clothing, electronics, and other retail.');
INSERT INTO categories (name, description) VALUES ('Salary', 'Income from employment.');
INSERT INTO categories (name, description) VALUES ('Investments', 'Income or expenses related to investments.');
INSERT INTO categories (name, description) VALUES ('Miscellaneous', 'Other uncategorized expenses or income.');

-- ============================
-- 3. TAGS (optional for transactions)
-- ============================
INSERT INTO tags (name) VALUES ('urgent');
INSERT INTO tags (name) VALUES ('recurring');
INSERT INTO tags (name) VALUES ('business');
INSERT INTO tags (name) VALUES ('personal');
INSERT INTO tags (name) VALUES ('one-time');
INSERT INTO tags (name) VALUES ('food');
INSERT INTO tags (name) VALUES ('travel');
INSERT INTO tags (name) VALUES ('health');
INSERT INTO tags (name) VALUES ('education');
INSERT INTO tags (name) VALUES ('leisure');

-- ============================
-- 4. BUDGETS (each user gets a monthly and an annual budget)
-- ============================
-- For User 1
INSERT INTO budgets (user_id, period, total_budget) VALUES (1, 'monthly', 1500.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (1, 'annual', 18000.00);
-- For User 2
INSERT INTO budgets (user_id, period, total_budget) VALUES (2, 'monthly', 2000.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (2, 'annual', 24000.00);
-- For User 3
INSERT INTO budgets (user_id, period, total_budget) VALUES (3, 'monthly', 1300.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (3, 'annual', 15600.00);
-- For User 4
INSERT INTO budgets (user_id, period, total_budget) VALUES (4, 'monthly', 1700.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (4, 'annual', 20400.00);
-- For User 5
INSERT INTO budgets (user_id, period, total_budget) VALUES (5, 'monthly', 2200.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (5, 'annual', 26400.00);
-- For User 6
INSERT INTO budgets (user_id, period, total_budget) VALUES (6, 'monthly', 1800.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (6, 'annual', 21600.00);
-- For User 7
INSERT INTO budgets (user_id, period, total_budget) VALUES (7, 'monthly', 1600.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (7, 'annual', 19200.00);
-- For User 8
INSERT INTO budgets (user_id, period, total_budget) VALUES (8, 'monthly', 1900.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (8, 'annual', 22800.00);
-- For User 9
INSERT INTO budgets (user_id, period, total_budget) VALUES (9, 'monthly', 1400.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (9, 'annual', 16800.00);
-- For User 10
INSERT INTO budgets (user_id, period, total_budget) VALUES (10, 'monthly', 2100.00);
INSERT INTO budgets (user_id, period, total_budget) VALUES (10, 'annual', 25200.00);

-- ============================
-- 5. TRANSACTIONS (for each user; using category IDs from 1 to 10)
-- ============================
-- User 1 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (1, 45.50, 'Lunch at cafe', 1, '2025-03-01', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (1, 1200.00, 'Monthly Salary', 8, '2025-03-01', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (1, 75.00, 'Groceries shopping', 1, '2025-03-03', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (1, 50.00, 'Bus pass', 4, '2025-03-05', 'expense');

-- User 2 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (2, 200.00, 'Electricity bill', 2, '2025-03-02', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (2, 2500.00, 'Bonus Payment', 8, '2025-03-10', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (2, 60.00, 'Movie ticket', 3, '2025-03-12', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (2, 100.00, 'Gym membership', 5, '2025-03-15', 'expense');

-- User 3 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (3, 85.00, 'Dinner with friends', 1, '2025-03-04', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (3, 1300.00, 'Freelance Payment', 9, '2025-03-07', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (3, 40.00, 'Bus fare', 4, '2025-03-08', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (3, 95.00, 'Books purchase', 6, '2025-03-11', 'expense');

-- User 4 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (4, 55.00, 'Coffee and snacks', 1, '2025-03-03', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (4, 1800.00, 'Salary Payment', 8, '2025-03-01', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (4, 110.00, 'Concert Ticket', 3, '2025-03-06', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (4, 65.00, 'Taxi ride', 4, '2025-03-09', 'expense');

-- User 5 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (5, 95.00, 'Grocery shopping', 1, '2025-03-02', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (5, 2200.00, 'Salary Payment', 8, '2025-03-01', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (5, 130.00, 'Dinner party', 1, '2025-03-07', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (5, 70.00, 'Internet bill', 2, '2025-03-08', 'expense');

-- User 6 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (6, 50.00, 'Lunch', 1, '2025-03-05', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (6, 1850.00, 'Salary Payment', 8, '2025-03-01', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (6, 40.00, 'Public transport', 4, '2025-03-06', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (6, 60.00, 'Dinner', 1, '2025-03-10', 'expense');

-- User 7 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (7, 75.00, 'Brunch with family', 1, '2025-03-03', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (7, 1600.00, 'Salary Payment', 8, '2025-03-01', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (7, 85.00, 'Museum visit', 3, '2025-03-07', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (7, 45.00, 'Coffee', 1, '2025-03-09', 'expense');

-- User 8 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (8, 65.00, 'Breakfast', 1, '2025-03-02', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (8, 1950.00, 'Salary Payment', 8, '2025-03-01', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (8, 120.00, 'Pharmacy purchase', 5, '2025-03-04', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (8, 55.00, 'Public transport', 4, '2025-03-08', 'expense');

-- User 9 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (9, 35.00, 'Snack', 1, '2025-03-05', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (9, 1450.00, 'Salary Payment', 8, '2025-03-01', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (9, 90.00, 'Cinema', 3, '2025-03-06', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (9, 80.00, 'Electricity bill', 2, '2025-03-10', 'expense');

-- User 10 transactions
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (10, 55.00, 'Snack', 1, '2025-03-04', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (10, 2100.00, 'Salary Payment', 8, '2025-03-01', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (10, 100.00, 'Clothing shopping', 7, '2025-03-09', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (10, 70.00, 'Dinner', 1, '2025-03-11', 'expense');

-- Additional random transactions (for variety; mix of users, amounts, and dates)
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (2, 35.00, 'Snack', 1, '2025-03-13', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (3, 250.00, 'Concert', 3, '2025-03-14', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (4, 500.00, 'Investment Return', 9, '2025-03-15', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (5, 65.00, 'Fuel', 4, '2025-03-16', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (6, 100.00, 'Medical Checkup', 5, '2025-03-17', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (7, 45.00, 'Coffee', 1, '2025-03-18', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (8, 150.00, 'Online Course', 6, '2025-03-19', 'expense');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (9, 300.00, 'Freelance Project', 9, '2025-03-20', 'income');
INSERT INTO transactions (user_id, amount, description, category, date, type) VALUES (10, 80.00, 'Snacks', 1, '2025-03-21', 'expense');

-- ============================
-- 6. TRANSACTION_TAGS (linking transactions with tags)
-- ============================
-- Linking some transactions with one or more tags
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (1, 6);  -- Transaction 1 tagged as 'food'
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (1, 4);  -- Also 'personal'
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (2, 4);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (3, 6);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (4, 7);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (5, 2);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (6, 4);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (7, 5);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (8, 8);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (9, 1);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (10, 9);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (11, 4);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (12, 2);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (13, 3);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (14, 10);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (15, 7);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (16, 4);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (17, 1);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (18, 2);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (19, 3);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (20, 5);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (21, 6);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (22, 7);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (23, 8);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (24, 9);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (25, 10);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (26, 1);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (27, 4);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (28, 2);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (29, 5);
INSERT INTO transaction_tags (transaction_id, tag_id) VALUES (30, 3);

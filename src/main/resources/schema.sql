CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE sales (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customerId INT NOT NULL,
    productName VARCHAR(MAX) NOT NULL,
    saleAmount DECIMAL(10,2),
    saleDate DATE
);


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
CREATE TABLE address (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         streetName VARCHAR(255),
                         cityName VARCHAR(255),
                         stateName VARCHAR(255),
                         zipCode VARCHAR(20),
                         customer_id INT,
                         FOREIGN KEY (customer_id) REFERENCES customer(id) -- Adding foreign key constraint to the customer table
);


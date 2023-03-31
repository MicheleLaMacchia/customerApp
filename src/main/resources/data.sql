CREATE TABLE customers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  fiscal_code VARCHAR(16),
  age INT
);

CREATE TABLE products (
  id INT PRIMARY KEY AUTO_INCREMENT,
  barcode VARCHAR(255),
  product_name VARCHAR(255),
  product_category VARCHAR(255),
  cost DOUBLE
);

CREATE TABLE customer_product (
  id INT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT NOT NULL,
  product_id INT NOT NULL,
  insert_date DATE,
  FOREIGN KEY (customer_id) REFERENCES customers(id),
  FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO customers (first_name, last_name, fiscal_code, age) VALUES 
('Alessandro', 'Rossi', 'RSSALE78D09L219C', 33),
('Giacomo', 'Mancini', 'MNCGCO89M05F874H', 45),
('Valentina', 'Ricci', 'RCCVNT85P54Z293C', 27),
('Federica', 'Rossi', 'GRCFDR76R11K056E', 44),
('Gabriele', 'Gallo', 'GLLGPR86D11F205C', 29),
('Ludovica', 'Giordano', 'GRDLVC90T24L404F', 21),
('Michele', 'Costa', 'CSTMCL91D12G918V', 29),
('Simone', 'Conti', 'CNTSMN83H27F205J', 38),
('Sara', 'Santoro', 'SNRSRA80C70L219O', 41),
('Davide', 'Rizzo', 'RZZDVD77S01L219D', 44),
('Martina', 'Lombardi', 'LMBMRT98P43L219Z', 23),
('Francesca', 'Esposito', 'ESPFRN88M41H501D', 33),
('Marco', 'Marino', 'MRNMRC92R24L219P', 29),
('Chiara', 'De Luca', 'DLCCHR94H54H501A', 27),
('Luca', 'Ferrari', 'FRRLCU82B08H501L', 39),
('Elisa', 'Bianchi', 'BNCESA97R52Z404F', 22),
('Stefano', 'Rossi', 'MRTSTF80P08L219E', 41),
('Alessia', 'Serra', 'SRRSLS97S70L219A', 24),
('Roberto', 'Fabbri', 'FBBRRT84S25G224N', 37),
('Cristina', 'Romano', 'RMNCST93R48L219L', 28);

INSERT INTO products (barcode, product_name, product_category, cost) VALUES 
('00123657', 'Smartphone Samsung Galaxy S21', 'Smartphone', 799.99),
('30188757', 'Notebook Dell XPS 13', 'Computer', 1299.99),
('01036547', 'Smart TV LG OLED C1', 'Televisori', 1999.99),
('07446107', 'Samsung TV Crystal UHD 4K', 'Televisori', 799.99),
('95036887', 'Sony Series 8 TV Crystal UHD', 'Televisori', 1199.99),
('55006541', 'Console Sony PlayStation 5', 'Gaming', 499.99),
('78100233', 'Smartwatch Apple Watch Series 7', 'Smartphone', 399.99);

INSERT INTO customer_product (customer_id, product_id, insert_date) VALUES
(1, 1, '2023-01-02'),
(1, 2, '2023-01-15'),
(2, 5, '2023-01-20'),
(3, 5, '2023-02-05'),
(3, 3, '2023-02-12'),
(4, 4, '2023-02-28'),
(5, 7, '2023-03-03'),
(5, 6, '2023-03-08'),
(6, 2, '2023-03-15'),
(6, 6, '2023-03-25');


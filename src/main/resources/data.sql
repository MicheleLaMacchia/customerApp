CREATE TABLE customers (
  id INT PRIMARY KEY AUTO_INCREMENT,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  fiscal_code VARCHAR(16),
  age INT
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

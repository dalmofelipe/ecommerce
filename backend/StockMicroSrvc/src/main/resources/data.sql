INSERT INTO ecommerce_stock.tb_categories(id, name, category_root_id) 
VALUES
(1, 'ALIMENTOS', NULL),
(2, 'BEBIDAS', NULL),
(3, 'LIMPEZA', NULL),
(4, 'HIGIENE PESSOAL', NULL),
(5, 'PADARIA', NULL),
(6, 'ELETRÔNICOS', NULL);

-- Add subcategorias de ALIMENTOS
INSERT INTO ecommerce_stock.tb_categories(name, category_root_id) 
VALUES
('FRUTAS', 1),
('VERDURAS', 1),
('CARNES', 1),
('LATICÍNIOS', 1);

-- Add subcategorias de BEBIDAS
INSERT INTO ecommerce_stock.tb_categories(name, category_root_id) 
VALUES
('REFRIGERANTES', 2),
('SUCOS', 2),
('CERVEJAS', 2);

-- Add subcategorias de LIMPEZA
INSERT INTO ecommerce_stock.tb_categories(name, category_root_id) 
VALUES
('LIMPEZA DOMÉSTICA', 3),
('PRODUTOS DE LAVANDERIA', 3);

-- Add subcategorias de HIGIENE PESSOAL
INSERT INTO ecommerce_stock.tb_categories(name, category_root_id) 
VALUES
('HIGIENE BUCAL', 4),
('CUIDADOS COM A PELE', 4),
('PRODUTOS DE HIGIENE ÍNTIMA', 4);

-- Add subcategorias de PADARIA
INSERT INTO ecommerce_stock.tb_categories(name, category_root_id) 
VALUES
('PÃES', 5),
('BOLOS', 5);

-- Add subcategorias de ELETRÔNICOS
INSERT INTO ecommerce_stock.tb_categories(name, category_root_id) 
VALUES
('TVS', 6),
('CELULARES', 6),
('COMPUTADORES', 6);


-- PRODUCTS
INSERT INTO ecommerce_stock.tb_products(name, brand, details, sale_price, category_id)
VALUES
('IMAC', 'APPLE', '500GB 8GB RAM 4GHz 4CORE', 6999.99, 23),
('IMAC', 'APPLE', '1TB 16GB RAM 4.5GHz 8CORE', 16999.99, 23),
('IMAC', 'APPLE', '5TB 128GB RAM 6GHz 12CORE', 99999.99, 23);


-- SUPPLIER
INSERT INTO ecommerce_stock.tb_suppliers(id, name) 
VALUES
(1, 'TAIWAN FORNECIMENTOS'),
(2, 'FOOD FORNECIMENTOS'),
(3, 'USA FORNECIMENTOS'),
(4, 'CH FORNECIMENTOS');


-- PRODUCT_SUPPLIER 
INSERT INTO ecommerce_stock.tb_product_supplier(product_id, supplier_id)
VALUES
(1, 1),
(1, 3),
(3, 1),
(3, 2);


-- STOCKS
INSERT INTO ecommerce_stock.tb_stocks(product_id, supplier_id, amount, lot_price, type, registred_at)
VALUES
(1, 1, 100, 199.90, 'ENTRY', '2024-04-01'),
(1, 3, 100, 189.00, 'ENTRY', '2024-04-10'),
(1, 1, 100, 399.99, 'ENTRY', '2024-04-20'),
(1, 1, 100, 200.0, 'OUTPUT', '2024-05-01');
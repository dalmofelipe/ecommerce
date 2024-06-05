INSERT INTO TB_CATEGORIES(id, name, category_root_id) 
VALUES
(1, 'ALIMENTOS', NULL),
(2, 'BEBIDAS', NULL),
(3, 'LIMPEZA', NULL),
(4, 'HIGIENE PESSOAL', NULL),
(5, 'PADARIA', NULL),
(6, 'ELETRÔNICOS', NULL);

-- Add subcategorias de ALIMENTOS
INSERT INTO TB_CATEGORIES(id, name, category_root_id) 
VALUES
(7, 'FRUTAS', 1),
(8, 'VERDURAS', 1),
(9, 'CARNES', 1),
(10, 'LATICÍNIOS', 1);

-- Add subcategorias de BEBIDAS
INSERT INTO TB_CATEGORIES(id, name, category_root_id) 
VALUES
(11, 'REFRIGERANTES', 2),
(12, 'SUCOS', 2),
(13, 'CERVEJAS', 2);

-- Add subcategorias de LIMPEZA
INSERT INTO TB_CATEGORIES(id, name, category_root_id) 
VALUES
(15, 'LIMPEZA DOMÉSTICA', 3),
(16, 'PRODUTOS DE LAVANDERIA', 3);

-- Add subcategorias de HIGIENE PESSOAL
INSERT INTO TB_CATEGORIES(id, name, category_root_id) 
VALUES
(17, 'HIGIENE BUCAL', 4),
(18, 'CUIDADOS COM A PELE', 4),
(19, 'PRODUTOS DE HIGIENE ÍNTIMA', 4);

-- Add subcategorias de PADARIA
INSERT INTO TB_CATEGORIES(id, name, category_root_id) 
VALUES
(20, 'PÃES', 5),
(21, 'BOLOS', 5);

-- Add subcategorias de ELETRÔNICOS
INSERT INTO TB_CATEGORIES(id, name, category_root_id) 
VALUES
(22, 'TVS', 6),
(23, 'CELULARES', 6),
(24, 'COMPUTADORES', 6);

-- PRODUCTS
INSERT INTO TB_PRODUCTS(id, name, brand, details, sale_price, category_id)
VALUES
(1, 'IMAC', 'APPLE', '500GB 8GB RAM 4GHz 4CORE', 6999.99, 24),
(2, 'IMAC', 'APPLE', '1TB 16GB RAM 4.5GHz 8CORE', 16999.99, 24),
(3, 'IMAC', 'APPLE', '5TB 128GB RAM 6GHz 12CORE', 99999.99, 24);

-- SUPPLIER
INSERT INTO TB_SUPPLIERS(id, name) 
VALUES
(1, 'TAIWAN FORNECIMENTOS'),
(2, 'FOOD FORNECIMENTOS'),
(3, 'USA FORNECIMENTOS'),
(4, 'CH FORNECIMENTOS');

-- PRODUCT_SUPPLIER 
INSERT INTO TB_PRODUCT_SUPPLIER(product_id, supplier_id)
VALUES
(1, 1),
(1, 3),
(3, 1),
(3, 2);

-- STOCKS
INSERT INTO TB_STOCKS(product_id, supplier_id, amount, lot_price, type, registred_at)
VALUES
(1, 1, 100, 199.90, 'ENTRY', '2024-04-01'),
(1, 3, 100, 189.00, 'ENTRY', '2024-04-10'),
(1, 1, 100, 399.99, 'ENTRY', '2024-04-20'),
(1, 1, 100, 200.0, 'OUTPUT', '2024-05-01');

--tb products
INSERT into tb_products (product_id, product_name, price)
VALUES
    (1,'Computer',100.00),
    (2,'Smartphone',2000.00),
    (3,'Mouse',179.00)
ON CONFLICT (product_id) DO NOTHING;

--tb_tags
INSERT into tb_tags (tag_id, name)
VALUES
    (1,'Electronics'),
    (2,'Home'),
    (3,'Apple')
ON CONFLICT (tag_id) DO NOTHING;

--tb_products_tags
INSERT into tb_products_tags (product_id, tag_id)
VALUES
    (1,1),
    (2,1),
    (2,3),
    (3,1)
ON CONFLICT (product_id, tag_id) DO NOTHING;
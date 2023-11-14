DROP TABLE IF EXISTS piezas;
DROP TABLE IF EXISTS proveedores; 
DROP TABLE IF EXISTS suministra; 

CREATE TABLE piezas (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre NVARCHAR(100) NOT NULL
);

INSERT INTO piezas (nombre) VALUES ('Tornillo');
INSERT INTO piezas (nombre) VALUES ('Arandela');
INSERT INTO piezas (nombre) VALUES ('Brida');
INSERT INTO piezas (nombre) VALUES ('Tuerca');
INSERT INTO piezas (nombre) VALUES ('Pasador');	

CREATE TABLE proveedores ( 
id CHAR(4) PRIMARY KEY,
nombre VARCHAR(100) NOT NULL
);
                
INSERT INTO proveedores (id, nombre) VALUES ('P1', 'Proveedor 1'), ('P2', 'Proveedor 2'), ('P3', 'Proveedor 3'),('P4', 'Proveedor 4'), ('P5', 'Proveedor 5');


CREATE TABLE suministra (
id INT AUTO_INCREMENT PRIMARY KEY,
id_pieza INT,
id_proveedor CHAR(4),
precio INT,
FOREIGN KEY (id_pieza) REFERENCES piezas (id) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (id_proveedor) REFERENCES proveedores (id) ON UPDATE CASCADE ON DELETE CASCADE
);
INSERT INTO suministra (id_pieza, id_proveedor, precio) VALUES (1, 'P1', 100),
                (2, 'P2', 150),
                (3, 'P3', 200),
                (4, 'P4', 120),
                (5, 'P5', 180);
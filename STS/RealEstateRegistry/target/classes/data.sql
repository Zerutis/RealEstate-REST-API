INSERT INTO OWNER (owner_id, name) VALUES
						  (1,'Rokas'),
						  (2,'Rytis'),
						  (3,'Lukas');
						  
INSERT INTO PROPERTY (property_id, property_type, tax_rate) VALUES
						(1,'Apartment',0.05),
						(2,'House',0.089),
						(3,'Industrial',0.153),
						(4,'Loft',0.124);

INSERT INTO BUILDING (id, city, street, number, size, value, owner_id, property_id) VALUES
							(1, 'Vilnius', 'Taikos', 110, 25, 3000, 1, 1),
							(2, 'Vilnius', 'Taikos', 143, 42, 4700, 1, 1),
							(3, 'Vilnius', 'Taikos', 37, 73, 1500, 2, 2),
							(4, 'Vilnius', 'Vinco', 13, 12, 1350, 2, 2),
							(5, 'Vilnius', 'Vinco', 47, 34, 3580, 2, 2),
							(6, 'Vilnius', 'Vinco', 62, 40, 3880, 1, 2),
							(7, 'Vilnius', 'Taikos', 21, 50, 4000, 1, 1),
							(8, 'Vilnius', 'Taikos', 34, 32, 2500, 2, 2),			
							(9, 'Vilnius', 'Taikos', 69, 150, 12000, 2, 1),			
							(10, 'Vilnius', 'Vinco', 68, 72, 4000, 3, 2),			
							(11, 'Vilnius', 'Vinco', 88, 78, 5000, 2, 3),			
							(12, 'Kaunas', 'Vinco', 96, 125, 8000, 2, 2),			
							(13, 'Vilnius', 'Taikos', 35, 75, 3500, 1, 4),			
							(14, 'Vilnius', 'Taikos', 97, 25, 900, 3, 2),			
							(15, 'Vilnius', 'Vinco', 1, 150, 9000, 1, 1),			
							(16, 'Vilnius', 'Taikos', 92, 27, 1000, 1, 2),			
							(17, 'Vilnius', 'Vinco', 98, 75, 6000, 2, 1),			
							(18, 'Vilnius', 'Taikos', 91, 74, 5400, 1, 1);			
START TRANSACTION;
/*INSERTANDO DATOS A LA TABLA Unidad*/
INSERT INTO bdtr.Unidad (UnidadID, NombreUnidad, UnidadMedida) VALUES (1, 'Bolivianos', 'BOB.-');
INSERT INTO bdtr.Unidad (UnidadID, NombreUnidad, UnidadMedida) VALUES (2, 'Dolares', '$US.-');
INSERT INTO bdtr.Unidad (UnidadID, NombreUnidad, UnidadMedida) VALUES (3, 'Unidades', 'Udds.');
INSERT INTO bdtr.Unidad (UnidadID, NombreUnidad, UnidadMedida) VALUES (4, 'Porcentaje', '%');

/*INSERTANDO DATOS A LA TABLA Impuesto*/
INSERT INTO bdtr.Impuesto (ImpuestoID, IVA, IT) VALUES (1, 0.13, 0.3);

COMMIT;


-- MySQL Workbench Synchronization
-- Generated: 2019-02-16 00:25
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: rudolf

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `bdtr` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `bdtr`.`caja` (
  `CajaID` INT(11) NOT NULL AUTO_INCREMENT,
  `FechaApertura` DATE NOT NULL,
  `HoraApertura` TIME NOT NULL,
  `FechaCierre` DATE NULL DEFAULT NULL,
  `HoraCierre` TIME NULL DEFAULT NULL,
  `CajaInicial` DOUBLE NOT NULL,
  `VentaTotal` DOUBLE NOT NULL,
  `IngresoTotal` DOUBLE NOT NULL,
  `GastoTotal` DOUBLE NOT NULL,
  `CajaTotal` DOUBLE NOT NULL,
  `TiendaID` INT(11) NOT NULL,
  PRIMARY KEY (`CajaID`, `TiendaID`),
  INDEX `fk_Caja_Tienda1_idx` (`TiendaID` ASC),
  CONSTRAINT `fk_Caja_Tienda1`
    FOREIGN KEY (`TiendaID`)
    REFERENCES `bdtr`.`tienda` (`TiendaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`detalle_kardex` (
  `DetalleKardexID` INT(11) NOT NULL AUTO_INCREMENT,
  `FechaKardex` DATE NOT NULL,
  `HoraKardex` TIME NOT NULL,
  `ConceptoKardex` VARCHAR(20) NOT NULL,
  `CantidadEntrada` VARCHAR(10) NULL DEFAULT NULL,
  `CostoUnidadEntrada` VARCHAR(10) NULL DEFAULT NULL,
  `TotalEntradas` VARCHAR(10) NULL DEFAULT NULL,
  `CantidadSalida` VARCHAR(10) NULL DEFAULT NULL,
  `CostoUnitarioSalida` VARCHAR(10) NULL DEFAULT NULL,
  `TotalSalidas` VARCHAR(10) NULL DEFAULT NULL,
  `CantidadExistencia` VARCHAR(10) NOT NULL,
  `CostoPromedioPonderado` VARCHAR(10) NOT NULL,
  `TotalExistencias` VARCHAR(10) NOT NULL,
  `KardexID` INT(11) NOT NULL,
  `PrendaID` INT(11) NOT NULL,
  PRIMARY KEY (`DetalleKardexID`, `KardexID`, `PrendaID`),
  INDEX `fk_Detalle_Kardex_Kardex1_idx` (`KardexID` ASC, `PrendaID` ASC),
  CONSTRAINT `fk_Detalle_Kardex_Kardex1`
    FOREIGN KEY (`KardexID` , `PrendaID`)
    REFERENCES `bdtr`.`kardex` (`KardexID` , `PrendaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`empleado` (
  `EmpleadoID` INT(11) NOT NULL AUTO_INCREMENT,
  `CargoEmpleado` VARCHAR(20) NOT NULL,
  `FechaContratacion` DATE NULL DEFAULT NULL,
  `Estado` VARCHAR(10) NOT NULL,
  `PersonaID` INT(11) NOT NULL,
  PRIMARY KEY (`EmpleadoID`, `PersonaID`),
  INDEX `fk_Empleado_Persona1_idx` (`PersonaID` ASC),
  CONSTRAINT `fk_Empleado_Persona1`
    FOREIGN KEY (`PersonaID`)
    REFERENCES `bdtr`.`persona` (`PersonaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`impuesto` (
  `ImpuestoID` INT(11) NOT NULL,
  `IVA` DOUBLE NOT NULL,
  `IT` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`ImpuestoID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`kardex` (
  `KardexID` INT(11) NOT NULL AUTO_INCREMENT,
  `FechaInicial` DATE NOT NULL,
  `FechaFinal` DATE NOT NULL,
  `CodigoPrenda` VARCHAR(20) NOT NULL,
  `NombrePrenda` VARCHAR(20) NOT NULL,
  `CantInvInicial` INT(11) NOT NULL,
  `CantCompras` INT(11) NOT NULL,
  `CantDevCompras` INT(11) NULL DEFAULT NULL,
  `CantVentas` INT(11) NOT NULL,
  `CantDevVentas` INT(11) NULL DEFAULT NULL,
  `CantStockActual` INT(11) NOT NULL,
  `InventarioInicial` DOUBLE NOT NULL,
  `ComprasNetas` DOUBLE NOT NULL,
  `InventarioFinal` DOUBLE NOT NULL,
  `CostoVentas` DOUBLE NOT NULL,
  `TotalVentas` DOUBLE NOT NULL,
  `PrendaID` INT(11) NOT NULL,
  `TiendaID` INT(11) NOT NULL,
  PRIMARY KEY (`KardexID`, `PrendaID`, `TiendaID`),
  INDEX `fk_Kardex_Prenda1_idx` (`PrendaID` ASC),
  INDEX `fk_Kardex_Tienda1_idx` (`TiendaID` ASC),
  CONSTRAINT `fk_Kardex_Prenda1`
    FOREIGN KEY (`PrendaID`)
    REFERENCES `bdtr`.`prenda` (`PrendaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Kardex_Tienda1`
    FOREIGN KEY (`TiendaID`)
    REFERENCES `bdtr`.`tienda` (`TiendaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`modelo` (
  `ModeloID` INT(11) NOT NULL AUTO_INCREMENT,
  `Categoria` VARCHAR(20) NOT NULL,
  `Marca` VARCHAR(20) NOT NULL,
  `Detalle` VARCHAR(1000) NULL DEFAULT NULL,
  `TipoColor` VARCHAR(20) NOT NULL,
  `Colores` VARCHAR(200) NOT NULL,
  `Tallas` VARCHAR(50) NOT NULL,
  `Tela` VARCHAR(20) NULL DEFAULT NULL,
  `Industria` VARCHAR(20) NULL DEFAULT NULL,
  `Temporada` VARCHAR(20) NULL DEFAULT NULL,
  `CostoUnitario` DOUBLE NOT NULL,
  `CostoUnitarioIva` DOUBLE NULL DEFAULT NULL,
  `MargenUtilidad` DOUBLE NULL DEFAULT NULL,
  `PrecioTope` DOUBLE NULL DEFAULT NULL,
  `PrecioOficial` DOUBLE NOT NULL,
  `ImpuestoID` INT(11) NOT NULL,
  PRIMARY KEY (`ModeloID`, `ImpuestoID`),
  INDEX `fk_Modelo_Impuesto1_idx` (`ImpuestoID` ASC),
  CONSTRAINT `fk_Modelo_Impuesto1`
    FOREIGN KEY (`ImpuestoID`)
    REFERENCES `bdtr`.`impuesto` (`ImpuestoID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`persona` (
  `PersonaID` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombres` VARCHAR(50) NULL DEFAULT NULL,
  `Apellidos` VARCHAR(50) NULL DEFAULT NULL,
  `CarnetIdentidad` VARCHAR(20) NULL DEFAULT NULL,
  `Direccion` VARCHAR(200) NULL DEFAULT NULL,
  `Telefonos` VARCHAR(30) NULL DEFAULT NULL,
  `Email` VARCHAR(30) NULL DEFAULT NULL,
  `UrlFoto` VARCHAR(100) NULL DEFAULT NULL,
  `ImagenFoto` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`PersonaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`prenda` (
  `PrendaID` INT(11) NOT NULL AUTO_INCREMENT,
  `Codigo` VARCHAR(20) NOT NULL,
  `Nombre` VARCHAR(50) NOT NULL,
  `Color` VARCHAR(20) NOT NULL,
  `Talla` VARCHAR(10) NOT NULL,
  `Precio` DOUBLE NOT NULL,
  `CantidadMinima` INT(11) NULL DEFAULT NULL,
  `Ubicacion` VARCHAR(20) NULL DEFAULT NULL,
  `UrlPrenda` VARCHAR(100) NULL DEFAULT NULL,
  `ImagenPrenda` LONGBLOB NULL DEFAULT NULL,
  `ModeloID` INT(11) NOT NULL,
  PRIMARY KEY (`PrendaID`, `ModeloID`),
  UNIQUE INDEX `Codigo_UNIQUE` (`Codigo` ASC),
  INDEX `fk_Prenda_Modelo1_idx` (`ModeloID` ASC),
  CONSTRAINT `fk_Prenda_Modelo1`
    FOREIGN KEY (`ModeloID`)
    REFERENCES `bdtr`.`modelo` (`ModeloID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`registro` (
  `RegistroID` INT(11) NOT NULL AUTO_INCREMENT,
  `Tipo` VARCHAR(30) NOT NULL,
  `Estado` VARCHAR(10) NOT NULL,
  `HoraEntrada` TIME NOT NULL,
  `HoraSalida` TIME NULL DEFAULT NULL,
  `TotalDineroIntangible` DOUBLE NOT NULL,
  `TotalDineroTangible` DOUBLE NOT NULL,
  `EstadoDinero` VARCHAR(30) NOT NULL,
  `Observacion` VARCHAR(20) NULL DEFAULT NULL,
  `EmpleadoEntranteID` INT(11) NULL DEFAULT NULL,
  `EmpleadoID` INT(11) NOT NULL,
  `CajaID` INT(11) NOT NULL,
  PRIMARY KEY (`RegistroID`, `EmpleadoID`, `CajaID`),
  INDEX `fk_Registro_Empleado1_idx` (`EmpleadoID` ASC),
  INDEX `fk_Registro_Caja1_idx` (`CajaID` ASC),
  CONSTRAINT `fk_Registro_Caja1`
    FOREIGN KEY (`CajaID`)
    REFERENCES `bdtr`.`caja` (`CajaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Registro_Empleado1`
    FOREIGN KEY (`EmpleadoID`)
    REFERENCES `bdtr`.`empleado` (`EmpleadoID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`tienda` (
  `TiendaID` INT(11) NOT NULL AUTO_INCREMENT,
  `NombreTienda` VARCHAR(20) NOT NULL,
  `DescripcionTienda` VARCHAR(200) NULL DEFAULT NULL,
  `DireccionTienda` VARCHAR(200) NULL DEFAULT NULL,
  `TelefonosTienda` VARCHAR(30) NULL DEFAULT NULL,
  `CiudadTienda` VARCHAR(20) NULL DEFAULT NULL,
  `PaisTienda` VARCHAR(20) NULL DEFAULT NULL,
  `CambioDolar` DOUBLE NOT NULL,
  `EstadoTienda` VARCHAR(10) NOT NULL,
  `UrlLogo` VARCHAR(100) NULL DEFAULT NULL,
  `LogoTienda` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`TiendaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`unidad` (
  `UnidadID` INT(11) NOT NULL AUTO_INCREMENT,
  `NombreUnidad` VARCHAR(20) NOT NULL,
  `UnidadMedida` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`UnidadID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`unidad_modelo` (
  `ModeloID` INT(11) NOT NULL,
  `UnidadID` INT(11) NOT NULL,
  PRIMARY KEY (`ModeloID`, `UnidadID`),
  INDEX `fk_Unidad_Modelo_Unidad1_idx` (`UnidadID` ASC),
  CONSTRAINT `fk_Unidad_Modelo_Modelo`
    FOREIGN KEY (`ModeloID`)
    REFERENCES `bdtr`.`modelo` (`ModeloID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Unidad_Modelo_Unidad1`
    FOREIGN KEY (`UnidadID`)
    REFERENCES `bdtr`.`unidad` (`UnidadID`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`unidad_tienda` (
  `UnidadID` INT(11) NOT NULL,
  `TiendaID` INT(11) NOT NULL,
  PRIMARY KEY (`UnidadID`, `TiendaID`),
  INDEX `fk_Unidad_has_Tienda_Tienda1_idx` (`TiendaID` ASC),
  INDEX `fk_Unidad_has_Tienda_Unidad1_idx` (`UnidadID` ASC),
  CONSTRAINT `fk_Unidad_has_Tienda_Tienda1`
    FOREIGN KEY (`TiendaID`)
    REFERENCES `bdtr`.`tienda` (`TiendaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Unidad_has_Tienda_Unidad1`
    FOREIGN KEY (`UnidadID`)
    REFERENCES `bdtr`.`unidad` (`UnidadID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `bdtr`.`usuario` (
  `UsuarioID` INT(11) NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(20) NOT NULL,
  `Password` VARCHAR(50) NOT NULL,
  `EmpleadoID` INT(11) NOT NULL,
  `PersonaID` INT(11) NOT NULL,
  PRIMARY KEY (`UsuarioID`, `EmpleadoID`, `PersonaID`),
  UNIQUE INDEX `Password_UNIQUE` (`Password` ASC),
  INDEX `fk_Usuario_Empleado1_idx` (`EmpleadoID` ASC, `PersonaID` ASC),
  CONSTRAINT `fk_Usuario_Empleado1`
    FOREIGN KEY (`EmpleadoID` , `PersonaID`)
    REFERENCES `bdtr`.`empleado` (`EmpleadoID` , `PersonaID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-03-2026 a las 19:08:32
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `colegio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `alu_codigo` int(11) NOT NULL,
  `alu_nombre` varchar(100) NOT NULL,
  `alu_direccion` varchar(150) DEFAULT NULL,
  `alu_estatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion`
--

CREATE TABLE `asignacion` (
  `asig_codigo` int(11) NOT NULL,
  `car_codigo` int(11) NOT NULL,
  `cur_codigo` int(11) NOT NULL,
  `mae_codigo` int(11) NOT NULL,
  `alu_codigo` int(11) NOT NULL,
  `asig_nota` decimal(5,2) DEFAULT NULL,
  `jorCodigo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `car_codigo` int(11) NOT NULL,
  `car_nombre` varchar(100) NOT NULL,
  `car_estatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`car_codigo`, `car_nombre`, `car_estatus`) VALUES
(2, 'Ingenieria Industrial', 'Activo'),
(3, 'Administracion', 'Activo'),
(4, 'Derecho', 'Inactiva'),
(5, 'Ingenieria Civil', 'Activo'),
(6, 'Ingenieria Aereoespacial', 'Activo'),
(7, 'Ciencias y letras', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `cur_codigo` int(11) NOT NULL,
  `cur_nombre` varchar(100) NOT NULL,
  `cur_estatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jornadas`
--

CREATE TABLE `jornadas` (
  `JorCodigo` int(11) NOT NULL,
  `JorNombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `jornadas`
--

INSERT INTO `jornadas` (`JorCodigo`, `JorNombre`) VALUES
(1, 'Matutina'),
(2, 'Plan fin de semana');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `maestros`
--

CREATE TABLE `maestros` (
  `mae_codigo` int(11) NOT NULL,
  `mae_nombre` varchar(100) NOT NULL,
  `mae_direccion` varchar(150) DEFAULT NULL,
  `mae_estatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`alu_codigo`);

--
-- Indices de la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD PRIMARY KEY (`asig_codigo`),
  ADD KEY `car_codigo` (`car_codigo`),
  ADD KEY `cur_codigo` (`cur_codigo`),
  ADD KEY `mae_codigo` (`mae_codigo`),
  ADD KEY `alu_codigo` (`alu_codigo`),
  ADD KEY `fk_jornada` (`jorCodigo`);

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`car_codigo`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`cur_codigo`);

--
-- Indices de la tabla `jornadas`
--
ALTER TABLE `jornadas`
  ADD PRIMARY KEY (`JorCodigo`);

--
-- Indices de la tabla `maestros`
--
ALTER TABLE `maestros`
  ADD PRIMARY KEY (`mae_codigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asignacion`
--
ALTER TABLE `asignacion`
  ADD CONSTRAINT `asignacion_ibfk_1` FOREIGN KEY (`car_codigo`) REFERENCES `carreras` (`car_codigo`),
  ADD CONSTRAINT `asignacion_ibfk_2` FOREIGN KEY (`cur_codigo`) REFERENCES `cursos` (`cur_codigo`),
  ADD CONSTRAINT `asignacion_ibfk_3` FOREIGN KEY (`mae_codigo`) REFERENCES `maestros` (`mae_codigo`),
  ADD CONSTRAINT `asignacion_ibfk_4` FOREIGN KEY (`alu_codigo`) REFERENCES `alumnos` (`alu_codigo`),
  ADD CONSTRAINT `fk_jornada` FOREIGN KEY (`jorCodigo`) REFERENCES `jornadas` (`JorCodigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

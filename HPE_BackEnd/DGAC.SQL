-- MySQL dump 10.13  Distrib 5.5.24, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: hashmodel
-- ------------------------------------------------------
-- Server version	5.5.24-0ubuntu0.12.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `abstractcomponentfunctor`
--

DROP TABLE IF EXISTS `abstractcomponentfunctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abstractcomponentfunctor` (
  `id_functor_app_supertype` int(11) DEFAULT NULL,
  `library_path` varchar(150) DEFAULT NULL,
  `id_abstract` int(11) NOT NULL,
  `hash_component_UID` varchar(320) DEFAULT NULL,
  `kind` varchar(45) NOT NULL,
  PRIMARY KEY (`id_abstract`),
  UNIQUE KEY `UID` (`hash_component_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `abstractcomponentfunctorapplication`
--

DROP TABLE IF EXISTS `abstractcomponentfunctorapplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abstractcomponentfunctorapplication` (
  `id_functor_app` int(11) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  `id_functor_app_next` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`id_functor_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `abstractcomponentfunctorparameter`
--

DROP TABLE IF EXISTS `abstractcomponentfunctorparameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `abstractcomponentfunctorparameter` (
  `id_parameter` varchar(30) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  `bounds_of` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_parameter`,`id_abstract`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `component`
--

DROP TABLE IF EXISTS `component`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `component` (
  `library_path` varchar(150) NOT NULL DEFAULT '' COMMENT 'the package where the component is placed.',
  `id_concrete` int(11) NOT NULL,
  `id_concrete_supertype` int(11) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `hash_component_UID` varchar(320) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_concrete`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `innercomponent`
--

DROP TABLE IF EXISTS `innercomponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `innercomponent` (
  `id_abstract_owner` int(11) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_inner` varchar(40) NOT NULL,
  `id_abstract_inner` int(11) NOT NULL,
  `parameter_top` varchar(45) DEFAULT NULL,
  `transitive` int(11) DEFAULT '0',
  `public` int(11) DEFAULT '0',
  PRIMARY KEY (`id_abstract_owner`,`id_inner`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `innercomponentexposed`
--

DROP TABLE IF EXISTS `innercomponentexposed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `innercomponentexposed` (
  `id_abstract` int(11) NOT NULL AUTO_INCREMENT,
  `id_inner_rename` varchar(40) NOT NULL DEFAULT '"',
  `id_inner_owner` varchar(40) NOT NULL DEFAULT '"',
  `id_inner` varchar(40) DEFAULT '"',
  PRIMARY KEY (`id_abstract`,`id_inner_rename`,`id_inner_owner`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `interface`
--

DROP TABLE IF EXISTS `interface`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interface` (
  `id_abstract` int(11) NOT NULL,
  `id_interface` varchar(40) NOT NULL,
  `partition_index` int(11) NOT NULL DEFAULT '0',
  `id_interface_super` varchar(40) DEFAULT NULL,
  `partition_index_super` int(11) DEFAULT '0',
  `assembly_string` varchar(511) DEFAULT NULL COMMENT 'The assembly where the class that implements the interface is placed on.',
  `class_name` varchar(127) NOT NULL COMMENT 'The class that implements the interface.',
  `uri_source` varchar(255) NOT NULL DEFAULT '' COMMENT 'where the source code is',
  `class_nargs` int(11) NOT NULL DEFAULT '0',
  `id_interface_super_top` varchar(40) DEFAULT NULL,
  `partition_index_super_top` int(11) DEFAULT '0',
  `order` int(11) NOT NULL,
  `actions` text COMMENT '"action_1; action_2; ... action_n". Nomes de ações separados por ponto-e-vírgula para evitar outra tabela.',
  `conditions` text COMMENT '"condition_1; condition_2; ... condition_n". Nomes de condições separados por ponto-e-vírgula para evitar outra tabela.',
  `protocol` text COMMENT 'string xml',
  PRIMARY KEY (`id_abstract`,`id_interface`,`partition_index`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `interfaceaction`
--

DROP TABLE IF EXISTS `interfaceaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interfaceaction` (
  `id_abstract` int(11) NOT NULL,
  `id_interface` varchar(45) NOT NULL,
  `partition_index` int(11) NOT NULL,
  `id_action` varchar(45) NOT NULL DEFAULT 'main',
  `protocol` text,
  `is_condition` int(11) DEFAULT '0',
  PRIMARY KEY (`id_abstract`,`id_interface`,`partition_index`,`id_action`),
  KEY `id_abstract` (`id_abstract`),
  CONSTRAINT `id_abstract` FOREIGN KEY (`id_abstract`) REFERENCES `abstractcomponentfunctor` (`id_abstract`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `interfaceparameters`
--

DROP TABLE IF EXISTS `interfaceparameters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interfaceparameters` (
  `id_interface` varchar(40) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  `parid` varchar(40) NOT NULL,
  `varid` varchar(40) NOT NULL,
  `id_interface_parameter` varchar(40) NOT NULL,
  `id_unit_parameter` varchar(40) NOT NULL,
  `par_order` int(11) NOT NULL,
  PRIMARY KEY (`id_abstract`,`id_interface`,`parid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `slice`
--

DROP TABLE IF EXISTS `slice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `slice` (
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_inner` varchar(40) NOT NULL DEFAULT '"',
  `id_interface_slice` varchar(40) NOT NULL,
  `partition_index` int(11) NOT NULL DEFAULT '0',
  `id_interface` varchar(40) NOT NULL,
  `property_name` varchar(40) NOT NULL,
  `transitive` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_abstract`,`id_inner`,`id_interface_slice`,`partition_index`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sliceexposed`
--

DROP TABLE IF EXISTS `sliceexposed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sliceexposed` (
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_inner` varchar(40) NOT NULL DEFAULT '"',
  `id_interface_slice` varchar(40) NOT NULL,
  `partition_index` int(11) NOT NULL DEFAULT '-1',
  `id_inner_owner` varchar(40) NOT NULL COMMENT '* id_abstract + id_inner + id_interface_slice + partition_index point to a transitive inner component.\n* Since many transitive inner components may be fused, it is necessary to include id_inner_owner in the primary key to ensure its uniqueness.',
  `id_interface_slice_owner` varchar(40) NOT NULL,
  `partition_index_owner` int(11) NOT NULL,
  `id_inner_original` varchar(40) NOT NULL,
  `id_interface_slice_original` varchar(40) NOT NULL,
  PRIMARY KEY (`id_inner_original`,`id_interface_slice_original`,`id_abstract`,`id_interface_slice_owner`,`id_inner_owner`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='* id_abstract + id_inner + id_interface_slice + partition_in';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sourcecode`
--

DROP TABLE IF EXISTS `sourcecode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sourcecode` (
  `type_owner` char(1) NOT NULL COMMENT '"u" (unit) or "i" (interface)',
  `id_owner` varchar(40) NOT NULL DEFAULT '',
  `contents` text NOT NULL,
  `file_type` varchar(3) NOT NULL COMMENT '"dll" or "exe"',
  `file_name` varchar(45) NOT NULL,
  `id_owner_container` int(11) NOT NULL,
  `file_order` int(11) NOT NULL,
  PRIMARY KEY (`type_owner`,`id_owner_container`,`id_owner`,`file_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sourcecode_references`
--

DROP TABLE IF EXISTS `sourcecode_references`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sourcecode_references` (
  `type_owner` char(1) NOT NULL,
  `id_owner_container` int(11) NOT NULL,
  `id_owner` varchar(40) NOT NULL DEFAULT '"',
  `file_name` varchar(45) NOT NULL,
  `reference` varchar(45) NOT NULL,
  PRIMARY KEY (`type_owner`,`id_owner_container`,`id_owner`,`file_name`,`reference`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `supplyparameter`
--

DROP TABLE IF EXISTS `supplyparameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplyparameter` (
  `id_parameter` varchar(30) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  PRIMARY KEY (`id_parameter`,`id_functor_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `supplyparametercomponent`
--

DROP TABLE IF EXISTS `supplyparametercomponent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplyparametercomponent` (
  `id_parameter` varchar(30) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_functor_app_actual` int(11) NOT NULL,
  PRIMARY KEY (`id_parameter`,`id_functor_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `supplyparameterparameter`
--

DROP TABLE IF EXISTS `supplyparameterparameter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplyparameterparameter` (
  `id_parameter` varchar(30) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_parameter_actual` varchar(30) NOT NULL,
  `freeVariable` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_parameter`,`id_functor_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unit` (
  `id_concrete` int(11) NOT NULL,
  `id_unit` varchar(40) NOT NULL DEFAULT '"',
  `id_interface` varchar(40) NOT NULL,
  `partition_index` int(11) NOT NULL DEFAULT '0',
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_unit_super` varchar(40) DEFAULT '"',
  `assembly_string` varchar(511) DEFAULT NULL COMMENT 'The name of the assembly where the unit class is contained.',
  `class_name` varchar(127) NOT NULL COMMENT 'The name of the class that implements the unit.',
  `uri_source` varchar(255) NOT NULL DEFAULT '' COMMENT 'where the source code is',
  `class_nargs` int(11) NOT NULL DEFAULT '0',
  `order` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_concrete`,`id_unit`,`partition_index`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-11  0:19:06

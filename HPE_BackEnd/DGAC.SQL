DROP TABLE IF EXISTS `hashmodel`.`abstractcomponentfunctor`;
CREATE TABLE  `hashmodel`.`abstractcomponentfunctor` (
  `id_functor_app_supertype` int(11) DEFAULT NULL,
  `library_path` varchar(150) DEFAULT NULL,
  `id_abstract` int(11) NOT NULL,
  `hash_component_UID` varchar(320) DEFAULT NULL,
  `kind` varchar(45) NOT NULL,
  PRIMARY KEY (`id_abstract`),
  UNIQUE KEY `UID` (`hash_component_UID`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`abstractcomponentfunctorapplication`;
CREATE TABLE  `hashmodel`.`abstractcomponentfunctorapplication` (
  `id_functor_app` int(11) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  PRIMARY KEY (`id_functor_app`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`abstractcomponentfunctorparameter`;
CREATE TABLE  `hashmodel`.`abstractcomponentfunctorparameter` (
  `id_parameter` varchar(30) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  `bounds_of` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_parameter`,`id_abstract`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`component`;
CREATE TABLE  `hashmodel`.`component` (
  `library_path` varchar(150) NOT NULL DEFAULT '' COMMENT 'the package where the component is placed.',
  `id_concrete` int(11) NOT NULL,
  `id_concrete_supertype` int(11) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `hash_component_UID` varchar(320) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_concrete`),
  UNIQUE KEY `UID` (`hash_component_UID`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumeration_inner`;
CREATE TABLE  `hashmodel`.`enumeration_inner` (
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_enumerator` varchar(255) NOT NULL,
  `id_inner` varchar(40) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_abstract`,`id_enumerator`,`id_inner`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumeration_interface`;
CREATE TABLE  `hashmodel`.`enumeration_interface` (
  `id_abstract` int(11) NOT NULL AUTO_INCREMENT,
  `id_enumerator` varchar(255) NOT NULL,
  `id_interface` varchar(40) NOT NULL DEFAULT '"',
  PRIMARY KEY (`id_abstract`,`id_enumerator`,`id_interface`)
) ENGINE=NDBCLUSTER AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumeration_item_concrete_inner`;
CREATE TABLE  `hashmodel`.`enumeration_item_concrete_inner` (
  `id_concrete` int(11) NOT NULL AUTO_INCREMENT,
  `id_inner` varchar(20) NOT NULL,
  `id_enumerator` varchar(255) NOT NULL DEFAULT '',
  `value` int(11) NOT NULL DEFAULT '0',
  `id_index` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`id_concrete`,`id_inner`,`id_index`,`id_enumerator`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumeration_item_unit`;
CREATE TABLE  `hashmodel`.`enumeration_item_unit` (
  `id_concrete` int(11) NOT NULL AUTO_INCREMENT,
  `id_unit` varchar(40) NOT NULL DEFAULT '',
  `id_enumerator` varchar(255) NOT NULL DEFAULT '',
  `value` int(11) NOT NULL DEFAULT '0',
  `id_index` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`id_concrete`,`id_unit`,`id_index`,`id_enumerator`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumeration_item_unit_slice`;
CREATE TABLE  `hashmodel`.`enumeration_item_unit_slice` (
  `id_concrete` int(11) NOT NULL AUTO_INCREMENT,
  `id_inner` varchar(40) NOT NULL DEFAULT '',
  `id_index_inner` int(11) NOT NULL DEFAULT '0',
  `id_interface_slice` varchar(40) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `id_enumerator` varchar(255) NOT NULL DEFAULT '',
  `value` int(11) NOT NULL DEFAULT '0',
  `id_index` int(11) NOT NULL DEFAULT '-1',
  `split_replica` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_concrete`,`id_inner`,`id_index_inner`,`id_interface_slice`,`split_replica`,`id_index`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumeration_slice`;
CREATE TABLE  `hashmodel`.`enumeration_slice` (
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_enumerator` varchar(255) NOT NULL,
  `id_interface_slice` varchar(40) NOT NULL DEFAULT '"',
  `id_inner` varchar(40) NOT NULL DEFAULT '"',
  `id_split_replica` int(11) NOT NULL,
  PRIMARY KEY (`id_abstract`,`id_inner`,`id_interface_slice`,`id_split_replica`,`id_enumerator`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumerator`;
CREATE TABLE  `hashmodel`.`enumerator` (
  `id_abstract` int(11) NOT NULL,
  `id_enumerator` varchar(255) NOT NULL DEFAULT '',
  `split_from` int(11) NOT NULL DEFAULT '0',
  `variable` varchar(10) NOT NULL,
  `valuation` int(11) NOT NULL,
  PRIMARY KEY (`id_abstract`,`id_enumerator`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumerator_mapping`;
CREATE TABLE  `hashmodel`.`enumerator_mapping` (
  `id_abstract` int(10) NOT NULL AUTO_INCREMENT,
  `id_inner` varchar(40) NOT NULL,
  `id_enumerator_inner` varchar(255) NOT NULL DEFAULT '',
  `id_enumerator_container` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_abstract`,`id_inner`,`id_enumerator_inner`)
) ENGINE=NDBCLUSTER AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumerator_valuation`;
CREATE TABLE  `hashmodel`.`enumerator_valuation` (
  `id_concrete` int(11) NOT NULL AUTO_INCREMENT,
  `id_enumerator` varchar(255) NOT NULL,
  `range_inf` int(11) NOT NULL,
  `range_sup` int(11) NOT NULL,
  PRIMARY KEY (`id_concrete`,`id_enumerator`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`enumeratorsplit`;
CREATE TABLE  `hashmodel`.`enumeratorsplit` (
  `id_enumerator` varchar(255) NOT NULL DEFAULT '',
  `id_enumerator_split` varchar(255) NOT NULL DEFAULT '',
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_split` int(11) NOT NULL DEFAULT '0',
  `id_total_split` int(11) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id_abstract`,`id_enumerator`,`id_enumerator_split`,`id_split`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`innercomponent`;
CREATE TABLE  `hashmodel`.`innercomponent` (
  `id_abstract_owner` int(11) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_inner` varchar(40) NOT NULL,
  `id_abstract_inner` int(11) NOT NULL,
  `parameter_top` varchar(45) DEFAULT NULL,
  `transitive` int(11) DEFAULT '0',
  `public` int(11) DEFAULT '0',
  PRIMARY KEY (`id_abstract_owner`,`id_inner`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`innercomponentexposed`;
CREATE TABLE  `hashmodel`.`innercomponentexposed` (
  `id_abstract` int(11) NOT NULL AUTO_INCREMENT,
  `id_inner_rename` varchar(40) NOT NULL DEFAULT '"',
  `id_inner_owner` varchar(40) NOT NULL DEFAULT '"',
  `id_inner` varchar(40) DEFAULT '"',
  PRIMARY KEY (`id_abstract`,`id_inner_rename`,`id_inner_owner`)
) ENGINE=NDBCLUSTER AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`innerconcrete`;
CREATE TABLE  `hashmodel`.`innerconcrete` (
  `id_concrete` int(11) NOT NULL AUTO_INCREMENT,
  `id_inner` varchar(40) NOT NULL DEFAULT '"',
  `id_index` int(11) NOT NULL DEFAULT '-1',
  `id_concrete_actual` int(11) NOT NULL,
  PRIMARY KEY (`id_concrete`,`id_inner`,`id_index`)
) ENGINE=NDBCLUSTER AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`interface`;
CREATE TABLE  `hashmodel`.`interface` (
  `id_interface` varchar(40) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  `id_interface_super` varchar(40) DEFAULT NULL,
  `assembly_string` varchar(511) DEFAULT NULL COMMENT 'The assembly where the class that implements the interface is placed on.',
  `class_name` varchar(127) NOT NULL COMMENT 'The class that implements the interface.',
  `uri_source` varchar(255) NOT NULL DEFAULT '' COMMENT 'where the source code is',
  `class_nargs` int(11) NOT NULL DEFAULT '0',
  `id_interface_super_top` varchar(40) DEFAULT NULL,
  `order` int(11) NOT NULL,
  PRIMARY KEY (`id_abstract`,`id_interface`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`interfaceparameters`;
CREATE TABLE  `hashmodel`.`interfaceparameters` (
  `id_interface` varchar(40) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  `parid` varchar(40) NOT NULL,
  `varid` varchar(40) NOT NULL,
  `id_interface_parameter` varchar(40) NOT NULL,
  `id_unit_parameter` varchar(40) NOT NULL,
  `par_order` int(11) NOT NULL,
  PRIMARY KEY (`id_abstract`,`id_interface`,`parid`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`sessions`;
CREATE TABLE  `hashmodel`.`sessions` (
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_concrete` int(11) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`slice`;
CREATE TABLE  `hashmodel`.`slice` (
  `id_interface` varchar(40) NOT NULL,
  `id_inner` varchar(40) NOT NULL DEFAULT '"',
  `id_interface_slice` varchar(40) NOT NULL,
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_split_replica` int(11) NOT NULL DEFAULT '-1',
  `transitive` int(11) NOT NULL DEFAULT '0',
  `property_name` varchar(40) NOT NULL,
  PRIMARY KEY (`id_inner`,`id_interface_slice`,`id_abstract`,`id_split_replica`,`id_interface`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`sliceexposed`;
CREATE TABLE  `hashmodel`.`sliceexposed` (
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_inner_owner` varchar(40) NOT NULL,
  `id_interface_slice` varchar(40) NOT NULL,
  `id_interface_slice_owner` varchar(40) NOT NULL,
  `id_split_replica` int(11) NOT NULL DEFAULT '-1',
  `id_inner` varchar(40) NOT NULL DEFAULT '"',
  `id_split_replica_owner` int(11) NOT NULL,
  `id_inner_original` varchar(40) NOT NULL DEFAULT '"',
  `id_interface_slice_original` varchar(40) NOT NULL DEFAULT '"',
  PRIMARY KEY (`id_abstract`,`id_inner`,`id_inner_owner`,`id_interface_slice`,`id_interface_slice_owner`,`id_split_replica`,`id_split_replica_owner`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`sourcecode`;
CREATE TABLE  `hashmodel`.`sourcecode` (
  `type_owner` char(1) NOT NULL COMMENT '"u" (unit) or "i" (interface)',
  `id_owner` varchar(40) NOT NULL DEFAULT '',
  `contents` text NOT NULL,
  `file_type` varchar(3) NOT NULL COMMENT '"dll" or "exe"',
  `file_name` varchar(45) NOT NULL,
  `id_owner_container` int(11) NOT NULL,
  `file_order` int(11) NOT NULL,
  PRIMARY KEY (`type_owner`,`id_owner_container`,`id_owner`,`file_name`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`sourcecode_references`;
CREATE TABLE  `hashmodel`.`sourcecode_references` (
  `type_owner` char(1) NOT NULL,
  `id_owner_container` int(11) NOT NULL,
  `id_owner` varchar(40) NOT NULL DEFAULT '"',
  `file_name` varchar(45) NOT NULL,
  `reference` varchar(45) NOT NULL,
  PRIMARY KEY (`type_owner`,`id_owner_container`,`id_owner`,`file_name`,`reference`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`supplyparameter`;
CREATE TABLE  `hashmodel`.`supplyparameter` (
  `id_parameter` varchar(30) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  PRIMARY KEY (`id_parameter`,`id_functor_app`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`supplyparametercomponent`;
CREATE TABLE  `hashmodel`.`supplyparametercomponent` (
  `id_parameter` varchar(30) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_functor_app_actual` int(11) NOT NULL,
  PRIMARY KEY (`id_parameter`,`id_functor_app`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`supplyparameterparameter`;
CREATE TABLE  `hashmodel`.`supplyparameterparameter` (
  `id_parameter` varchar(30) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_parameter_actual` varchar(30) NOT NULL,
  `freeVariable` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_parameter`,`id_functor_app`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`unit`;
CREATE TABLE  `hashmodel`.`unit` (
  `id_concrete` int(11) NOT NULL,
  `id_unit` varchar(40) NOT NULL DEFAULT '"',
  `id_interface` varchar(40) NOT NULL,
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_unit_super` varchar(40) DEFAULT '"',
  `id_index` int(11) NOT NULL DEFAULT '-1',
  `assembly_string` varchar(511) DEFAULT NULL COMMENT 'The name of the assembly where the unit class is contained.',
  `class_name` varchar(127) NOT NULL COMMENT 'The name of the class that implements the unit.',
  `uri_source` varchar(255) NOT NULL DEFAULT '' COMMENT 'where the source code is',
  `class_nargs` int(11) NOT NULL DEFAULT '0',
  `order` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_concrete`,`id_unit`,`id_index`)
) ENGINE=NDBCLUSTER DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `hashmodel`.`unitslice`;
CREATE TABLE  `hashmodel`.`unitslice` (
  `id_concrete` int(11) NOT NULL AUTO_INCREMENT,
  `id_unit` varchar(40) NOT NULL DEFAULT '"',
  `id_index_unit` int(11) NOT NULL DEFAULT '0',
  `id_inner` varchar(40) NOT NULL DEFAULT '"',
  `id_index_inner` int(11) NOT NULL DEFAULT '0',
  `id_interface_slice` varchar(40) NOT NULL COMMENT 'id_unit_slice !!!',
  `id_index` int(11) NOT NULL DEFAULT '-1',
  `split_replica` int(11) NOT NULL,
  PRIMARY KEY (`id_concrete`,`id_inner`,`id_index_inner`,`id_interface_slice`,`split_replica`,`id_index`,`id_unit`)
) ENGINE=NDBCLUSTER AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
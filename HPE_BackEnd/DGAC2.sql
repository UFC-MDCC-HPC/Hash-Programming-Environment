drop table `hashmodel`.`abstractcomponentfunctor`;
drop table `hashmodel`.`abstractcomponentfunctorapplication`;
drop table `hashmodel`.`abstractcomponentfunctorparameter`;
drop table `hashmodel`.`component`;
drop table `hashmodel`.`innercomponent`;
drop table `hashmodel`.`innercomponentexposed`;
drop table `hashmodel`.`interface`;
drop table `hashmodel`.`interfaceaction`;
drop table `hashmodel`.`interfaceparameters`;
drop table `hashmodel`.`sessions`;
drop table `hashmodel`.`slice`;
drop table `hashmodel`.`sliceexposed`;
drop table `hashmodel`.`sourcecode`;
drop table `hashmodel`.`sourcecode_references`;
drop table `hashmodel`.`supplyparameter`;
drop table `hashmodel`.`supplyparametercomponent`;
drop table `hashmodel`.`supplyparameterparameter`;
drop table `hashmodel`.`unit`;

delimiter $$

CREATE TABLE `abstractcomponentfunctor` (
  `id_functor_app_supertype` int(11) DEFAULT NULL,
  `library_path` varchar(150) DEFAULT NULL,
  `id_abstract` int(11) NOT NULL,
  `hash_component_UID` varchar(320) DEFAULT NULL,
  `kind` varchar(45) NOT NULL,
  PRIMARY KEY (`id_abstract`),
  UNIQUE KEY `UID` (`hash_component_UID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `abstractcomponentfunctorapplication` (
  `id_functor_app` int(11) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  `id_functor_app_next` int(11) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`id_functor_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `abstractcomponentfunctorparameter` (
  `id_parameter` varchar(30) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  `bounds_of` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_parameter`,`id_abstract`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `component` (
  `library_path` varchar(150) NOT NULL DEFAULT '' COMMENT 'the package where the component is placed.',
  `id_concrete` int(11) NOT NULL,
  `id_concrete_supertype` int(11) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `hash_component_UID` varchar(320) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_concrete`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `innercomponent` (
  `id_abstract_owner` int(11) NOT NULL,
  `id_inner` varchar(40) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_abstract_inner` int(11) NOT NULL,
  `parameter_top` varchar(45) DEFAULT NULL,
  `transitive` int(11) DEFAULT '0',
  `public` int(11) DEFAULT '0',
  PRIMARY KEY (`id_abstract_owner`,`id_inner`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `innercomponentexposed` (
  `id_abstract` int(11) NOT NULL AUTO_INCREMENT,
  `id_inner_rename` varchar(40) NOT NULL DEFAULT '"',
  `id_inner_owner` varchar(40) NOT NULL DEFAULT '"',
  `id_inner` varchar(40) DEFAULT '"',
  PRIMARY KEY (`id_abstract`,`id_inner_rename`,`id_inner_owner`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `interface` (
  `id_abstract` int(11) NOT NULL,
  `id_interface` varchar(40) NOT NULL,
  `unit_replica` int(11) NOT NULL DEFAULT '0',
  `id_interface_super` varchar(40) DEFAULT NULL,
  `unit_replica_super` int(11) DEFAULT '0',
  `assembly_string` varchar(511) DEFAULT NULL COMMENT 'The assembly where the class that implements the interface is placed on.',
  `class_name` varchar(127) NOT NULL COMMENT 'The class that implements the interface.',
  `uri_source` varchar(255) NOT NULL DEFAULT '' COMMENT 'where the source code is',
  `class_nargs` int(11) NOT NULL DEFAULT '0',
  `id_interface_super_top` varchar(40) DEFAULT NULL,
  `unit_replica_super_top` int(11) DEFAULT '0',
  `order` int(11) NOT NULL,
  `actions` text COMMENT '"action_1; action_2; ... action_n". Nomes de ações separados por ponto-e-vírgula para evitar outra tabela.',
  `conditions` text COMMENT '"condition_1; condition_2; ... condition_n". Nomes de condições separados por ponto-e-vírgula para evitar outra tabela.',
  `protocol` text COMMENT 'string xml',
  PRIMARY KEY (`id_abstract`,`id_interface`,`unit_replica`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `interfaceaction` (
  `id_abstract` int(11) NOT NULL,
  `id_interface` varchar(45) NOT NULL,
  `partition_index` int(11) NOT NULL,
  `id_action` varchar(45) NOT NULL DEFAULT 'main',
  `protocol` text,
  `is_condition` int(11) DEFAULT '0',
  PRIMARY KEY (`id_abstract`,`id_interface`,`partition_index`,`id_action`),
  KEY `id_abstract` (`id_abstract`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `interfaceparameters` (
  `id_interface` varchar(40) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  `parid` varchar(40) NOT NULL,
  `varid` varchar(40) NOT NULL,
  `id_interface_parameter` varchar(40) NOT NULL,
  `id_unit_parameter` varchar(40) NOT NULL,
  `par_order` int(11) NOT NULL,
  PRIMARY KEY (`id_abstract`,`id_interface`,`parid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `sessions` (
  `session_id` int(11) NOT NULL AUTO_INCREMENT,
  `id_concrete` int(11) DEFAULT NULL,
  PRIMARY KEY (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `slice` (
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_inner` varchar(40) NOT NULL DEFAULT '"',
  `id_interface_slice` varchar(40) NOT NULL,
  `slice_replica` int(11) NOT NULL DEFAULT '0',
  `unit_replica` int(11) NOT NULL,
  `id_interface` varchar(40) NOT NULL,
  `unit_replica_host` int(11) NOT NULL,
  `property_name` varchar(40) NOT NULL,
  `transitive` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_abstract`,`id_inner`,`id_interface_slice`,`slice_replica`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `sliceexposed` (
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_inner_owner` varchar(40) NOT NULL COMMENT '* id_abstract + id_inner + id_interface_slice + partition_index point to a transitive inner component.\n* Since many transitive inner components may be fused, it is necessary to include id_inner_owner in the primary key to ensure its uniqueness.',
  `id_interface_slice_owner` varchar(40) NOT NULL,
  `id_inner_original` varchar(40) NOT NULL,
  `id_interface_slice_original` varchar(40) NOT NULL,
  `id_inner` varchar(40) NOT NULL DEFAULT '"',
  `id_interface_slice` varchar(40) NOT NULL,
  `slice_replica` int(11) NOT NULL DEFAULT '-1',
  `slice_replica_owner` int(11) NOT NULL,
  PRIMARY KEY (`id_abstract`,`id_inner_owner`,`id_interface_slice_owner`,`id_inner_original`,`id_interface_slice_original`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='* id_abstract + id_inner + id_interface_slice + partition_in'$$


delimiter $$

CREATE TABLE `sourcecode` (
  `type_owner` char(1) NOT NULL COMMENT '"u" (unit) or "i" (interface)',
  `id_owner` varchar(40) NOT NULL DEFAULT '',
  `contents` text NOT NULL,
  `file_type` varchar(3) NOT NULL COMMENT '"dll" or "exe"',
  `file_name` varchar(45) NOT NULL,
  `id_owner_container` int(11) NOT NULL,
  `file_order` int(11) NOT NULL,
  PRIMARY KEY (`type_owner`,`id_owner_container`,`id_owner`,`file_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `sourcecode_references` (
  `type_owner` char(1) NOT NULL,
  `id_owner_container` int(11) NOT NULL,
  `id_owner` varchar(40) NOT NULL DEFAULT '"',
  `file_name` varchar(45) NOT NULL,
  `reference` varchar(45) NOT NULL,
  PRIMARY KEY (`type_owner`,`id_owner_container`,`id_owner`,`file_name`,`reference`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `supplyparameter` (
  `id_parameter` varchar(30) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_abstract` int(11) NOT NULL,
  PRIMARY KEY (`id_parameter`,`id_functor_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `supplyparametercomponent` (
  `id_parameter` varchar(30) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_functor_app_actual` int(11) NOT NULL,
  PRIMARY KEY (`id_parameter`,`id_functor_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `supplyparameterparameter` (
  `id_parameter` varchar(30) NOT NULL,
  `id_functor_app` int(11) NOT NULL,
  `id_parameter_actual` varchar(30) NOT NULL,
  `freeVariable` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_parameter`,`id_functor_app`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$


delimiter $$

CREATE TABLE `unit` (
  `id_concrete` int(11) NOT NULL,
  `id_unit` varchar(40) NOT NULL DEFAULT '"',
  `id_interface` varchar(40) NOT NULL,
  `unit_replica` int(11) NOT NULL DEFAULT '0',
  `id_abstract` int(11) NOT NULL DEFAULT '0',
  `id_unit_super` varchar(40) DEFAULT '"',
  `assembly_string` varchar(511) DEFAULT NULL COMMENT 'The name of the assembly where the unit class is contained.',
  `class_name` varchar(127) NOT NULL COMMENT 'The name of the class that implements the unit.',
  `uri_source` varchar(255) NOT NULL DEFAULT '' COMMENT 'where the source code is',
  `class_nargs` int(11) NOT NULL DEFAULT '0',
  `order` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_concrete`,`id_unit`,`unit_replica`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1$$




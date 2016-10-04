#!/bin/sh
export PATH_HOSTS_FILE=./map.hpe_nodes
mono ../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_map.xml -prefix=shelf_mapreduce

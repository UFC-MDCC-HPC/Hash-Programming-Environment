#!/bin/sh
export PATH_HOSTS_FILE=./data_source.hpe_nodes
mono ../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_data_source.xml -prefix=shelf_mapreduce

#!/bin/sh
export PATH_HOSTS_FILE=./source.hpe_nodes
mono ../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_source.xml -prefix=shelf_mapreduce

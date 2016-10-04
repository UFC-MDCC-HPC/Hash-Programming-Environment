#!/bin/sh
export PATH_HOSTS_FILE=./reduce.hpe_nodes
mono ../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_reduce.xml -prefix=shelf_mapreduce

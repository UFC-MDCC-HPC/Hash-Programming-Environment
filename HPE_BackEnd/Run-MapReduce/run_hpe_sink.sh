#!/bin/sh
export PATH_HOSTS_FILE=./sink.hpe_nodes
mono ../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_sink.xml -prefix=shelf_mapreduce

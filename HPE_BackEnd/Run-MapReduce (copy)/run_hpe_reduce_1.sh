#!/bin/sh
export PATH_HOSTS_FILE=./reduce_1.hpe_nodes
export BASE_BINDING_FACET_PORT=5640
../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_reduce_1.xml -prefix=shelf_mapreduce

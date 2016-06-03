#!/bin/sh
export PATH_HOSTS_FILE=./reduce_0.hpe_nodes
export BASE_BINDING_FACET_PORT=5512
../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_reduce_0.xml -prefix=shelf_mapreduce

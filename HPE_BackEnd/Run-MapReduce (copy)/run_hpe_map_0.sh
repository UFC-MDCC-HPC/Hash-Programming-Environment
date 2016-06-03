#!/bin/sh
export PATH_HOSTS_FILE=./map_0.hpe_nodes
export BASE_BINDING_FACET_PORT=5256
../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_map_0.xml -prefix=shelf_mapreduce

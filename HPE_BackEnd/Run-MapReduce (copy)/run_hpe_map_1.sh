#!/bin/sh
export PATH_HOSTS_FILE=./map_1.hpe_nodes
export BASE_BINDING_FACET_PORT=5384
../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_map_1.xml -prefix=shelf_mapreduce

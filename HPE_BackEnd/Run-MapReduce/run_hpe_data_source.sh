#!/bin/sh
export PATH_HOSTS_FILE=./data_source.hpe_nodes
export BASE_BINDING_FACET_PORT=5000
../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_data_source.xml -prefix=shelf_mapreduce

#!/bin/sh
export PATH_HOSTS_FILE=./data_sink.hpe_nodes
export BASE_BINDING_FACET_PORT=5128
../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_data_sink.xml -prefix=shelf_mapreduce

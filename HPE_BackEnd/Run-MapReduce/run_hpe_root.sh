#!/bin/sh
export PATH_HOSTS_FILE=./root.hpe_nodes
export BASE_BINDING_FACET_PORT=4872
../bin/hpe_run.exe -instantiator_file=run.shelf_mapreduce.platform_root.xml -prefix=shelf_mapreduce

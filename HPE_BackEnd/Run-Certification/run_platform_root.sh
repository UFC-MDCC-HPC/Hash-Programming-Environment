#!/bin/sh
export PATH_HOSTS_FILE=./root.hpe_nodes
mono ../bin/hpe_run.exe -instantiator_file=run.certification.platform_root.xml -prefix=certify

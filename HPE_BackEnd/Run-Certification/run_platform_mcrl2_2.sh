#!/bin/sh
export PATH_HOSTS_FILE=./mcrl2_2.hpe_nodes
/opt/mono-4.2.2/bin/mono ../bin/hpe_run.exe -instantiator_file=run.certification.platform_mcrl2_2.xml -prefix=certify

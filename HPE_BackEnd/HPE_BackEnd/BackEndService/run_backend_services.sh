#!/bin/sh
export HPE_NEXT_FREE_WORKER_PORT=4865
export HPE_NEXT_FREE_PLATFORM_SERVICE_PORT=8082
export HPE_PLATFORM_ACCESS=127.0.0.1
export HPE_PATH_WORKER=/home/heron/Dropbox/Copy/ufc_mdcc_hpc/Hash-Programming-Environment/HPE_BackEnd
export HPE_PATH_PLATFORM_SERVICE=/home/heron/Dropbox/Copy/ufc_mdcc_hpc/Hash-Programming-Environment/HPE_BackEnd/HPE_BackEnd/PlatformService
export PATH_TEXT_FILES_WORD_COUNTER_INPUT=/home/heron/SOURCE
export PATH_TEXT_FILES_WORD_COUNTER_OUTPUT=/home/heron/SINK
export PATH_GRAPH_FILE=/home/heron/hpe/carga_graph/amazon0302.e  
sudo ps aux | grep -ie mono-service | awk '{print "kill -9 " $2}' | sudo sh -x
sudo ps aux | grep -ie mpirun | awk '{print "kill -9 " $2}' | sudo sh -x
sudo ps aux | grep -ie xsp4 | awk '{print "kill -9 " $2}' | sudo sh -x
rm ../../Worker*.lock
/opt/mono-4.2.2/bin/xsp4 --port 8081


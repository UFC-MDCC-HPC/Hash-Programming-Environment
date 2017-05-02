#!/bin/sh
export SWL_ORCHESTRATION_FILE_LOCATION=/home/heron/Dropbox/Copy/ufc_mdcc_hpc/Hash-Programming-Environment/HPE_BackEnd/Run-MapReduce/CountWords_Workflow.xml
export SWL_ARCHITECTURE_FILE_LOCATION=/home/heron/Dropbox/Copy/ufc_mdcc_hpc/Hash-Programming-Environment/HPE_BackEnd/Run-MapReduce/CountWords_Architecture.xml
mpirun --configfile worker.launch.config.root

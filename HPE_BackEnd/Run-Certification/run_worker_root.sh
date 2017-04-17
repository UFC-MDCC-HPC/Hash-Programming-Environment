#!/bin/sh
export MCRL2_FILE="MapReduce.mcrl2"
export PATH_CERTIFIER=/home/heron/Dropbox/Copy/ufc_mdcc_hpc/Hash-Programming-Environment/HPE_BackEnd/Run-Certification/certifier
mpirun --configfile worker.launch.config.root

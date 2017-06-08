#!/bin/sh
export BACKEND_PROPERTIES_FILE=/home/heron/hpe.backend.properties
mpirun --configfile worker.launch.config.9

#!/bin/sh
export BACKEND_PROPERTIES_FILE=/home/heron/hpe.backend.safe.properties
mpirun --configfile worker.launch.config.9

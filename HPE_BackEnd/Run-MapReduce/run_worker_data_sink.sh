#!/bin/sh
export PATH_TEXT_FILES_WORD_COUNTER_OUTPUT=/home/heron/DATA_SINK
mpirun --configfile worker.launch.config.sink

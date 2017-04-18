#!/bin/sh
export PATH_TEXT_FILES_WORD_COUNTER_INPUT=/home/heron/DATA_SOURCE
mpirun --configfile worker.launch.config.data_source

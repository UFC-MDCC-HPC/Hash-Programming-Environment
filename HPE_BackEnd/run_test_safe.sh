#!/bin/sh
export SWL_ARCHITECTURE_FILE_LOCATION=./Run-MapReduce/CountWordsArchitecture.xml
export SWL_ORQUESTRATION_FILE_LOCATION=./Run-MapReduce/CountWordsWorkflow.xml
export BACKEND_PROPERTIES_FILE=/home/heron/hpe.backend.safe.properties
/opt/mono-4.2.2-safe/bin/mono bin/TestSAFe.exe

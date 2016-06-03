#!/bin/sh
export HPE_NEXT_FREE_WORKER_PORT=4865
export HPE_NEXT_FREE_PLATFORM_SERVICE_PORT=8082
export HPE_PLATFORM_ACCESS=localhost
export HPE_PATH_WORKER=Copy/ufc_mdcc_hpc/Hash-Programming-Environment/HPE_BackEnd
export HPE_PATH_PLATFORM_SERVICE=Copy/ufc_mdcc_hpc/Hash-Programming-Environment/HPE_BackEnd/HPE_BackEnd/PlatformService
/usr/bin/xsp4 --port 8081

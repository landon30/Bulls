#!/bin/sh

export LD_PRELOAD=/usr/local/lib/libtcmalloc.so
export HEAPPROFILE=/tmp/nonheapleak

nohup java -cp ./NonHeapLeak.jar NonHeapLeakExample & 
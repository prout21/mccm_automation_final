#!/bin/bash

# Now Run the application
xvfb-run --server-args="-screen 0 1024x768x24" java ExecutionUSECase.MainClass

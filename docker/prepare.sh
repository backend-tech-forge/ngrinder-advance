#!/usr/bin/env bash
CONTROLLER_BINARY_DIR="controller/binary"
NGRINDER_CONTROLLER_BUILD_DIR="../ngrinder-controller/build/libs"
NGRINDER_WAR_FILES="${NGRINDER_CONTROLLER_BUILD_DIR}/*.war"

echo "Checking ngrinder-controller war file"
if ls ${NGRINDER_WAR_FILES} 1> /dev/null 2>&1; then
    echo "Copying ngrinder-controller war file to ${CONTROLLER_BINARY_DIR}"
    mkdir -p ${CONTROLLER_BINARY_DIR}
    for war_file in ${NGRINDER_WAR_FILES}; do
        cp -n ${war_file} ${CONTROLLER_BINARY_DIR}/
    done
else
    echo "No ngrinder-controller war file found. Skipping the copying process."
fi

echo "Create directory for ngrinder-controller"
mkdir -p ~/ngrinder-controller
chmod -R 777 ~/ngrinder-controller

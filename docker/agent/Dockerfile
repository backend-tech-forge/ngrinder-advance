FROM amazoncorretto:11

RUN yum install -y bash udev curl wget tar unzip gzip

# Set up environment variables
ENV JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8
ENV LANG=en_US.UTF-8
ENV BASE_DIR=/opt \
    NGRINDER_AGENT_BASE=/opt/ngrinder-agent \
    NGRINDER_AGENT_HOME=/opt/ngrinder-agent/.ngrinder-agent

VOLUME $NGRINDER_AGENT_BASE

# Copy initial execution script
COPY scripts /scripts

# Excution
ENTRYPOINT ["/scripts/run.sh"]

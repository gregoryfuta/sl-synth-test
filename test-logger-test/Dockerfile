FROM gradle:7.6.1-jdk11

RUN apt update
RUN apt -y install vim less
WORKDIR /
WORKDIR /opt
RUN mkdir workspace

COPY . workspace
WORKDIR /opt/workspace

# RUN gradle clean test > log.log









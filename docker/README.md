Introduction
==========

What is nGrinder?
---------

nGrinder is a platform for stress tests that enables you to execute script creation, test execution, monitoring, and result report generator simultaneously. The open-source nGrinder offers easy ways to conduct stress tests by eliminating inconveniences and providing integrated environments. It is licensed under the Apache License, Version 2.0.

> http://naver.github.io/ngrinder/

nGrinder consists of two major components.

* __controller__ : a web application that enables the performance tester to create a test script and configure a test run. You can get the controller docker images [ngrinder/controller](https://registry.hub.docker.com/r/ngrinder/controller).

* __agent__ : a virtual user generator that creates loads. You can get the agent docker images [ngrinder/agent](https://registry.hub.docker.com/r/ngrinder/agent).

Version
---------
Current Version: 3.5.8

How to run nGrinder with dockers
===========================

Controller
------------ 
Install docker 1.5.0 or above  on your host.

In `docker` directory, run `prepare.sh ` to create the ngrinder-controller folder on your host or to copy `*.war` file to the binary folder.

```bash
$ cd docker
$ sh prepare.sh
```

In `docker` directory, run docker compose to start the agent and controller

```bash
$ docker compose -f docker-compose.yml up -d
```


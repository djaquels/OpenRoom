#!/bin/bash
docker build -t apidb .
docker run --name postgres-apidb -p 5432:5432 -d apidb
# for testing
#!/bin/bash

# Build the Docker image
docker build -t apidb .

# Check if a container named "postgres-apidb" exists
if docker ps -a --format '{{.Names}}' | grep -q '^postgres-apidb$'; then
  echo "Container 'postgres-apidb' already exists. Removing it..."
  docker rm -f postgres-apidb
fi

# Run the new container
echo "Starting new container 'postgres-apidb'..."
docker run --name postgres-apidb -p 5432:5432 -d apidb

# For testing
echo "Container 'postgres-apidb' is running."
docker ps -a | grep postgres-apidb
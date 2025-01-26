FROM postgres:latest

# Environment variables to configure the database
ENV POSTGRES_DB=api
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=*sametSis1!

# Copy the DDL SQL file into the container
COPY ddl.sql /docker-entrypoint-initdb.d/ddl.sql

# Expose PostgreSQL default port
EXPOSE 5432

# The database will be initialized with the SQL file automatically by the official PostgreSQL Docker entrypoint script.

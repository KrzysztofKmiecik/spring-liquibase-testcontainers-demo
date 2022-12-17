dev
docker run --name postgresql-dev -p 5433:5432 -e POSTGRES_PASSWORD=postgres -d postgres

test
docker run --name postgresql-test -p 5434:5432 -e POSTGRES_PASSWORD=postgres -d postgres

prod
docker run --name postgresql-prod -p 5435:5432 -e POSTGRES_PASSWORD=postgres -d postgres


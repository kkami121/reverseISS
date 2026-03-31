# Itemlink

## Docker

### Prerequisites
- Docker Desktop running

### Build & Run
```bash
docker compose build
docker compose up
```

### Stop
```bash
docker compose down
```

### Services
- App: http://localhost:5004
- PostgreSQL: external server (192.168.57.7:5432)

### Notes
- Fill DB connection values in `.env` before running:
  - `POSTGRES_USER`
  - `POSTGRES_PASSWORD`

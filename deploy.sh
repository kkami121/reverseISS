#!/bin/bash
set -e

APP_DIR="$(cd "$(dirname "$0")" && pwd)"

echo "=== [1/4] 최신 코드 pull ==="
git -C "$APP_DIR" pull

echo "=== [2/4] 기존 컨테이너 중지 ==="
docker compose -f "$APP_DIR/docker-compose.prod.yml" --env-file "$APP_DIR/.env.prod" down

echo "=== [3/4] 이미지 빌드 및 컨테이너 시작 ==="
docker compose -f "$APP_DIR/docker-compose.prod.yml" --env-file "$APP_DIR/.env.prod" up --build -d

echo "=== [4/4] 컨테이너 상태 확인 ==="
docker compose -f "$APP_DIR/docker-compose.prod.yml" ps
docker logs reverseiss-app --tail 30

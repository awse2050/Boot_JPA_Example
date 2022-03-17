#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh
source ${ABSDIR}/switch.sh

IDLE_PROT=$(find_idle_port)

echo "> health check start"
echo "> idle_port : $IDLE_PROT"
echo "> curl -s http://localhost:$IDLE_PROT/profile"
sleep 10

for RETRY_COUJNT in {1..10}
do
  RESPONSE=$(curl -s http://localhost:${IDLE_PROT}/profile)
  UP_COUNT=$(echo ${RESPONSE} | grep 'real' | wc -1)

  if [ ${UP_COUNT} -ge 1 ]
  then
    echo "> Health check success"
    switch_proxy
    break
  else
    echo " > Health check 응답을 알수없거나 실행상태가 아닙ㄴ디ㅏ."
    echo "> health check : ${RESPONSE}"
  fi

  if [ ${RETRY_COUJNT} -eq 10 ]
  then
    echo "> health check 실패"
    echo "> 엔진엑스에 연결하지 않고 배포를 종료"
    exit 1
  fi

  echo "> health check 연결 실패 재시도.."
  sleep 10
done
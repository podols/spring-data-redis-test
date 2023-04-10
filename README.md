# redis 실행 방법
1. docker compose up

# session 테스트 방법
1. jar build
   
2. 서버 2개 실행
    - java -Dserver.port=8080 -jar ./build/libs/spring-redis-test-0.0.1-SNAPSHOT.jar
    - java -Dserver.port=8080 -jar ./build/libs/spring-redis-test-0.0.1-SNAPSHOT.jar
    
3. 세션 저장 
   - http://localhost:8080/login/name=a
    
4. 세션 조회
    - http://localhost:8080/myName
    - http://localhost:8081/myName 
   
# cache 테스트 방법
1. ./client/cache_test_http_client.http 사용

# leaderboard 테스트 방법
1. ./test/java/com/example/redis/leaderboard/SimpleTest.java 사용

# stream 테스트 방법
1. ./client/stream_test_http_client.http 사용
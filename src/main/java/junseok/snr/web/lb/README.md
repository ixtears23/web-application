## Spring Cloud LoadBalancer(Client Side)
Client Side LoadBalancer
- 경로 : `junseok.snr.web.lb`
- LoadBalancing 하는 Client 코드 : `junseok.snr.web.lb.client`
- Client 에서 테스트를 위해 호출 하는 서버 : `junseok.snr.web.lb.server`

JVM 옵션 중 -D 옵션과 server.port 를 사용하면 application.yaml 에 있는 port 경로를 덮어쓴다.  
총 4개의 Port로 SpringBoot를 띄운다.
1. 65001 - client
2. 65002 - server1
3. 65003 - server2
4. 65004 - server3

테스트 가독성을 위해 Spring Boot Server 설정에   
Environment Variables 에 `server.instance.id` 에 값을 준다.  
- server1 = server.instance.id=1
- server2 = server.instance.id=2
- server3 = server.instance.id=3

`lb.http` 파일에서 테스트!

동일한 url로 server1,2,3에 요청이 가는지 확인! :)  

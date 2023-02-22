# spring-cloud

### 개요
Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA) 강의를 듣고 필요한 내용을 정리하거나, 나만의 방식으로 구현하고 싶은 코드를 관리하는 저장소 입니다.

### 기타
강의에서는 maven 환경과 각 애플리케이션을 별도로 생성하지만 해당 레파지토리에서는 애플리케이션을 별도로 나누지 않고 멀티모듈 형태로 구축하며, gradle을 사용합니다.  


### 참고 사항

#### 1. Config 서버 구축 시 private git repo 생성
- (터미널 사용)
- 프로젝트 최상위 경로의 application-configs 폴더로 이동
- git init
- git add xxxx.yml
- git commit -m "commit message"
- pwd 명령어를 통해 현재 경로 확인
- spring-config application.yml 내용 수정
```yaml
spring:
  application:
    name: config-service
  cloud:
    config:
      server:
        git:
          uri: file://{pwd를 통해 얻은 경로 붙여넣기}

```


## Reference📜

[Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/dashboard)



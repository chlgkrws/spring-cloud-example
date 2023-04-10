# spring-cloud

### 개요
Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA) 강의를 듣고 필요한 내용을 정리하거나, 나만의 방식으로 구현하고 싶은 코드를 관리하는 저장소 입니다.

### 기타
강의에서는 maven 환경과 각 애플리케이션을 별도로 생성하지만 해당 레파지토리에서는 애플리케이션을 별도로 나누지 않고 멀티모듈 형태로 구축하며, gradle을 사용합니다.  


### 참고 사항



#### 1. Config 서버 구축 시 private git repo 생성

1. (Terminal) application-configs 폴더로 이동
2. Github Repo 생성 (repo 명: spring-cloud-example-config)
3. (Terminal) git remote add origin https://github.com/{repo명}/spring-cloud-example-config.git 수행
4. (Terminal) git push --set-upstream origin master 수행
```yaml
spring:
  application:
    name: config-service
  cloud:
    config:
      server:
        git:
          uri: https://github.com/{repo명}/spring-cloud-example-config.git
#          username: [your username] only private repo
#          password: [your password] only private repo

```
<br/>

**아래는 Config 정보(yaml)을 로컬 git repo에 저장했을 경우만 사용합니다.**
- (터미널 사용)
1. 프로젝트 최상위 경로의 application-configs 폴더로 이동 
2. git init 
3. git add xxxx.yml 
4. git commit -m "commit message"
5. pwd 명령어를 통해 현재 경로 확인 
6. spring-config application.yml 내용 수정
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

#### 2. Rabbit MQ 설치(for Apple Silicon)
```shell
# 설치 및 환경설정
brew update

brew install rabbitmq

export PATH=$PATH:/opt/homebrew/sbin

# 실행
brew services start rabbitmq
# 종료
brew services stop rabbitmq
```

실행 후 http://localhost:15672로 접속하면 default 사용자인 guest/guest로 접속할 수 있습니다.

## Reference📜

[Spring Cloud로 개발하는 마이크로서비스 애플리케이션(MSA)](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%81%B4%EB%9D%BC%EC%9A%B0%EB%93%9C-%EB%A7%88%EC%9D%B4%ED%81%AC%EB%A1%9C%EC%84%9C%EB%B9%84%EC%8A%A4/dashboard)



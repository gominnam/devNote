# Http Caching

HTTP cookie (web cookie, browser cookie)는 서버가 web-browser로 보낸 작은 데이터를 말한다.
HTTP는 STATELESS 프로토콜이기 때문에 필요한 정보들을 cookie에 저장한다.
browser는 cookie를 저장하고 있다가 다음 요청에 같이 보낸다. 


## 쿠키를 주요한 목적으로 사용하는 3가지

1. session management 
- 로그인, 쇼핑 장바구니, 게임 스코어, 서버가 기억할 것들
2. Personalization
- 사용자 설정, 테마 및 기타 세팅들
3. Tracking
- 사용자 행동을 기록하고 분석

!! 쿠키는 요청이 있을 때 마다 전송되므로 성능에 문제가 있을 수 있다. 요즘은 최신 스토리지 API가 권장된다.!!


## 쿠키 설정하기

- Set-Cookie HTTP 응답 헤더는 server에서 client로 보냅니다.
- 간단한 예시
```http
    // HTTP response 예시

    HTTP/2.0 200 OK
    Content-Type: text/html
    Set-Cookie: yummy_cookie=choco
    Set-Cookie: tasty_cookie=strawberry

    [page content]
```
- 위와 같은 쿠키로 설정되어 후속 요청을 보낼 때마다 이전에 저장된 쿠키 헤더를 사용하여 서버에 다시 보낸다.
- 쿠키 생명주기 관리하는 방법
1. 세션 쿠키는 현재 세션이 종료되면 삭제되는 임시 쿠키이다.
2. 영속 쿠키는 지정된 만료 날짜에 삭제되는 쿠키이다. 다음 만료 날짜를 보낸 쿠키 예시
```http
    Set-Cookie: id=a3fWa; Expires=Thu, 31 Oct 2021 07:28:00 GMT;
```


---

## reference

- [http-cookies](https://developer.mozilla.org/en-US/docs/Web/HTTP/Cookies)
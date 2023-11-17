
# Http Caching

- client가 요청의 응답을 저장하여 나중에 요청에 재사용하는 목적을 갖는다.
- 그래서 서버의 부하를 줄일 수 있다.
- 가장 흔한 예로 브라우저 캐시가 있다.

## Types of caches

1. private cache
- 특정 client에게만 적용되는 캐시(ex. browser). 다른 client 와는 공유할 수 없는 정보를 저장
- private cache는 그래서 보통 cookie를 사용한다.


2. shared cache
- client와 server 사이에 위치하며 다른 client와 공유할 수 있는 캐시
- proxy cache와 cache를 관리하는 manage cache로 세분화하여 나눌 수 있다.
- 오래된 캐시는 문제를 발생시키는 경우가 있어서 헤더에 다음과 같이 추가하려 문제를 해결할 수 있다.
```
    Cache-Control: no-store, no-cache, max-age=0, must-revalidate, proxy-revalidate
```
- manage cache는 원본 서버의 부하를 덜어주고 콘텐츠를 효율적으로 제공하기 위해 서비스 개발자가 배포한다.
예를들어 Cache API와 CDN 및 서비스 작업자가 있다.


---

## reference

- [http-cahce](https://developer.mozilla.org/en-US/docs/Web/HTTP/Caching)

# OSI 7 Layers

## 1. Physical Layer (물리 계층)

- 물리 계층은 비트(0과 1) 스트림이 물리적으로 전송을 담당한다.
- 데이터를 전기적 신호로 변환하여 전송한다.


## 2. Data Link Layer (데이터 링크 계층)

- 데이터 링크 계층은 물리 계층에서 전송된 데이터를 프레임으로 쪼개어 물리계층을 통해 송수신 할 수 있도록 한다.
- 프레임(Frame): ex) [ 시작플래그 | 목적지 MAC 주소 | 출발지 MAC 주소 | 유형 | 데이터 | CRC | 종료플래그 ] 
- 네트워크 카드의 MAC 주소(불변)를 가지고 있어서 특정 장치에게 전달된다.


## 3. Network Layer (네트워크 계층)

- 네트워크 계층은 데이터 패킷이 소스에서 목적지로 올바르게 라우팅되도록 한다.
- 라우팅(Routing): 패킷이 목적지로 전달되는 경로를 결정하는 과정 (라우팅 알고리즘)
- IP 주소를 사용하여 장치를 식별하고 라우팅과 포워딩을 수행한다.


## 4. Transport Layer (전송 계층)

- 전송 계층은 송신자와 수신자 간의 데이터 전송을 관리한다.
- 데이터 전송을 위한 연결을 설정하고, 데이터 전송이 완료되면 연결을 해제한다.
- TCP(Transmission Control Protocol)와 UDP(User Datagram Protocol)가 있다.


## 5. Session Layer (세션 계층)

- 세션 계층은 네트워크 연결에서 세션을 설정, 관리, 종료하는 역할을 한다.
- 양쪽 응용프로그램이 통신을 유지하고, 동기화하며, 복구할 수 있도록 한다.


## 6. Presentation Layer (표현 계층)

- 표현 계층은 데이터를 응용 프로그램이 이해할 수 있는 형식으로 변환한다.
- 데이터 압축, 암호화, 문자 인코딩 등을 수행한다.


## 7. Application Layer (응용 계층)

- 응용 계층은 사용자와 네트워크 간의 상호작용을 관리한다.
- HTTP, FTP, SMTP 등이 있다.


## Reference

- [www.checkpoint.com](https://www.checkpoint.com/cyber-hub/network-security/what-is-the-osi-model-understanding-the-7-layers/)
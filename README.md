# 서비스 개요
본 서비스는 기업의 채용 프로세스를 관리하고 사용자가 이에 지원할 수 있는 웹 어플리케이션입니다. 기업은 채용 공고를 작성하고 관리할 수 있으며, 사용자는 해당 공고에 지원할 수 있습니다.

# 요구사항 분석

기업은 채용 공고를 작성, 수정, 삭제할 수 있어야 한다.
사용자는 채용 공고 검색, 지원할 수 있어야 한다.
모델 정의 중 회사, 사용자, 채용공고, 지원내역는 필수이다.
채용 공고 상세 페이지에서는 회사의 다른 공고의 게시물 번호도 확인 할 수 있어야 한다.

# 기술 스택

Backend : Java, Spring Framework
데이터베이스 : MySQL
DB 연결 : JDBC, HikariCP
JSON 처리 : Jackson
버전 관리 : Git, GitHub

# 구현 과정

●프로젝트 초기 설정
프로젝트 디렉토리 생성 및 Git 저장소 초기화
필요한 의존성 라이브러리(React, Spring 등) 설치 및 설정

●회사 기능 구현
회사 회원가입과 로그인 기능 구현
채용 공고 작성, 수정, 삭제 기능 구현
작성한 채용 공고의 지원 현황 확인 기능 구현

●예외 처리
RestControllerAdvice를 통한 공통 예외 처리

●테스트 및 디버깅
JUnit으로 유닛 테스트 케이스 구현

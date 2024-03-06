# java-blackjack

블랙잭 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 요구 사항 정리

- [x] 카드
    - [x] 카드 종류와 번호를 필드로 갖고 있다
- [x] 덱
    - [x] 52개의 카드를 만들어서 List로 만든다
    - [x] 랜덤으로 섞는다
    - [x] 하나씩 반환한다
    - [x] 카드가 다 떨어지면 예외를 발생시킨다
- [x] 패
    - [x] 점수를 계산해서 반환한다
    - [ ] 만약에 에이스가 포함되어 있고 21점을 넘으면 SMALL_ACE 카드로 바꾼다
- [ ] 게이머
    - [ ] 플레이어와 딜러의 추상 클래스
    - [ ] 카드를 패에 넣는다
    - [ ] 자신의 모든 패를 반환한다
- [ ] 플레이어
    - [ ] 입력받은 이름으로 초기화된다
- [ ] 딜러
    - [ ] "딜러" 이름으로 초기화된다
    - [ ] 자신의 카드 한장만 반환한다
- [ ] 블랙잭게임
    - [ ] Gamer들에게 카드를 2장씩 나눠준다
    - [ ] Player들이 카드를 뽑을지 결정하도록 한다
        - [ ] Burst가 발생하면 다음 참가자의 입력을 받는다
        - [ ] 모든 참가자가 완료할 때까지 반복한다
    - [ ] Dealer가 자신의 차례가 종료할 때까지 카드를 뽑는다
        - [ ] 합계가 17 이상이면 차례가 종료한다
    - [ ] Gamer들의 패와 총점을 반환한다
    - [ ] Gamer들의 최종 승패를 반환한다
- [x] 카드 종류, 번호
    - [x] 카드 번호 enum으로 관리
    - [x] 카드 종류 enum으로 관리


- 참가자의 이름 입력받는다
    - 쉼표 기준으로 분리한다
    - 빈 문자열, null은 예외로 처리한다
    - 이름의 길이는 1글자 이상, 5글자 이하여야 한다
    - 중복된 이름이 입력되면 예외로 처리한다
    - 이름은 알파벳, 한글, 숫자, '_', '-'로만 이루어져야 한다
    - 이름과 구분자 사이의 공백이 있으면 제거한다
    - 참가자의 수는 2명 이상, 8명 이하여야 한다
- 딜러와 참가자 모두에게 카드를 랜덤으로 2장씩 나누어준다
    - 분배되는 카드는 중복되지 않는다
    - 분배된 카드를 출력한다
        - 딜러의 카드는 한 장만 출력한다
- 참가자들은 카드를 더 받을지 입력받는다
    - "y"가 입력되면 랜덤으로 카드를 한 장 받는다
        - 갖고 있는 카드를 출력한다
        - 다시 카드를 더 받을지 입력받는다
    - "n"이 입력되면 다음 참가자의 입력을 받는다
        - 입력된 "n"이 첫 번째 입력이면 갖고 있는 카드를 출력한다
    - 카드의 합이 21 초과일 경우 카드를 받을 수 없다
        - 다음 참가자의 입력을 받는다
    - 모든 참가자들의 입력이 끝날 때까지 반복한다
- 딜러는 카드를 더 받을지 결정한다
    - 16 이하일 경우 랜덤으로 카드를 한 장 받는다
    - 17을 넘기 전까지 카드를 계속 뽑는다
- 딜러와 참가자 모두의 카드와 합계를 출력한다
    - 딜러를 출력한 후 참가자들을 입력받은 순서대로 출력한다
- 최종 승패를 출력한다
    - 딜러의 플레이어들의 점수와 비교해서 총 승패를 출력한다
    - 플레이어는 딜러를 이기면 "승", 지면 "패"를 출력한다

## 실행 결과

```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

딜러와 pobi, jason에게 2장을 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

딜러는 16이하라 한장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 승패
딜러: 1승 1패
pobi: 승
jason: 패
```

## 프로그래밍 요구사항

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
- 배열 대신 컬렉션을 사용한다.
- 모든 원시 값과 문자열을 포장한다
- 줄여 쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.
- 모든 엔티티를 작게 유지한다.
- 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
- 딜러와 플레이어에서 발생하는 중복 코드를 제거해야 한다.

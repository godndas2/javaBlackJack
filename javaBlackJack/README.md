# 1차 완료후 리팩토링

```
Card의 패턴과 끗수를 enum으로
자연스러운 네이밍
isReceiveCard, receiveCardAllPlayers 등은 정상적인 문법은 아님
list 대신 stack을 사용
API와 View영역을 분리
Player.showCards()가 과연 player의 역할인지
receiveCard는 호출자가 그 결과를 알 수 있는지
테스트 코드 작성
```

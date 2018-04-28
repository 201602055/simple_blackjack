# simple_blackjack
6조
오현정
이재인
정수빈
이현경

![image](https://user-images.githubusercontent.com/33446327/39399433-703b98ba-4b58-11e8-844d-2bfa5be5ce1b.png)

blackjack 간단설명
=================


**blackjack rule in this project**

-dealer는 17~25사이의 수를 랜덤하게 받는다.

-player는 시작할 때 2장의 카드를 받는다.

-player의 카드의 rank값이 16보다 작으면 무조건 hitcard(), 

 그렇지 않으면 stand
 
 -dealer 또는 player 의 rank합이 21을 초과하면 gameover!
 
 -rank합이 21이면 blackjack!
 
 -둘다 21을 넘지 않을 때 21에 가까운 rank를 갖는 사람이 승리!


**evalutor클래스**

  start()메소드
  
  큰 조건문2개
  
  1.while
  
  dealer와 player가 블랙잭 또는 21이상일 경우
  
  16이하면 hitcard()
  
  17이상이면 stand
  
  2.if (1조건을 벗어나서)
  
  dealer와 player 카드값 합 비교



**main클래스**

deck을 생성 후 game 객체 생성

player 2명 생성

evaluator 객체 생성

2장의 카드를 나눠줌

start()메소드를 이용해 게임 시작

**evaluator test**

evaluator객체 생성을 위해 deck과 game객체도 생성

player를 한명만 생성해서 1 vs 1대결 test

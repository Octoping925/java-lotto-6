# 입력

- 로또 구입 금액 입력받기
    - 1000원 단위이며, 나누어떨어지지 않으면 예외처리
    - 예외 발생 시 다시 입력 받기
    - int형으로 리턴하기

- 당첨 번호 입력 받기
    - 쉼표를 기준으로 구분하기
    - 번호가 6개가 아니면 예외
    - 하나라도 숫자가 아니면 예외
    - 중복된 번호가 있으면 예외
    - 1과 45 사이가 아니면 예외
    - 예외 발생 시 다시 입력 받기
    - `List<Integer>`로 리턴하기

- 보너스 번호 입력 받기
    - 당첨 번호에 포함되면 예외
    - 숫자가 아니면 예외
    - 예외 발생 시 다시 입력 받기
    - int로 리턴하기

# 출력

- Exception을 받아 에러 메시지 출력하기

- 로또 구입 금액에 따른 로또 개수 출력하기
    - 로또 구매 숫자 출력하기
    - 발행된 로또 번호를 오름차순으로 출력하기

- 당첨내역 출력하기
    - 3개 일치부터 6개 일치까지 개수 출력하기

- 총 수익률 출력하기
    - 수익률은 소수점 2자리에서 반올림하기

# 도메인 로직

- LottoMarket
    - buyLotto: 로또 구입 금액을 받아서, 로또 티켓을 반환한다.


- LottoTickets
    - Lotto의 일급 컬렉션
    - compare: 당첨번호와 보너스 번호를 받아서, LottoMatchResult의 리스트를 반환한다.


- Lotto
    - compare: 당첨번호와 보너스번호를 받아서, 몇 개가 일치하는지 여부를 담은 LottoMatchResult (VO)를 반환한다.


- LottoMatchResult (VO)
    - 일치하는 개수를 가진다
    - 보너스 번호 일치 여부를 가진다


- LottoGrade (enum)
    - 금액 값을 가진다
    - 일치하는 개수를 가진다
    - 정적 팩토리 메소드: 일치하는 개수와 보너스 번호 일치 여부를 받아서, 해당하는 LottoGrade를 반환한다.


- LottoGenerator (interface)
    - generate: Lotto를 생성한다.

- RandomLottoGenerator
    - generate: 랜덤으로 Lotto를 생성한다.


- LottoPerformanceCalculator
    - calculate: 로또 구입 금액과 LottoGrade의 목록을 받아서 수익률을 계산한다.

# 게임 로직

1. 로또 구입 금액을 입력받는다.
2. 유효성을 체크해서 예외가 발생하면 1로 돌아간다.
3. 로또를 알맞게 구매한다.
4. 로또를 구매한 개수와 구매 결과를 출력한다.
5. 당첨 번호를 입력받는다.
6. 유효성을 체크해서 예외가 발생하면 5로 돌아간다.
7. 보너스 번호를 입력받는다.
8. 유효성을 체크해서 예외가 발생하면 7로 돌아간다.
9. 구매한 로또들과 당첨 번호를 비교한다.
10. 9에서 비교한 결과를 LottoGrade의 리스트로 반환한다.
11. 로또 구입 금액과 LottoGrade의 리스트를 받아서 수익률을 계산한다.
12. 10에서 받은 결과를 출력한다.
13. 11에서 받은 총 수익률을 출력한다.
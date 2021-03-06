## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)


## 문자열 계산기

### 기능 요구 사항
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (e.g. "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)

- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.

- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw 한다.

- 빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다.

- 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.


## 로또
구입금액 -> 로또 갯수 (Lotto) 
    - Validator

사용자가 입력한 당첨 번호와 보너스 볼의 개수와 수가 올바른지 확인
- Validator

랜덤 넘버 -> 함수 따로 빼기 (Lotto)

갯수 -> 리스트 뽑기 (Lotto) 

로또 번호 일치, 개수 체크 (Revenue)

수익률 계산 

손해인지 아닌지

사용자에게 당첨 번호입력받기

사용자에게 보너스 볼 입력 받기

구입 금액 입력받기

중첩리스트 별로 탐색해서 당첨 통계 내기

### 기능 요구 사항
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.

- 로또 1장의 가격은 1000원이다.

- 현재 로또 생성기는 자동 생성 기능만 제공한다. 사용자가 수동으로 추첨 번호를 입력할 수 있도록 해야 한다.

- 입력한 금액, 자동 생성 숫자, 수동 생성 번호를 입력하도록 해야 한다.

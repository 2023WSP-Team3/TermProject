# TermProject
!!!!!clone 주의사항!!!!!
clone 생성 후 강의시간에 사용했던 workspaace의 .metadata 폴더를 clone 디렉토리에 옮길 것

## 서블렛 구조 설명
### 1. login 폴더
GetMemeber.java, CheckMember.java, login.java

GetMemeber.java는 id, password, name을 get/set 하는 클래스

CheckMemeber.java는 login(id, pw) 함수 수행시 입력받은 id를 통해 DB로 부터 입력받은 id와 같은 id 그리고 password를 반환함.
null이 반환되면 id를 찾을 수 없다는 뜻(0 리턴)
이후 입력된 password와 반환된 password를 비교하여 일치하면 로그인 성공(실패시 1 리턴, 성공시 2 리턴)
nameCheck 메서드 수행시 DB에서 닉네임 중복확인 검사 후 중복이면 0 반환. 아니면 1 반환

login.java는 doPost 방식으로 진행
jsp로부터 id와 password를 get하고 CheckMember의 login 함수 실행
2 반환시 jsp의 msg에 "로그인 성공" 문자열을 set, sig에 숫자 2를 set, 해당 id로 세션 저장
0 반환시 jsp의 msg에 "아이디를 찾을 수 없습니다" 문자열을 set, sig에 숫자 0을 set
1 반환시 jsp의 msg에 "비밀번호가 일치하지 않습니다" 문자열을 set, sig에 숫자 1을 set

### 2. signup 폴더
Signup.java

Signup.java는 doPost 방식으로 진행
jsp로 부터 받는 code를 바탕으로 진행, memberInfo List 생성, 빈칸 확인을 위한 code_count 정수형 변수 선언
code가 0일 경우 사용자가 id 중복확인 체크를 눌렀다는 뜻. CheckMember 클래스의 login 메서드를 사용하여 0 이 반환 될 경우 msg1에 "사용 가능한 아이디입니다" set. list 0번에 id add 하고 code_count 값 1 증가.
code가 1일 경우 사용자가 닉네임 중복확인 체크를 눌렀다는 뜻. 닉네임 중복이 아닐 시 msg2에 사용할 수 있다고 set 하고 list 2번에 add, 카운트 값 1 상승
...
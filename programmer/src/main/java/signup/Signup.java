package signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import login.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CheckMember checkMember;
	
    public Signup() {
    	checkMember = new CheckMember();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> memberInfo = new ArrayList<>();
		response.setContentType("text/html;char=UTF-8");
		String code = request.getParameter("code"); // 진행 여부를 판별하기 위한 코드
		int code_count = 0;
		if (code == "0") { // 사용자 id 중복확인 체크 누름
			String id = request.getParameter("id");
	        if(id != null && !id.isEmpty()&& checkMember.login(id, "0") == 0) {
	        	request.setAttribute("msg1", "사용 가능한 아이디입니다");
	        	memberInfo.add(0, id);
	        	code_count += 1;
	        }
	        else {
	        	request.setAttribute("msg1", "이미 사용중인 아이디입니다");
	        }
		}
		else if (code == "1") { // 사용자 닉네임 중복확인 체크 누름
			String name = request.getParameter("name");
	        if (name != null && !name.isEmpty() && checkMember.nameCheck(name) == 1) {
	        	request.setAttribute("msg2", "사용 가능한 닉네임입니다");
	        	memberInfo.add(2, name);
	        	code_count += 1;
	    	}
	        else {
	        	request.setAttribute("msg2", "이미 사용중인 닉네임입니다");
	        }
		}
		else if (code == "2") { // 사용자 비밀번호 체크 누름
			String password = request.getParameter("password");
			if (isValidPassword(password)) {
				request.setAttribute("msg3", "사용 가능한 비밀번호입니다");
				memberInfo.add(1, password);
				code_count += 1;
			}
			else {
				request.setAttribute("msg3", "대문자와 소문자를 최소 하나 포함하는 8자 이상의 영어와 숫자조합으로 만들어 주세요");
			}
		}
		else if (code == "4") { // 사용자가 이메일 체크 누름
			String email = request.getParameter("email");
			if (isValidEmail(email)) {
				request.setAttribute("msg4", "사용 가능한 이메일 주소입니다");
				memberInfo.add(3, email);
				code_count += 1;
			}
			else {
				request.setAttribute("msg4", "올바른 이메일 형식을 입력해 주세요");
			}
		}
		else if (code == "5") {// 사용자가 회원가입 형식을 제출함
			if (code_count == 4) {
				request.setAttribute("msg5", "회원가입이 완료되었습니다");
				// DB에 memberInfo를 set하는 jdbc 클래스
			}
			else 
				request.setAttribute("msg5", "빈 칸이 존재합니다");
		}
    }
	private boolean isValidPassword(String password) {
        // 간단한 패스워드 규칙을 정의
        return password.length() >= 8
                && password.matches(".*[A-Z].*") // 대문자가 최소 하나 이상
                && password.matches(".*[a-z].*") // 소문자가 최소 하나 이상
                && password.matches(".*\\d.*"); // 숫자가 최소 하나 이상
    }
	
    public static boolean isValidEmail(String email) {
        // 이메일 주소를 검증하기 위한 정규 표현식
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // 정규 표현식 패턴 객체 생성
        Pattern pattern = Pattern.compile(emailRegex);

        // 주어진 이메일이 정규 표현식과 일치하는지 확인
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}

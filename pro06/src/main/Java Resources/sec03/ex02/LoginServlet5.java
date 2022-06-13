package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet5
 */
@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); //서블릿에서 웹브라우저에 전달할 데이터의 종류가 html형식임을 setcontenttype을 이용해 알려주고있음 
		PrintWriter out = response.getWriter(); // 웹브라우저에 실제로 출력할 것을 printwriter를 이용해 출력
		String id = request.getParameter("user_id"); //login2.html 의 이름값이 user_id인 것을 id에 넣어줌
		String pw = request.getParameter("user_pw"); 
		String address = request.getParameter("user_address");
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
		
		String data = "<html>";
		data += "<body>";
		data += "아이디 : " + id;
		data += "<br>";
		data += "패스워드 : " + pw;
		data += "<br>";
		data += "주소 : " + address;
		data += "</body>";
		data += "</html>";
		out.print(data);
	}

}

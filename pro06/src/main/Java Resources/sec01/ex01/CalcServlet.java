package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServlet
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); //서블릿에서 응답할 데이터의 종류가 html임을 웹브라우저에 알려줌
		PrintWriter pw = response.getWriter(); //그 데이터를 웹브라우저에 출력하기 위해 printWriter객체 생성
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won),operator);
			pw.print("<html><font size=10><반환결과></font><br>");
			pw.print("<html><font size=10>" + result + "</font><br>");
			pw.print("<a href = '/pro06/calc'>환율계산기</a>");
			return;
		} //웹브라우저에 데이터를 요청시 데이터가 command의 value값인 calculate로 들어가고있음
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size = 5>환율 계산기</font><br>");
		pw.print("<form name ='frmCalc' method ='get' action = '/pro06/calc'/>");
		pw.print("원화 : <input type = 'text' name='won' size=10/>"); //이름이 won인것을 string won에 받아주고있음 
		pw.print("<select name = 'operator'>"); //이름이 operator인것을 string operator에 받아주고있음 
		pw.print("<option value = 'dollar'>달러</option>");
		pw.print("<option value = 'en'>엔화</option>");
		pw.print("<option value = 'wian'>위안</option>");
		pw.print("<option value = 'pound'>파운드</option>");
		pw.print("<option value = 'euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'/>"); //이름이 command인것을 string command에 받아주고있음
		pw.print("<input type='submit' value='반환'/>");
		pw.print("</form>");
		pw.print("</html>");
		pw.close();

		}
	
	private static String calculate(float won, String operator) {
		String result = null;
		/*if(operator.equals("dollar")) {
			result = String.format("%.6f", won/ USD_RATE);
		} else if(operator.equals("en")) {
			result = String.format("%.6f", won/ JPY_RATE);
		} else if(operator.equals("wian")) {
			result = String.format("%.6f", won/ CNY_RATE);
		} else if(operator.equals("pound")) {
			result = String.format("%.6f", won/ GBP_RATE);
		} else if(operator.equals("euro")) {
			result = String.format("%.6f", won/ EUR_RATE);
		} */
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

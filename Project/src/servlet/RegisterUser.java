
package servlet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;

/**
 * Servlet implementation class RegisterUser
 */

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getSession().getAttribute("userInfo")==null){
		response.sendRedirect("LoginServlet");
		return;
	}



		String forwardPath=null;


			forwardPath="/WEB-INF/jsp/registerForm.jsp";


			RequestDispatcher dispatcher=request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);





	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String pwc=request.getParameter("pwc");
		String birthDate=request.getParameter("birthDate");

		if(id.isEmpty() ||name.isEmpty() ||password.isEmpty()||pwc.isEmpty()||birthDate.isEmpty()||!password.equals(pwc)) {
			request.setAttribute("errMsg", "登録された内容は正しくありません");

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
			dispatcher.forward(request,response);
			return;
		}
		String source = password;
		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";

		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);

		UserDao userDao = new UserDao();
		try {
			userDao.signUp(id, name,result,pwc,birthDate);
		} catch (SQLException e) {
			request.setAttribute("errMsg", "登録された内容は正しくありません");

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/registerForm.jsp");
			dispatcher.forward(request,response);
			return;
		}



		response.sendRedirect("userListServlet");
	}

}




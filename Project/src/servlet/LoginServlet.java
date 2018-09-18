package servlet;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!(request.getSession().getAttribute("userInfo")==null)){
			response.sendRedirect("userListServlet");
			return;
		}

		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");

		dispatcher.forward(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");


		String loginId=request.getParameter("loginId");
		String password=request.getParameter("password");


		String source = password;
		Charset charset = StandardCharsets.UTF_8;
		String algorithm = "MD5";

		byte[] bytes=null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);


		UserDao userDao = new UserDao();
		User user = userDao.findByLoginInfo(loginId, result);

		if(user==null) {
			request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
			dispatcher.forward(request,response);
			return;
		}
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", user);


		response.sendRedirect("userListServlet");
	}
}

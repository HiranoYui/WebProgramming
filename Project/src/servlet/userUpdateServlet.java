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
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class userEditServlet
 */
@WebServlet("/userEditServlet")
public class userUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		if(request.getSession().getAttribute("userInfo")==null){
			response.sendRedirect("LoginServlet");
			return;
		}

		String id = request.getParameter("id");


		//TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
		UserDao userDao = new UserDao();
		User user = userDao.findByid(id);

		request.setAttribute("user", user);

		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/Update.jsp");
		dispatcher.forward(request,response);

		//フォワード

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");


		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String birthDate=request.getParameter("birthDate");
		String id=request.getParameter("id");
		String pwc=request.getParameter("pwc");

		if(id.isEmpty() ||name.isEmpty() ||birthDate.isEmpty()||!password.equals(pwc)) {
			request.setAttribute("errMsg", "登録された内容は正しくありません");

			UserDao userDao = new UserDao();
			User user = userDao.findByid(id);

			request.setAttribute("user", user);

			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/Update.jsp");
			dispatcher.forward(request,response);

			return;
		}

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
		if(password.isEmpty()&&pwc.isEmpty()) {
			userDao.Update(name,birthDate,id);
		} else {
			userDao.Update(name,result,birthDate,id);
		}
		response.sendRedirect("userListServlet");
		}
}

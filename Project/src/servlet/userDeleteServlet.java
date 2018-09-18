package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
/**
 * Servlet implementation class userDeleteServlet
 */
@WebServlet("/userDeleteServlet")
public class userDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDeleteServlet() {
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


		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		//TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
		UserDao userDao = new UserDao();
		User user = userDao.findByid(id);



		request.setAttribute("user", user);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/userDelete.jsp");

		dispatcher.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub

		String id = request.getParameter("id");


		UserDao userDao = new UserDao();
		userDao.Delete(id);


		response.sendRedirect("userListServlet");
	}
}

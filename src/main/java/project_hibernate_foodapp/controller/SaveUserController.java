package project_hibernate_foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import project_hibernate_foodapp.dao.UserDao;
import project_hibernate_foodapp.dto.User;
@WebServlet("/signup")
public class SaveUserController extends HttpServlet {
	static User user;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		user= new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phone);
		user.setRole(address);
		user.setAddress(address);
		
		UserDao dao=new UserDao();
		User user2=dao.saveUser(user);
		if (user2!=null) {
			req.setAttribute("message", "succesfull signed up");
			RequestDispatcher dispatcher=req.getRequestDispatcher("succes.jsp");
			dispatcher.forward(req, resp);
			
		}
	}

}

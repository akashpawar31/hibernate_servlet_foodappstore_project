package project_hibernate_foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project_hibernate_foodapp.dao.FoodOrderDao;
import project_hibernate_foodapp.dao.UserDao;
import project_hibernate_foodapp.dto.FoodOrder;
import project_hibernate_foodapp.dto.Items;
import project_hibernate_foodapp.dto.User;

@WebServlet("/print")
public class PrintController extends HttpServlet {
	static FoodOrder foodOrder = new FoodOrder();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phone"));
		List<Items> items = ConfirmOrderController.list;

		foodOrder.setName(name);
		foodOrder.setEmail(email);
		foodOrder.setAddress(address);
		foodOrder.setPhone(phone);
		foodOrder.setItems(items);
		HttpSession session = req.getSession();
		int id = (Integer) session.getAttribute("id");
		UserDao userDao = new UserDao();
		User user = userDao.getUserById(id);
		foodOrder.setUser(user);

		FoodOrderDao dao = new FoodOrderDao();
		FoodOrder foodOrder2 = dao.saveFoodOrder(foodOrder);
		if (foodOrder2 != null) {
			HttpSession session1 = req.getSession();
			int id1 = (Integer) session1.getAttribute("id");
			if (id1 != 0) {
				req.setAttribute("foodorder", foodOrder2);
				req.setAttribute("message", "Thank You!!! Visit again!!!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("end.jsp");
				dispatcher.forward(req, resp);
			} else {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(req, resp);
			}
		}
	}

}

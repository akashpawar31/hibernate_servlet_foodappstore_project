package project_hibernate_foodapp.controller;

import java.awt.Menu;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project_hibernate_foodapp.dao.MenuDao;
@WebServlet("/update")
public class UpdateMenuController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		MenuDao dao = new MenuDao();
		project_hibernate_foodapp.dto.Menu menu=dao.getMenuById(id);

		if (menu != null) {
			req.setAttribute("menu", menu);
			RequestDispatcher dispatcher = req.getRequestDispatcher("editmenu.jsp");
			dispatcher.forward(req, resp);
		}
	}

}

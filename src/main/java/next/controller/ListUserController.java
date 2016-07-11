package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.db.DataBase;

// @WebServlet("/users")
//public class ListUserController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	@Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		if (!UserSessionUtils.isLogined(req.getSession())) {
//			resp.sendRedirect("/users/loginForm");
//			return;
//		}
//		
//        req.setAttribute("users", DataBase.findAll());
//
//        RequestDispatcher rd = req.getRequestDispatcher("/user/list.jsp");
//        rd.forward(req, resp);
//    }
//}

public class ListUserController implements Controller {

	@Override
	public String execute(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		if (!UserSessionUtils.isLogined(req.getSession())) {
			return "redirect:/users/loginForm";
		}
		
	    req.setAttribute("users", DataBase.findAll());
	
	    return "/user/list.jsp";
	}
	
}
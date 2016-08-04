package next.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// "", "/" 의 차이?
@WebServlet(name = "dispatcher", urlPatterns = {"", "/"}, loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		super.service(req, resp);
		
		try {
			
			System.out.println(req.getRequestURI());
			RequestMapping requestMapping = new RequestMapping();
//			RequestMapping.getController(req.getRequestURI())
//			String url = requestMapping.getController(req.getRequestURI())
			String url = requestMapping.getController(req.getRequestURI())
							.execute(req, resp);
			
			if (url.startsWith("redirect:")) {
				resp.sendRedirect(url.substring("redirect:".length()));
				return;
			}
			
			if (!url.endsWith(".jsp")) {
				url = url + ".jsp";
			}
			
			System.out.println(url);
		    RequestDispatcher rd = req.getRequestDispatcher(url);
	        rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

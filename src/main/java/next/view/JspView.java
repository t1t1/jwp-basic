package next.view;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JspView implements View {
	
	private static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
	
	private String url;
	
	public JspView(String url) {
		this.url = url;
	}

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (url.startsWith(DEFAULT_REDIRECT_PREFIX)) {
			response.sendRedirect(url.substring(DEFAULT_REDIRECT_PREFIX.length()));
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}

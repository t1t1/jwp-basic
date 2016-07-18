package next.view;

import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonView implements View {
	
	public JsonView() {
	}

	@Override
	public void render(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> model = createModel(request);
		
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
	}

	private Map<String, Object> createModel(HttpServletRequest request) {
		Enumeration<String> names = request.getParameterNames();
		Map<String, Object> map = new HashMap<>();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			map.put(name, request.getParameter(name));
		}
		return map;
	}

}

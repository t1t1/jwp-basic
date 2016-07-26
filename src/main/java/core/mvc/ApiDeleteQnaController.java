package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApiDeleteQnaController extends AbstractController {

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String url = CommonDeleteController.delete(request, response);
		
//		ModelAndView mv = jspView(url).addObject("msg", msg);
		ModelAndView mv = jsonView().addObject("url", url);
		
		return mv;		
		
	}

}

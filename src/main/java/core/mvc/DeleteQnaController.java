package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteQnaController extends AbstractController {
	
	private static final Logger log = LoggerFactory.getLogger(DeleteQnaController.class);

	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String url = CommonDeleteController.delete(request, response);
		
//		ModelAndView mv = jspView(url).addObject("msg", msg);
		ModelAndView mv = jspView(url);
		
		return mv;
	}

}

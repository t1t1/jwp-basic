package core.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.QuestionDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateQnaController extends AbstractController {
	
	private static final Logger log = LoggerFactory.getLogger(CreateQnaController.class);
	
	private QuestionDao questionDao = new QuestionDao();
	
	@Override
	public ModelAndView execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		questionDao.insert(writer, title, contents);
		
//		return jspView("/");
		return jspView("redirect:/");
	}

}

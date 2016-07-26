package core.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import next.model.Question;
import next.model.User;

public class CommonDeleteController {
	
	private static final Logger log = LoggerFactory.getLogger(CommonDeleteController.class);
	
	private static QuestionDao questionDao = new QuestionDao();
	
	private static AnswerDao answerDao = new AnswerDao();
	
	protected static String delete(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		boolean canDelete = true;
		String msg = "";
		String url = "";
		
		// getName
		User user = (User) request.getSession().getAttribute("user");
		String name = user.getName();
		
		// questionId
		long questionId = Long.parseLong(request.getParameter("questionId"));
		
		// -- set url
		url = "redirect:/qna/show?questionId=" + questionId;
		
		// question
		Question question = questionDao.findById(questionId);
		if (!name.equals(question.getWriter())) {
			msg = "삭제 불가; 본인 글 아님";
			canDelete = false;
		}
		
		// answers
		List<Answer> answerList = answerDao.findAllByQuestionId(questionId);
		for (Answer answer : answerList) {
			if (!name.equals(answer.getWriter())) {
				msg = "삭제 불가; 타인 답변 존재";
				canDelete = false;
			};
		}
		
		if (canDelete) {
			// 답변 삭제
			for (Answer answer : answerList) {
				answerDao.delete(answer.getAnswerId());
			}
			// 질문 삭제
			questionDao.delete(questionId);
			// url
			url = "redirect:/";
		}
		
		return url;
	}

}

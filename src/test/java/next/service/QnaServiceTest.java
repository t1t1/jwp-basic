package next.service;

import static org.hamcrest. CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;

import next.CannotDeleteException;
import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Question;
import next.model.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class QnaServiceTest {
	
	@Mock
	private QuestionDao questionDao;
	
	@Mock
	private AnswerDao answerDao;

	@InjectMocks
	private QnaService qnaService;
	
	@Test(expected=CannotDeleteException.class)
	public void test_questionIsNull() throws CannotDeleteException {
		Question question = new Question(0001L, "userId", "title", "contents", new Date(), 1);
		User user = new User("userId", "password", "name", "email");
		when(questionDao.findById(anyLong())).thenReturn(null);
		qnaService.deleteQuestion(question.getQuestionId(), user);
	}
	
	@Test(expected=CannotDeleteException.class)
	public void test_youAreNotWriter() throws Exception {
		Question question = new Question(0001L, "userId", "title", "contents", new Date(), 1);
		User user = new User("userId", "password", "name", "email");
		when(question.isSameUser(user)).thenReturn(false); // fail
		qnaService.deleteQuestion(question.getQuestionId(), user);
	}
	
	@Test
	public void test_answersNotExist() throws Exception {
		Question question = new Question(0001L, "userId", "title", "contents", new Date(), 1);
		User user = new User("userId", "password", "name", "email");
		when(answerDao.findAllByQuestionId(anyLong())).thenReturn(null);
		questionDao.delete(question.getQuestionId());
		assertNull(questionDao.findById(question.getQuestionId()));
	}
	

}

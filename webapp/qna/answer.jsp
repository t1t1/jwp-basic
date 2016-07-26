<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="kr">
<head>
    <%@ include file="/include/header.jspf" %>
</head>
<body>
<%@ include file="/include/navigation.jspf" %>

<div class="container" id="main">
            <c:if test="${loginFailed}">
            <div class="alert alert-danger" role="alert">아이디 또는 비밀번호가 틀립니다. 다시 로그인 해주세요.</div>
            </c:if>
			<div class="answerWrite">
                         <form name="answer" method="post">
					<input type="hidden" name="questionId" value="${question.questionId}">
					<div class="form-group col-lg-12">
						<textarea name="contents" id="contents" class="form-control" placeholder=""></textarea>
					</div>
					<input class="btn btn-success pull-right" type="submit" value="수정하기" />
				</form>
			</div>
</div>


<%@ include file="/include/footer.jspf" %>
</body>
</html>

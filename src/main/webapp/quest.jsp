<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Квест</title>
</head>

<body>
<div>
    <h1>${questions.findById(questionId).getQuestionText()}</h1>
    <c:forEach var="idAnswer" items="${questions.findById(questionId).getIdAnswer()}">
        <button onclick="window.location='/quest?click=${idAnswer}'">${answers.findById(idAnswer).getAnswerText()}</button>
        <br>
    </c:forEach>
</div>
</body>
</html>

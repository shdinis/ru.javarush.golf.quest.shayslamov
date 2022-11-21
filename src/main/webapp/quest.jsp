<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Квест</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body background="${questions.findById(questionId).getBackgroundPicture()}">
<div class="d-grid gap-2">
    <div class="text-center"><h1 >${questions.findById(questionId).getQuestionText()}</h1></div>
    <c:forEach var="idAnswer" items="${questions.findById(questionId).getIdAnswer()}">
        <button class="btn btn-outline-light" onclick="window.location='/quest?click=${answers.findById(idAnswer).getNextQuestion()}'">${answers.findById(idAnswer).getAnswerText()}</button>
    </c:forEach>

    <c:if test="${questions.findById(questionId).getIdAnswer().isEmpty()}">
        <button class="btn btn-outline-light" onclick="window.location='/quest?click=1'">Начать с начала</button>
        <button class="btn btn-outline-light" onclick="window.location='/logout'">Log out</button>
    </c:if>
</div>
<div>
    <table></table>
</div>
</body>
</html>

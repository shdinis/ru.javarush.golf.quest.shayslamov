<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Наш квест</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<div class="container col-xxl-8 px-4 py-5">
    <div class="row flex-lg-row-reverse align-items-center g-5 py-5">

        <main class="text-center form-signin w-50 m-auto">
            <div>

                <h1>Приветствие</h1>
<%--                <button onclick="location.href='/login'">Начнем</button>--%>


            </div>
            <form action="login" method="post">
                <c:if test="${sessionScope.user == null}">
                    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>
                </c:if>
                <c:if test="${sessionScope.user != null}">
                    <h1 class="h3 mb-3 fw-normal">Welcome, ${sessionScope.user.login}</h1>
                    <h1 class="h3 mb-3 fw-normal">Role, ${sessionScope.user.role}</h1>
                </c:if>
                <c:if test="${sessionScope.user == null}">
                    <div class="form-floating">
                        <input type="text" class="form-control" name="login" id="floatingInput" placeholder="Username">
                        <label for="floatingInput">Login</label>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" name="password" id="floatingPassword"
                               placeholder="Password">
                        <label for="floatingPassword">Password</label>
                    </div>
                    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                </c:if>
            </form>
        </main>
    </div>
</div>
<%--<div>--%>
<%--    <h1>Добро пожаловать в нашу игру!!!</h1>--%>
<%--</div>--%>

<%--<div>--%>
<%--    <div>--%>
<%--        <button onclick="location.href='/login'">Старт</button>--%>
<%--    </div>--%>
<%--</div>--%>
</body>
</html>
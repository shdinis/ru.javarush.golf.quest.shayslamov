<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <style>
        #footer {
            position: fixed;
            left: 0;
            bottom: 0;
            padding: 10px;
            color: dimgray;
            width: 100%;
        }
    </style>
    <title></title>
</head>
<body>
<div id="footer">
    <section class="info">
        <table class="table">
            <thead>
            <tr class="table-light">
                <th class="text-center" scope="col">Статистика</th>
                <th class="text-center" scope="col">Имя в игре</th>
                <th class="text-center" scope="col">ip address</th>
                <th class="text-center" scope="col">session id</th>
                <th class="text-center" scope="col">Количество игр</th>

            </tr>
            </thead>
            <tbody class="table-group-divider table-info">
            <tr class="table-info">
                <th scope="row" class="text-center">#</th>
                <td class="text-center">${name}</td>
                <td class="text-center">${ip}</td>
                <td class="text-center">${sessionId}</td>
                <td class="text-center">${counter}</td>

            </tr>
            </tbody>
        </table>
    </section>
</div>
</body>
</html>

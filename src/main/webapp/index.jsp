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

                <p class="form-control">Ты проснулся в незнакомом месте. Перед тобой стоит странное существо,
                    говорит что его зовут Ангус, а как тебя зовут:</p>


            </div>
            <form action="quest" method="post">
                <div class="form-floating">
                    <input type="text" class="form-control" name="name" id="floatingInput" placeholder="Name">
                    <label for="floatingInput">Name</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Log in</button>
            </form>
        </main>
    </div>
</div>

</body>
</html>
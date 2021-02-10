<%--
  Created by IntelliJ IDEA.
  User: Developer
  Date: 10.02.2021
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Адресация</title>

</head>

</head>

<body>
    <p class="body">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script>
                $.ajax({
                    url: "http://localhost:8080/getPath",
                    type: "GET",
                    success: function (result) {
                        if(result) {

                        }
                        return false
                    },
                })
    </script>

</body>
</html>

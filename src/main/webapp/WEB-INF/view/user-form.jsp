<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Save User</title>

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-user-style.css">

    <script type="text/javascript">
        $(function() {
            $('#idDateField').datepicker();
        });
    </script>
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>Задание 1. CRUD (create, read, update, delete)</h2>
        </div>
    </div>

    <div id="container">
        <h3>Сохранить пользователя</h3>

        <form:form action="/user/saveUser" modelAttribute="user" method="POST">

            <!-- Need to associate this data with user id -->
            <form:hidden path="id" />

            <table>
                <tbody>
                <tr>
                    <td><label>Имя:</label></td>
                    <td><form:input path="name"></form:input></td>
                </tr>

                <tr>
                    <td><label>Возраст:</label></td>
                    <td><form:input path="age"></form:input></td>
                </tr>

                <tr>
                    <td><label>Администратор:</label></td>
                    <td>
                        <form:select path="isAdmin">
                            <form:option value="1">да</form:option>
                            <form:option value="0">нет</form:option>
                        </form:select>
                    </td>
                </tr>

                <tr>
                    <td><label>Дата создания:</label></td>
                    <td>
                        <form:input path="createdDate"></form:input>
                    </td>
                </tr>

                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Сохранить" class="save" /></td>
                </tr>
                </tbody>
            </table>

        </form:form>

        <div style="clear: both"></div>

        <p>
            <a href="${pageContext.request.contextPath}/user/list">Назад к списку</a>
        </p>

    </div>
</body>
</html>

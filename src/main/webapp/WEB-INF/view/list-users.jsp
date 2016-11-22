<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>List of Users</title>

    <!-- reference to style sheets -->
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"
    />
</head>
<body>
    <div id = "wrapper">
        <div id = "header">
            <h2>Задание 1. CRUD (create, read, update, delete)</h2>
        </div>
    </div>

    <div id = "container">
        <div id = "content">

            <!-- Put new search function -->
            <form action="${pageContext.request.contextPath}/user/list">
                <table>
                    <tr>
                        <td>
                            Фильтр по имени : <input type="text" name="str">
                            <input type="submit" value="Search" class="save">
                        </td>
                    </tr>
                </table>
            </form>

            <!-- Add the table -->
            <table>
                <tr>
                    <th>Имя</th>
                    <th>Возраст</th>
                    <th>Администратор</th>
                    <th>Дата создания</th>
                    <th>Активность</th>
                </tr>

                <c:forEach var="tempUser" items="${users}">

                    <!-- Construct an "Update" link with user id -->
                    <c:url var="updateLink" value="/user/showFormUpdate">
                        <c:param name="userId" value="${tempUser.id}" />
                    </c:url>

                    <!-- Construct an "Delete" link with user id -->
                    <c:url var="deleteLink" value="/user/delete">
                        <c:param name="userId" value="${tempUser.id}" />
                    </c:url>

                    <tr>
                        <td>${tempUser.name}</td>
                        <td>${tempUser.age}</td>
                        <td>${tempUser.isAdmin}</td>
                        <td>${tempUser.createdDate}</td>
                        <td>
                            <a href="${updateLink}">Обновить</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Удалить пользователя?'))) return false">Удалить</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            </br>

            <!-- Put new button: Add User -->
            <input type="button" value="Добавить"
                   onclick="window.location.href='showFormAdd'; return false"
                   class="add-button"
            />

        </div>
    </div>
</body>
</html>

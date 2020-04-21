<%@ page import="modul.dao.OracleDaoConnection" %>
<%@ page import="java.util.List" %>
<%@ page import="modul.model.Questions" %><%--
  Created by IntelliJ IDEA.
  User: New User
  Date: 21.04.2020
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
</head>
<body>
    <%  String name = request.getParameter("name");
        request.getSession().setAttribute("name", name);
        List<Questions> questions = OracleDaoConnection.getInstance().getQuestions();
        request.getSession().setAttribute("questions", questions);
    %>
        <input type="text" name="question" placeholder="type your answer"/>
        Answer
</body>
</html>

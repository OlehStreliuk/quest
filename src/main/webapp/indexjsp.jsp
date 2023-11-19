<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.quest_streliuk.model.Node" %>
<%@ page import="com.example.quest_streliuk.model.Quizzes" %>


<!DOCTYPE html>
<html>
<head>
    <title>Quizzes test</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body class="w3-light-grey">

<c:set var="test" username = ""/>

<form  method="POST" action="/hello-servlet" onsubmit="forward">

    <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
        <%
            String username = request.getParameter("username");
            String answe = (String)request.getAttribute("action_resp");
            if (username == null)
                username = "";
            if (answe!=null) {
                out.println("<h5> Ответить на вопрос: '" + username + answe + "' да/нет!</h5>");
                pageContext.setAttribute("action_resp", answe);
                pageContext.setAttribute("question", "yes");
             }else{

                out.println("<h5> Ответить на вопрос: ' " + username + " Ты потерял память. Принять вызов НЛО?"+ "' да/нет!</h5>");
            }
        %>
    </div>
    <div class="w3-container w3-left">
        <div class="w3-bar w3-padding-large w3-padding-24">

        <br><br>
        <input type="radio" id="contactChoice1" name="question" value="1" />
        <label for="contactChoice1">Да</label>


        <input type="radio" id="contactChoice2" name="question" value="2" />
        <label for="contactChoice2">Нет</label>
        </div>
    </div>

    <br><br>
    <button type="submit">Submit</button>
</form>


</body>
</html>
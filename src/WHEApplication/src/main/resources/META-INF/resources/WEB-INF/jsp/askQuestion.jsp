<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

    <head>
        <title>Ask question</title>
    </head>
    <body>
        <div>Obiekt: ${AskQuestionModel}</div>
        <form method="post">
                <div>${QuestionToAsk}?</div>
                <div>
                    <INPUT TYPE="radio" name="answer" value="NO"/>NO
                    <INPUT TYPE="radio" name="answer" value="YES"/>YES
                </div>
            <input type="submit" value="submit">
            <input type="hidden" name="AskQuestionModel" value="${AskQuestionModel}" />
            <input type="hidden" name="question" value="${QuestionToAsk}" />
        </form>
    </body>


</html>
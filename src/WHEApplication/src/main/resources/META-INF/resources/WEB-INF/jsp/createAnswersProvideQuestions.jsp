<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

    <head>
        <title>Create new answers</title>
    </head>
    <body>
        <div>Provide answers for ${itemname}</div>
        <form method="post">
            <table>
              <c:forEach items="${questions}" var="item" varStatus="loop">
                <div>
                  ${counter} ${item}?:
                  <INPUT TYPE="radio" name="answer${loop.index}" value="NO"/>NO
                  <INPUT TYPE="radio" name="answer${loop.index}" value="YES"/>YES
                  <input type="hidden" name="question${loop.index}" value="${item}" />
                </div>
              </c:forEach>
            </table>
            <input type="submit" value="submit">
        </form>
    </body>


</html>
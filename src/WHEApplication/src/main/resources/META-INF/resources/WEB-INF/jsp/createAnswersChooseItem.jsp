<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

    <head>
        <title>Create new answers</title>
    </head>
    <body>
        For which item do you want to create answers?
        <table>
          <c:forEach items="${list}" var="item">
            <div>
              <form method="get" action="/WiHajstEr/provide/answers"/> <!--action='/WiHajstEr/create/answers/${item}'-->
                  <input type="submit" value="${item}">
                  <input type="hidden" name="itemname" value="${item}" />
              </form>
            </div>
          </c:forEach>
        </table>
    </body>


</html>
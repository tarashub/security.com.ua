<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="template/header.jsp"%>


<form action="/login" method="post">
    <%--Start alert message--%>
    <c:if test="${param.error != null}">
        <%--<div class="alert alert-danger">--%>
        <p>Invalid username and password.</p>
        <%--</div>--%>
    </c:if>
    <c:if test="${param.logout != null}">
        <%--<div class="alert alert-success">--%>
        <p>You have been logged out successfully.</p>
        <%--</div>--%>
    </c:if>
    <%--End alert --%>
    <input type="text" name="username" placeholder="userName" required>
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="log in">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>

</form>


<%@include file="template/footer.jsp"%>
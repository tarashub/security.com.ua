<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@include file="template/header.jsp"%>



<h2>Hello User</h2>

<form action="/save" method="post">
    <input type="text" name="username" placeholder="username" required>
    <input type="text" name="password" placeholder="password" required>
    <input type="text" name="email" placeholder="email" required>
    <input type="submit"  value="save">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>


<input type="hidden"
       name="${_csrf.parameterName}"
       value="${_csrf.token}"/>

<%@include file="template/footer.jsp"%>

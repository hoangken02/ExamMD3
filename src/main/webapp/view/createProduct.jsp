<%--
  Created by IntelliJ IDEA.
  User: MISS NHUNG DESIGN PC
  Date: 15/01/2021
  Time: 3:37 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body background="">
<p>
    <a href="/server">Back to list of products</a>
</p>
<form  action="/server?action=create" method="post">
    <fieldset>
        <legend>Insert Product Info</legend>
        <table class="table table-striped">
            <tr>
                <td>Id:</td>
                <td><input type="text" name="id" id="id"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price:</td>
                <td><input type="text" name="prime" id="prime"></td>
            </tr>
            <tr>
                <td>Quantity:</td>
                <td><input type="text" name="quantity" id="quantity"></td>
            </tr>
            <tr>
                <td>Color:</td>
                <td><input type="text" name="color" id="color"></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><input type="text" name="status" id="status"></td>
            </tr>
                        <tr>
                            <td>Category:</td>
                            <td><select name="category" id="category">
                                <c:forEach items="${categoryList}" var="category">
                                <option value="${category.getCatName()}">${category.getCatName()}</option>
                                </c:forEach>
                            </td>
                        </tr>
        </table>

        <input type="submit" class="btn btn-danger" value="Create Product">
    </fieldset>
</form>
</body>
</html>


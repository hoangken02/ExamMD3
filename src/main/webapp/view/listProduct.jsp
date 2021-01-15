<%--
  Created by IntelliJ IDEA.
  User: MISS NHUNG DESIGN PC
  Date: 15/01/2021
  Time: 3:38 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <style>
        table {
            border: solid 1px;
            border-collapse: collapse;
            padding: 5px;
        }

        th, tr, td {
            border: solid 1px;
            border-collapse: collapse;
            padding: 5px;
        }

        .myButton {
            background-color: #44c767;
            border-radius: 28px;
            border: 1px solid #18ab29;
            display: inline-block;
            cursor: pointer;
            color: #ffffff;
            font-family: Arial;
            font-size: 17px;
            padding: 2px 31px;
            text-decoration: none;
            text-shadow: 0px 1px 0px #2f6627;
        }

        .myButton:hover {
            background-color: #5cbf2a;
        }

        .myButton:active {
            position: relative;
            top: 1px;
        }


    </style>
    <style type="text/css">
        h1 {
            color: red;
        }

        p {
            color: black;
        }
    </style>

</head>
<body>

<p>
    <a href="/server?action=create" class="btn btn-danger">Create Product</a>
</p>
<form action="/server?action=search" method="post">
    <input type="text/css" placeholder="Search here" name="search" id="search" h>
    <input type="submit" value="Search" class="myButton">
</form>
<table class="table table-striped table-hover">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Status</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td><c:out value="${product.getId()}"></c:out></td>
            <td><c:out value="${product.getName()}"></c:out></td>
            <td><c:out value="${product.getPrice()}"></c:out></td>
            <td><c:out value="${product.getQuantity()}"></c:out></td>
            <td><c:out value="${product.getColor()}"></c:out></td>
            <td><c:out value="${product.getStatus()}"></c:out></td>
            <td><c:out value="${product.getCategory()}"></c:out></td>
            <td>
                <a href="/server?action=edit&id=${product.getId()}" class="btn btn-warning">Edit</a>
                <a href="/server?action=delete&id=${product.getId()}" class="btn btn-success">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


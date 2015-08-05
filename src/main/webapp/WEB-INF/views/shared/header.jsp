<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <script src="https://code.jquery.com/jquery-latest.js"></script>
  <link rel="stylesheet" href="<c:url value="/resources/bootstrap-3.3.5/css/bootstrap.css"/> ">
  <script type="text/javascript" src="<c:url value="/resources/bootstrap-3.3.5/js/bootstrap.js"/>"></script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="nav nav-pills">
        <li role="presentation" id="menu_item_index"><a href="<c:url value="/" />">Home</a></li>
        <li role="presentation" id="menu_item_persons"><a href="<c:url value="/persons" />">Persons List</a></li>
        <li role="presentation" id="menu_item_add_person"><a href="<c:url value="/persons/add" />">Add Person</a></li>
      </div>
    </div>
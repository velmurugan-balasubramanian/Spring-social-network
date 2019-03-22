<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="spring Boot Social Network">
<meta name="author" content="Velmurugan">
<title><tiles:insertAttribute name="title" /></title>
<link href="/css/bootstrap.css" rel="stylesheet">
<link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <header>
            <div class="container">
                <tiles:insertAttribute name="navbar" />
            </div>
    </header>

	
	<main class="main">
	   <tiles:insertAttribute name="content" />
	</main>
	
	
	<script src="/js/jquery.js"></script>
	<script src="/js/bootstrap.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h3>Add status</h3>

<div class="jumbotron">
	<form:form method="POST" modelAttribute="statusUpdate">
		<div class="form-group">
			<h3>Add Status</h3>
			<form:textarea path="text" class="form-control" rows="5" id="comment"></form:textarea>
		</div>
		<form:button type="submit" class="btn btn-primary">Add Status</form:button>
	</form:form>
</div>

<div>
	<h3>${latestStatus.dateAdded}</h3>
	<h3>${latestStatus.text}</h3>

</div>
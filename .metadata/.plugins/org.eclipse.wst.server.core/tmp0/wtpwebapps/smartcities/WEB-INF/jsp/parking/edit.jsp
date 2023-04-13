<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:template title="Parking edit">

	<h1>Edit Parking</h1>
	${msg }
	<c:url value="/parking/edit" var="action"/>
	<form:form action="${action }" method="post" commandName="parking">
		<form:hidden path="code"/>
		<div class="form-group">
			<form:label path="parkingName">name</form:label>
			<form:input path="parkingName" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="address">Address</form:label>
			<form:input path="address" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="parkingSpaces">Parking Spaces</form:label>
			<form:input path="parkingSpaces" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="price">Price</form:label>
			<form:input path="price" cssClass="form-control"/>
		</div>
		<input type="submit" value="Save" class="btn btn-primary">
		<c:url value="/parking/listAll" var="link"/>
		<a href="${link }" class="btn btn-danger">Cancel</a>
	</form:form>

</tags:template>
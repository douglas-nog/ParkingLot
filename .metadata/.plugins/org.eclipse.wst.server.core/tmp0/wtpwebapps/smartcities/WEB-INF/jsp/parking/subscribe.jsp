<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:template title="Parking Lot Subscribe">
	<h1>Register Parking</h1>
	<c:url value="/parking/subscribe" var="action" />
	<form:form action="${action }" method="post" commandName="parking">
		<div class="form-group">
			<form:label path="parkingName">Parking name</form:label>
			<form:input path="parkingName" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="address">Address</form:label>
			<form:input path="address" cssClass="form-control" />
		</div>
		<div class="form-group">
			<form:label path="parkingSpaces">Parking spaces</form:label>
			<form:input path="parkingSpaces" cssClass="form-control"/>
		</div>
		<div class="form-group">
			<form:label path="price">Price</form:label>
			<form:input path="price" cssClass="form-control"/>
		</div>
		<input type="submit" value="Subscribe" class="btn btn-primary">
	</form:form>
	${msg }
</tags:template>

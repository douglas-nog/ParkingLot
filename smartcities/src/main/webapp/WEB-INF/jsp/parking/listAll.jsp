<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:template title="Parking Lot Register">
	<h1>Registred Parking Lots</h1>
	<h2>${msg }</h2>
	<table class="table">
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>Parking Spaces</th>
			<th>Price</th>
			<th></th>
		</tr>
		<c:forEach items="${parkings }" var="p">
			<tr>
				<td>${p.parkingName }</td>
				<td>${p.address }</td>
				<td>${p.parkingSpaces }</td>
				<td>${p.price }</td>
				<td>
					<c:url value="/parking/edit/${p.code}" var="link"></c:url>
					<a href="${link }" class="btn btn-primary btn-sm">Edit</a>
					<button type="button" onclick="code.value = ${p.code}" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#DeleteModal">
	 					Delete
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<!-- Modal -->
	<div class="modal fade" id="DeleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        Do you really want to remove parking?
	      </div>
	      <div class="modal-footer">
	      	<c:url value="/parking/delete" var="action"/>
	      	<form action="${action }" method="post">
	      		<input type="hidden" name="code" id="code">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
		        <button type="submit" class="btn btn-danger">Delete</button>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
</tags:template>
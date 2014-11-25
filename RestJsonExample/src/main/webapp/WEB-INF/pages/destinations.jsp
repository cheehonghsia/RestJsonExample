<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Destination Finder Service</title>
		
		
		<script>
			function validateForm() {
    		var origin = document.forms["form"]["originCode"].value;
    		var pos = document.forms["form"]["pointOfSaleCode"].value;
    		var minBudget = document.forms["form"]["minBudget"].value;
    		var maxBudget = document.forms["form"]["maxBudget"].value;
    		if ((origin==null || origin=="") || (pos==null || pos=="") ||(minBudget==null || minBudget=="") ||(maxBudget==null || maxBudget=="")) {
        		alert("All fields are mandatory");
        		return false;
    			}
			}
		</script>
		
	</head>

	<body>

    	<h1>Client side destination-finder implementation.</h1>

		<form:form role="form" name="form" method="post" commandName="destinationSearchObject" onsubmit="return validateForm()">
			<table>
				<tbody>
					<tr>
						<td>Origin code</td>
						<td>:</td>
						<td><form:input type="text" class="form-control" size="20" name="originCode" path="originCode" id="originCode"/></td>
					<tr>
						<td>Point of sale</td>
						<td>:</td>
						<td><form:input type="text" size="20" name="pointOfSaleCode" path="pointOfSaleCode" id="pointOfSaleCode"/></td>
					</tr>
					<tr>
						<td>Minimum budget</td>
						<td>:</td>
						<td><form:input type="text" size="20" name="minBudget" path="minBudget" id="minBudget"/></td>
					</tr>
					<tr>
						<td>Maximum budget</td>
						<td>:</td>
						<td><form:input type="text" cols="20" name="maxBudget" path="maxBudget" id="maxBudget"/></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td><input type="submit" name="submit" value="Search">
							<input type="reset" value="Reset"></td>
					</tr>
				</tbody>
			</table>
		</form:form>


		<c:forEach items="${destinations}" var="destinations">
			<table border="0">
				<tr>
					<td>${destinations.destination.description}</td>
					<td>${destinations.lowestFare.currency} ${destinations.lowestFare.value}</td>
				</tr>
			</table>
		</c:forEach>
	</body>
</html>
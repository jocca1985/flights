<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>

<link type="text/css" rel="stylesheet"
	href="<c:url value='/resources/css/ui-lightness/jquery-ui-1.10.3.custom.css' />" />

<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-1.9.1.js'/>"></script>
<script src="<c:url value='/resources/js/main.js' />"></script>
<script
	src="<c:url value='/resources/js/jquery-ui-1.10.3.custom.min.js' />"></script>
<title>Flight search</title>
</head>
<body>
	<h1>Flight search</h1>

	<form:form action="searchFlights" modelAttribute="searchFlights" >
		<table>
			<tr>
				<td>Enter departure date:</td>
				<td><form:input type="text" class="datepicker" path="departureDate" /></td>
			</tr>
			<tr>
				<td>Enter airport departure name:</td>
				<td><form:input class="ui-autocomplete-input"
						autocomplete="off" id="date" path="airportDepartureName" /></td>
			</tr>
			<tr>
				<td>Enter arrival date:</td>
				<td><form:input type="text" name="date" class="datepicker"
						path="arrivalDate" /></td>
			</tr>
			<tr>
				<td>Enter airport arrival name:</td>
				<td><form:input class="ui-autocomplete-input"
						autocomplete="off" id="date" path="airportArrivalName" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Send" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>

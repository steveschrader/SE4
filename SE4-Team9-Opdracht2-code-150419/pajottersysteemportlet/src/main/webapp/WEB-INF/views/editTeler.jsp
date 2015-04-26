<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Pajottersapplicatie</title>
    </head>
<body>
	<h1>Teler bewerken</h1>
	
	<portlet:actionURL var="updateTelerActionUrl">
			<portlet:param name="myaction" value="telerUpdate" />
	</portlet:actionURL>
	<form:form method="post" commandName="teler" action="${updateTelerActionUrl}">
		<table>
			<tbody>
				<tr>
					<td>ID:</td>
					<td><form:input path="id"></form:input></td>
				</tr>
				<tr>
					<td>Naam:</td>
					<td><form:input path="voornaam" /></td>
				</tr>
				<tr>
					<td>Familienaam:</td>
					<td><form:input path="familienaam" /></td>
				</tr>
				
				<tr>
					<td>Emailadres:</td>
					<td><form:input path="emailadres" /></td>
				</tr>
				<tr>
					<td>Adres:</td>
					<td><form:input path="adres" /></td>
				</tr>
				<tr>
					<td>Telefoon:</td>
					<td><form:input path="telefoon" /></td>
				</tr>
				<tr>
					<td>Paswoord:</td>
					<td><form:input path="paswoord" /></td>
				</tr>
				<tr>
					<td><input name="submit" type="submit" value="Opslaan" /></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	
	
	
	<portlet:renderURL var="showUrl">
			<portlet:param name="myaction" value="" />
 	</portlet:renderURL>
 		
        <a href='<c:out value="${showUrl}"/>'>Home</a>
</body>
</html>

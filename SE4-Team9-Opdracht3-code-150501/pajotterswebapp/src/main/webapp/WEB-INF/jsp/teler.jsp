<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teler details - Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Details van teler</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<table>
		        	<tr>
		        		<td><b>ID:</b></td> <td><c:out value="${teler.id}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Voornaam:</b></td> <td><c:out value="${teler.voornaam}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Familienaam:</b></td> <td><c:out value="${teler.familienaam}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>E-mailadres:</b></td> <td><c:out value="${teler.emailadres}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Adres:</b></td> <td><c:out value="${teler.adres}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Telefoon:</b></td> <td><c:out value="${teler.telefoon}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Paswoord:</b></td> <td><c:out value="${teler.paswoord}"/></td>
		        	</tr>
		        </table>
		        
		        <c:url var="VerwijdertelerUrl" value="/verwijderTeler.html">
					<c:param name="id" value="${teler.id}" />
		        </c:url>
		        
		        <c:url var="home" value="/home.html" />
		        
		        <c:url var="updatetelerUrl" value="/updateTeler.html">
					<c:param name="id" value="${teler.id}" />
		        </c:url>
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${home}"/>'>Home</a>
			        <a class="knop" href='<c:out value="${updatetelerUrl}"/>'>Bewerk teler</a>
			        <a class="knop" href='<c:out value="${VerwijdertelerUrl}"/>'>Verwijder teler</a>
				</div>
			</div>
		</div>
    </body>
</html>

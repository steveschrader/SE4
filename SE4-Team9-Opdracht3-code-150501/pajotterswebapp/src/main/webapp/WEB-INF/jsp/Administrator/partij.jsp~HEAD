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
				<h1>Details van partij</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<table>
		        	<tr>
		        		<td><b>ID:</b></td> <td><c:out value="${partij.id}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Voornaam:</b></td> <td><c:out value="${partij.voornaam}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Familienaam:</b></td> <td><c:out value="${partij.familienaam}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>E-mailadres:</b></td> <td><c:out value="${partij.emailadres}"/></td>
		        	</tr>
		        	
		        	<tr>
		        		<td><b>Paswoord:</b></td> <td><c:out value="${partij.paswoord}"/></td>
		        	</tr>
		        	<tr>
		        	<td><b>Rol:</b></td> <td><c:out value="${rol.getType()}"/></td>
		        	</tr>
		        	
		        </table>
		        
		        <c:url var="VerwijderpartijUrl" value="/verwijderPartij.html">
					<c:param name="id" value="${partij.id}" />
		        </c:url>
		        
		        <c:url var="home" value="/home.html" />
		        
		        <c:url var="updatepartijUrl" value="/updatePartij.html">
					<c:param name="id" value="${partij.id}" />
		        </c:url>
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${home}"/>'>Home</a>
			        <a class="knop" href='<c:out value="${updatepartijUrl}"/>'>Bewerk partij</a>
			        <a class="knop" href='<c:out value="${VerwijderpartijUrl}"/>'>Verwijder partij</a>
				</div>
			</div>
		</div>
    </body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productie details - Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Details van de Vraag Pajotter</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<table>
		        	<tr>
		        		<td><b>ID:</b></td> <td><c:out value="${vraag.id}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Vraag:</b></td> <td><c:out value="${vraag.tekst}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Antwoord:</b></td>
		        		<td><c:out value="${antwoord.tekst}"/></td>
		        	</tr>
		        	
		        	
		        	
		        	
		        </table>
		        
		        <c:url var="VerwijdervraagUrl" value="/Pajotter/verwijderVraag.html">
					<c:param name="id" value="${vraag.id}" />
		        </c:url>
		        
		        <c:url var="home" value="/Pajotter/vraagLijst.html" />
		        
		        <c:url var="beantwoordvraagUrl" value="/Pajotter/beantwoordVraag.html">
					<c:param name="id" value="${vraag.id}" />
		        </c:url>
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${home}"/>'>Terug</a>
			        <a class="knop" href='<c:out value="${beantwoordvraagUrl}"/>'>Beantwoord Vraag</a>
			        
				</div>
			</div>
		</div>
    </body>
</html>

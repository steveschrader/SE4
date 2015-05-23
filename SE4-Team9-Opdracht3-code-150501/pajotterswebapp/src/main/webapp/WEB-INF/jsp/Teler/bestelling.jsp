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
				<h1>Details van de aanbieding</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<table>
		        	<tr>
		        		<td><b>ID:</b></td> <td><c:out value="${aanbieding.id}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Aangeboden aanbieding:</b></td> <td><c:out value="${aanbieding.tekst}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Aantal:</b></td> <td><c:out value="${aanbieding.aantal}"/></td>
		        	</tr>
		        	
		        	
		        </table>
		        
		        <c:url var="VerwijderaanbiedingUrl" value="/Leverancier/verwijderAanbieding.html">
					<c:param name="id" value="${aanbieding.id}" />
		        </c:url>
		        
		        <c:url var="home" value="/Leverancier/aanbiedingLijst.html" />
		        
		        <c:url var="updateaanbiedingUrl" value="/Leverancier/updateAanbieding.html">
					<c:param name="id" value="${aanbieding.id}" />
		        </c:url>
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${home}"/>'>Terug</a>
			        <a class="knop" href='<c:out value="${updateaanbiedingUrl}"/>'>Bewerk Aanbieding</a>
			        <a class="knop" href='<c:out value="${VerwijderaanbiedingUrl}"/>'>Verwijder Aanbieding</a>
				</div>
			</div>
		</div>
    </body>
</html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Lijst van de verschillende aanbiedingen</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<ul>
		            <c:forEach items="${aanbieding}" var="aanbieding">
		                <c:url var="aanbiedingUrl" value="/Leverancier/aanbieding.html">
		                    <c:param name="id" value="${aanbieding.id}" />
		                </c:url>
		                <li>
		                    <a href='<c:out value="${aanbiedingUrl}"/>'>
		                        <c:out value="${aanbieding.aantal}" />
		                        <c:out value="${aanbieding.tekst}" />
		                        
		                    </a>
		                </li>
		            </c:forEach>
		        </ul>
		        <c:url var="nieuweAanbiedingUrl" value="nieuweAanbieding.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${nieuweAanbiedingUrl}"/>'>Aanbieding Toevoegen</a>
		        </div>
			</div>
		</div>
    </body>
</html>

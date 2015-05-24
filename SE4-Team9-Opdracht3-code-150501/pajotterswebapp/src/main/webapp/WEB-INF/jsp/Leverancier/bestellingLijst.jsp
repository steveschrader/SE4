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
				<h1>Lijst van de verschillende bestellingen</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<ul>
		            <c:forEach items="${bestelling}" var="bestelling">
		                <c:url var="bestellingUrl" value="/Teler/bestelling.html">
		                    <c:param name="id" value="${bestelling.id}" />
		                </c:url>
		                <li>
		                    <a href='<c:out value="${bestellingUrl}"/>'>
		                        <c:out value="${bestelling.aantal}" />
		                        <c:out value="${bestelling.tekst}" />
		                    
		                        
		                        
		                    </a>
		                </li>
		            </c:forEach>
		        </ul>
		        <c:url var="nieuweBestellingUrl" value="nieuweBestelling.html" />
		        
		        <c:url var="index" value="/Leverancier/index.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${index}"/>'>Terug</a>
		        </div>
			</div>
		</div>
    </body>
</html>

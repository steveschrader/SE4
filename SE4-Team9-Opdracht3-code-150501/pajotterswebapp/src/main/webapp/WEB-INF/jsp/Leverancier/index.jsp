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
				<h1>Welkom Leverancier</h1>
				<h4>Hier kan u de verschillende opties waartoe u recht heeft bezien</h4>
				
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				
		        <c:url var="Aanbieding" value="/Leverancier/aanbiedingLijst.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${Aanbieding}"/>'>Aanbieding beheren</a>
		        </div>
		        
		           <c:url var="Bestelling" value="/Leverancier/bestellingLijst.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${Bestelling}"/>'>Bestellingen beheren</a>
		        </div>
		        
		        <form class="form-inline" action="/Pajotters/logout" method="post">
					<input type="submit" value="Log out" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			    </form>
			</div>
		</div>
    </body>
</html>

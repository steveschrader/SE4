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
				<h1>Lijst van de verschillende Vragen</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<ul>
		            <c:forEach items="${vraag}" var="vraag">
		                <c:url var="vraagUrl" value="/Pajotter/vraag.html">
		                    <c:param name="id" value="${vraag.id}" />
		                </c:url>
		                <li>
		                    <a href='<c:out value="${vraagUrl}"/>'>
		                        <c:out value="${vraag.tekst}" />
		                        
		                    </a>
		                </li>
		            </c:forEach>
		        </ul>
		        
		        </div>
		              <form class="form-inline" action="/Pajotters/logout" method="post">
					<input type="submit" value="Log out" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			    </form>
			</div>
		</div>
    </body>
</html>

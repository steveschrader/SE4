<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Kies uw Rol aub</h1>
        Welkom <c:out value="${persoon.voornaam}" /> <c:out value="${persoon.familienaam}" />,
        kies uw rol aub:
        <ul>
            <c:forEach items="${persoon.rollen}" var="rol">
                <c:url var="rolUrl" value="/rol.html">
                    <c:param name="id" value="${rol.id}" />
                </c:url>
                <li>
                    <a href='<c:out value="${rolUrl}"/>'>
                        <c:out value="${rol.type}" />
                    </a>
                </li>
            </c:forEach>
        </ul>
        <c:url var="logoutUrl" value="/logout" />
	    <form class="form-inline" action="${logoutUrl}" method="post">
	      <input type="submit" value="Log out" />
	      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    </form>    
    </body>
</html>

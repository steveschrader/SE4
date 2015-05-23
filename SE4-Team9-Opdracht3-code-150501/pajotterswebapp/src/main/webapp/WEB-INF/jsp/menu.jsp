<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de pajottersapplicatie</title>
    </head>
    
    <body>
        <h1>Kies uw Rol aub</h1>
        Welkom <c:out value="${partij.voornaam}" /> <c:out value="${partij.familienaam}" />,
        kies uw rol aub:
        <ul>
           
        </ul>
        <c:url var="logoutUrl" value="/logout" />
	    <form class="form-inline" action="${logoutUrl}" method="post">
	      <input type="submit" value="Log out" />
	      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	    </form>    
    </body>
</html>

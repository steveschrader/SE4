body {
	padding: 0;
	margin: 0;
	font-family: Arial, sans-serif;
	font-weight: normal;
	font-style: normal;
	color: rgb(60,60,60);
}

#BovenPaneel {
	border-bottom: #00FFFF 3px solid;
	background-color: #EEFFFF;
	overflow: hidden;
}

#Titel {
	/*background-color: green;*/
	overflow: hidden;
}

#MiddenPaneel {
	overflow: hidden;
}

#Inhoud {
	background-color: white;
	overflow: hidden;
	box-shadow: 0px 0px 20px 3px #D3D3D3;
	padding-bottom: 3em;
	padding-top: 2em;
	margin-bottom: 200px;
}

#Titel, #Inhoud {
	max-width: 1024px;
	margin-left: auto;
	margin-right: auto;
	padding-left: 2.5em;
	padding-right: 2.5em;
}

h1 {
	padding: 0;
	margin: 0.7em 0 0.3em 0;
	font-weight: normal;
	font-family: Arial, sans-serif;
	font-size: 350%;
}

h2 {
	padding: 0 0 0.2em 0;
	margin: 1em 0 0.6em 0;
	font-family: Arial, sans-serif;
	font-weight: normal;
	font-size: 200%;
	border-bottom: 1px solid rgb(60,60,60);
}

p {
	line-height: 150%;
	margin: 0 0 0.7em 0;
}

.code {
	font-family: Consolas, "Courier New", monospace;
	color: #006666;
	margin-left: 2em;
	display: block;
}

.opdracht, .inleiding {
	font-style: italic;
	font-weight: bold;
}

.knoppenpaneel {
	margin-top: 2em;
	overflow: hidden;
	margin-bottom: 2em;
}

.knop {
	background-color: #EEFFFF;
	padding: 0.5em;
	border-bottom: #00FFFF 3px solid;
	border-top: none;
	border-left: none;
	border-right: none;
	text-decoration: none;
	text-decoration: none;
	color: inherit;
	font-family: inherit;
	font-size: inherit;
	font-weight: bold;
	margin-right: 0.3em;
	float: left;
}

.knop:hover, .knop:focus {
	background-color: #DDEEEE;
	border-color: #00AAAA;
}

label {
	font-weight: bold;
}

errortekst {
	color: red;
	font-weight: bold;
}

ul {
	list-style: none;
	/*border: 3px solid #00FFFF;*/
	background-color: #EEFFFF;
	margin: 0;
	padding: 0;
}

li {
	margin: 0;
	border-bottom: 1px solid #00FFFF;
}

a {
	
}
a:hover, a:focus {
	background-color: #DDEEEE;
}

li a {
	padding: 0.5em;
	text-decoration: none;
	color: inherit;
	display: block;
}
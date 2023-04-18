<%-- 
    Document   : VerificarCompra
    Created on : 22 nov 2022, 11:48:50
    Author     : JUNIOR-PC
--%>

<%@page import="java.util.concurrent.TimeUnit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verificar</title>
        <!-- bootstrap css-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- fonts style -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet"> <!-- range slider -->
        <!-- font awesome style -->
        <script src="https://use.fontawesome.com/8fe783cf35.js"></script>
        <!-- Custom styles for this template -->
        <link href="css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />

    </head>
    <body>
        <%@ include file="header/header.jsp"%>
        

        <div class="container p-4"> 
            <h1> Busqueda </h1>
        <div class="input-group mb-3">
            <span class="input-group-text" id="inputGroup-sizing-default">Serie y Numero de Boleta: </span>
            
            <div id="element"></div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text" id="inputGroup-sizing-default">El ID del cliente es:   </span>
           
            <div id="element2"></div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text" id="inputGroup-sizing-default">Fecha de emision: </span>
            
            <div id="element3"></div>
        </div>
        
        <div class="input-group mb-3">
            <span class="input-group-text" id="inputGroup-sizing-default">El id de la transacción es:   </span>
            
            <div id="element4"></div>
        </div>
            
            <form>
            <input type="text" class="form-control" name="txttxrid"  placeholder="Ingrese el ID de su transacción (txrid)">
            <input type="submit" class="btn btn-primary mb-3" name="Busqueda">

        </form>
</div>
        
        


        <%            if (request.getParameter("Busqueda") != null) {
        %>




        <script>

            var xhr = new XMLHttpRequest();
            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    
                    var data = JSON.parse(this.responseText);
                    console.log(this.responseText);
                    document.getElementById('element').innerHTML = data.credentialSubject["SerieyNumeroBolventa"];
                    document.getElementById('element2').innerHTML = data.credentialSubject["DniCliente"];
                    document.getElementById('element3').innerHTML = data.credentialSubject["Fechaemision"];
                    document.getElementById('element4').innerHTML = data.credentialStatus["id"];
                }

            });
            xhr.open("GET", "https://api.stamping.io/credential/get/?trxid=<%=request.getParameter("txttxrid").trim() %>&mode=json");

            xhr.send();

        </script>



        <%    }
        %>


    </body>
</html>

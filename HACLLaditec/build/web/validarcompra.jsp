<%-- 
    Document   : validarcompra
    Created on : 26 nov 2022, 20:25:49
    Author     : JUNIOR-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*"%>
<%@page import="ModeloDAO.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laditec</title>
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

        

        <%            PedidoVenta entped = new PedidoVenta();
            PedidoVentaDAO negped = new PedidoVentaDAO();

            entped.setIdpedido((Integer) sesion.getAttribute("idpedido"));


        %>


        <%            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("txrid")) {
                        entped.setTxrid(c.getValue());
        %>
        
        <div class="container p-4"> 
           <h1>Su Compra se Añadio con exito</h1>
        <div class="input-group mb-3">
            <span class="input-group-text" id="inputGroup-sizing-default">El TxrId de su pedido es: </span>
            <%=c.getValue()%>
        </div>
            
        
        
        <br>
        <%
            }
            if (c.getName().equals("hash")) {
                entped.setHash(c.getValue());
        %>
        
        
        <div class="input-group mb-3">
            <span class="input-group-text" id="inputGroup-sizing-default">El hash de su pedido es: </span>
            <%=c.getValue()%>
        </div>
        
        <br>
        <%
            }
                    

                }

                negped.mtdAsignarHash(entped);

            }


        %>

        <div class="nuevo">
            <a href="Controlador?accion=AgregarComentarios"> <i class="fa fa-plus-circle text-center"></i>¿Desea Agregar algún Comentario?</a><br><br>

        </div>
        </div>

    </body>
</html>

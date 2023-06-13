<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@page import ="Modelo.PedidoVenta"%>
<%@page import ="ModeloDAO.PedidoVentaDAO"%>

<%-- Inicio por Helbert--%>

<!DOCTYPE html>
<html>
    <head>  
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>LADITEC</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <!-- Choices.js-->
        <!-- Google fonts - Muli-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:300,400,700">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/header.css" id="theme-stylesheet"> 
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/tablas.css"> <!-- para agregar -->
        <!-- Font Awesome -->
        <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet'>
    </head>
    <body>
        <%@ include file="../header/header2.jsp"%>

        
        <!------------------------------------------------- INICIO CONTENIDO ------------------------------------------------------------->

        <div class="page-content form-page">
            <!-- Page Header-->            
            <!-- Breadcrumb-->
            <div class="container-fluid py-2">

                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb mb-0 py-3 px-0">
                        <li class="breadcrumb-item"><a href="cruds.jsp">Tablas</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Pedidos</li>
                    </ol>
                </nav>
            </div>

            <section class="tables py-0">
                <div class="container-fluid">
                    <div class="col-lg-12">
                        <div class="card mb-0">
                            <div class="card-header">
                                <h2 class="h2 mb-0 text-center">Pedido</h2>
                            </div>
                            <div class="card-body pt-0">
                                <div class="table-responsive">
                                    <div class="nuevo">
                                        <a href="Controlador?accion=AgregarPedido"> <i class="fa fa-plus-circle"></i> Agregar Pedido</a><br><br>

                                    </div>
                                    <table class="table mb-0 table-striped table-hover">

                                        <thead>
                                            <tr>

                                                <th>idPedidoVenta</th>
                                                <th>fkidusuario</th>
                                                <th>Fecha</th>
                                                <th>Estado</th>
                                                <th>txrid</th>
                                                <th>Operaciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                                                                           
                                            <%
                                                PedidoVentaDAO dao = new PedidoVentaDAO();
                                                List<PedidoVenta> list = dao.listar();
                                                Iterator<PedidoVenta> iter = list.iterator();
                                                        
                                                PedidoVenta ped = null;
                                                while (iter.hasNext()) {
                                                    ped = iter.next();
                                            %>

                                            <tr>
                                                <td> <%=ped.getIdpedido()%>   </td>
                                                <td> <%=ped.getIdusuario()%>   </td>
                                                <td> <%=ped.getFecha()%>   </td>
                                                <td> <%=ped.getEstado()%>   </td>
                                                <td> <%=ped.getTxrid()%>   </td>
                                                




                                                <td>
                                                    <a href="Controlador?accion=EditarPedido&txtid=<%=ped.getIdpedido()%> "><i class="fa fa-pencil-square-o icon-lg"></i></a>
                                                </td>

                                            </tr>
                                            <%}%>

                                        </tbody>





                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
        </div>



        <!-- Main File-->
        <script src="js/front.js"></script>
    </body>
</html><%-- Fin por Helbert--%>
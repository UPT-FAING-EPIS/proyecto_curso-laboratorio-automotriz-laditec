

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@page import ="Modelo.BoletaVenta"%>
<%@page import ="ModeloDAO.BoletaVentaDAO"%>
<%@page import="ModeloDAO.DetalleBolVentaDAO"%>
<%@page import="Modelo.DetalleBolVenta"%>
<!DOCTYPE html>
<html>
    <head>  
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>LADITEC</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <!-- Modal boostrap-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
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
                                <h2 class="h2 mb-0 text-center">Boleta Venta</h2>
                            </div>
                            <div class="card-body pt-0">
                                <div class="table-responsive">
                                    <div class="nuevo">
                                        <a href="Controlador?accion=ListarDetalleBolVenta"> <i class="fa fa-plus-circle"></i> Ver todos los detalles</a><br><br>

                                    </div>
                                    <table class="table mb-0 table-striped table-hover">

                                        <thead>
                                            <tr>

                                                <th>NroBoleta</th>
                                                <th>SerieBoleta</th>
                                                <th>FkIdPedido</th>
                                                <th>FechaEmision</th>
                                                <th>Total</th>
                                                <th>Impuesto</th>
                                                <th>Operaciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <%
                                                BoletaVentaDAO daobol = new BoletaVentaDAO();
                                                List<BoletaVenta> list = daobol.listar();
                                                Iterator<BoletaVenta> iter = list.iterator();

                                                BoletaVenta bol = null;
                                                while (iter.hasNext()) {
                                                    bol = iter.next();
                                            %>

                                            <tr>
                                                <td> <%=bol.getNroboleta()%>   </td>
                                                <td> <%=bol.getSerieboleta()%>   </td>
                                                <td> <%=bol.getFkidpedido()%>   </td>
                                                <td> <%=bol.getFechaemision()%> </td>
                                                <td> <%=bol.getTotal()%></td>
                                                <td> <%=bol.getImpuesto()%></td>
                                                <td>
                                                    <form action="Controlador" class="form-horizontal">
                                                        <input type="hidden" name="txtNroBol" value="<%=bol.getSerieboleta()%>">
                                                        <input type="hidden" name="txtSerieBol" value="<%=bol.getNroboleta()%>">
                                                        <input type="hidden" name="accion"  value="VerPedidosBoleta2">
                                                        <input type="submit" name="VerPedidosBoletaDB"><i class="fa fa-eye icon-lg"></i>
                                                    </form>
                                                </td>

                                            </tr>
                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>




                                    <div class="m-4">
                                        <div id="modalScrollableCenter" class="modal fade" tabindex="-1">
                                            <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title">Detalle de la boleta</h5>
                                                    </div>
                                                    <div class="modal-body">
                                                        <table class="table mb-0 table-striped table-hover">
                                                            <thead>
                                                                <tr>
                                                                    <th>ID</th>
                                                                    <th>IdRepuesto</th>
                                                                    <th>Cantidad</th>
                                                                    <th>Importe</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>

                                                                <%
                                                                    if (request.getParameter("VerPedidosBoletaDB") != null) {
                                                                        DetalleBolVentaDAO vdao = new DetalleBolVentaDAO();

                                                                        List<DetalleBolVenta> list2 = vdao.mtdlistboleta(Integer.parseInt(request.getParameter("txtSerieBol")), request.getParameter("txtNroBol"));

                                                                        Iterator<DetalleBolVenta> iter2 = list2.iterator();

                                                                        DetalleBolVenta dbv = null;
                                                                        while (iter2.hasNext()) {
                                                                            dbv = iter2.next();
                                                                %>
                                                                <tr>
                                                                    <td> <%=dbv.getIddetalleboleta()%>   </td>
                                                                    <td> <%=dbv.getFkidrepuesto()%>   </td>
                                                                    <td> <%=dbv.getCantidad()%>   </td>
                                                                    <td> <%=dbv.getImporte()%>   </td> 
                                                                </tr>
                                                                <%}
                                                                    }%>   
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>






                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Page Footer-->
        </div>
        <!-- Main File-->
        <script src="js/front.js"></script>
        
        <script src="https://cdnjs.cloudFlare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- bootstrap js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- custom js -->
    <script src="js/custom.js"></script>



    <script src="https://www.gstatic.com/dialogflow-console/fast/messenger/bootstrap.js?v=1"></script>
    
        <script>
        <%
            if(request.getParameter("VerPedidosBoletaDB")!=null){
            
        %>$('#modalScrollableCenter').modal('show')<%
            }
        %>
    </script>
    
    </body>
</html>
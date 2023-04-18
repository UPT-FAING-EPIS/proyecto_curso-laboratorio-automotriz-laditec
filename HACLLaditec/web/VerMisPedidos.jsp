<%-- 
    Document   : VerMisPedidos
    Created on : 22 nov 2022, 22:45:56
    Author     : JUNIOR-PC
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ModeloDAO.*"  %>
<%@page import="Modelo.*"  %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


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


    <df-messenger
        chat-icon="https:&#x2F;&#x2F;thumbs.dreamstime.com&#x2F;b&#x2F;agente-del-centro-de-atenciï¿½n-telefï¿½nica-con-el-avatar-los-auriculares-diseï¿½o-grï¿½fico-ejemplo-vector-141774176.jpg"
        chat-title="LADIBOT"
        agent-id="666d4933-d21a-42d6-92e1-673313cce0e6"
        language-code="es"
        ></df-messenger>
    <span>
        <h1 class="p-4 ">Mis Pedidos</h1>
    </span>
    <div class="container">
        <div class="row justify-content-center sm-2 p-4">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Serieboleta</th>
                        <th scope="col">Nroboleta</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Total</th>
                        <th scope="col">Impuesto</th>
                        <th scope="col">Credencial verificable</th>
                        <th scope="col">PDF Descargable</th>
                        <th scope="col">Ver productos</th>
                    </tr>
                </thead>
                <tbody>

                    <%            UsuariosDAO userdao = new UsuariosDAO();
                        ResultSet rs = userdao.listarboletas((Integer) sesion.getAttribute("idusuario"));

                        while (rs.next()) {
                    %>




                    <tr>
                        <th scope="row"><%=rs.getString(1)%></th>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(4)%></td>
                        <td><%=rs.getString(5)%></td>
                        <td><%=rs.getString(6)%></td>
                        <td><a href="https://stamping.io/explorer/?trxid=<%=rs.getString(7)%>">Verificar aqui</a></td>
                        <td><a href="https://stamping.io/api/hash/certificate/?hash=<%=rs.getString(8)%>">Descargar aqui</a></td>
                        <td>
                            <form action="Controlador" class="form-horizontal">
                                <input type="hidden" name="txtNroBol" value="<%=rs.getString(2)%>">
                                <input type="hidden" name="txtSerieBol" value="<%=rs.getString(3)%>">
                                <input type="hidden" name="accion"  value="VerPedidosBoleta">
                                <input type="submit" name="VerPedidosBoletaDB" value="VerProducto"><i class="fa fa-eye icon-lg"></i>
                            </form>
                        </td>


                    </tr>







                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>


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
                                    if(request.getParameter("VerPedidosBoletaDB")!=null){
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
                                <%}}%>   
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

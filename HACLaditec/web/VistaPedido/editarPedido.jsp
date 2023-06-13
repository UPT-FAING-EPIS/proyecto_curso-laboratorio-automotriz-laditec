<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@page import ="Modelo.PedidoVenta"%>
<%@page import ="ModeloDAO.PedidoVentaDAO"%>


<!DOCTYPE html>
<html>
  <head>  <%-- Inicio por Helbert--%>
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
    <link rel="stylesheet" href="css/agregar.css"> <!-- para agregar -->
     <!-- Font Awesome -->
     <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet'>
  </head>
  <body>
    <%@ include file="../header/header2.jsp"%>

          
<!------------------------------------------------- INICIO CONTENIDO ------------------------------------------------------------->
      
      <div class="page-content form-page">
            <!-- Page Header-->            
            <!-- Breadcrumb-->
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
                      <h2 class="h2 mb-0 text-center">Editar Pedido</h2>
                    </div>
                    <div class="card-body pt-0">
                      <!--  -->
                      <% 
            
            PedidoVentaDAO dao= new PedidoVentaDAO();
            PedidoVenta ped=new PedidoVenta();
            
            ped=dao.list(Integer.parseInt((String) request.getAttribute("idped")));
            
                      
                      %>
         
                      
                      
                      
                      
                      
                      
                      <form action="Controlador" class="form-horizontal">
                        
                            
                        <div class="row">
                          <label class="col-sm-3 form-label">IdPedido</label>
                          <div class="col-sm-9">
                              <input type="hidden" value="<%=ped.getIdpedido()%>"  name="txtPedido" >
                              <%=ped.getIdpedido()%>
                          </div>
                          
                          
                        </div>
                        
                          
                          
                        <!--  -->
                        <div class="my-4"></div>
                        <!--  -->
                        <div class="row">
                          <label class="col-sm-3 form-label">IdUsuario</label>
                          <div class="col-sm-9">
                            <input class="form-control" type="number" min="1" value="<%=ped.getIdusuario()%>"  name="txtUsuario" required>
                          </div>
                        </div>
                        
                          
                          
                          
                        <div class="my-4"></div>
                        
                        
                        <!--  -->
                        <div class="row">
                          <label class="col-sm-3 form-label">Fecha</label>
                          <div class="col-sm-9">
                            <div class="input-group">
                              <input class="form form-control" type="date" value="<%=ped.getFecha()%>" name="txtFecha" required>
                            </div>                          
                          </div>
                        </div>   
                            <div class="my-4"></div>
                        
                        
                        <!--  -->
                        <div class="row">
                          <label class="col-sm-3 form-label">Txrid</label>
                          <div class="col-sm-9">
                            <div class="input-group">
                                <input class="form form-control" type="text" value="<%=ped.getTxrid()%>" name="txtTxrid" required>
                            </div>                          
                          </div>
                        </div>   
                            
                        <input type="hidden" name="accion" value="EditarPedido">
                      <div class="my-4"></div>
                        
                        <div class="row">
                          <label class="col-sm-3 form-label">Estado</label>
                          <div class="col-sm-9">
                              <select name="txtEstado" value="<%=ped.getEstado()%>" required>
                                  <%if(ped.getEstado().equalsIgnoreCase("A")){
                                  %>
                                  <option value="A" selected>Activo</option>
                                  <option value="I" >Inactivo</option>
                                  <%
                                      } else if (ped.getEstado().equalsIgnoreCase("I")) {
%>
                                  <option value="A" >Activo</option>
                                  <option value="I" selected>Inactivo</option>
                                  <%
}
                                  
                                  %>
                                  
                                  
                              </select>
                          </div>
                          
                        </div>
                          
                        
                         <!--  -->                
                        <div class="container-fluid py-2">
                          <div class="modal-footer">
                            <a href="Controlador?accion=ListarPedido" class="btn btn-secondary" >Regresar</a>
                            <input class="btn btn-primary" type="submit" name="EditarPedidoDB" value="EditarPedidoDB">
                          </div>
                        </div>
                        <!--  -->
                        </form>
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                      
                    </div>
                  </div>
              </div>
            </div>
          </section>
        </div>      
    </div>
    <!-- Main File-->
    <script src="js/front.js"></script>
  </body>
</html><%-- Fin por Helbert--%>
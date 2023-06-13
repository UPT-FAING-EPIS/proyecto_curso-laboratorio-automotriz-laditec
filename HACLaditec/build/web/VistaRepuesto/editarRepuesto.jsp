

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.util.*"%>
<%@page import ="Modelo.Repuesto"%>
<%@page import ="ModeloDAO.RepuestoDAO"%>

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
                            <li class="breadcrumb-item"><a href="Controlador?accion=ListarRepuestos">Tablas</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Pedidos</li>
                        </ol>
                    </nav>
                </div>
                <section class="tables py-0">
                    <div class="container-fluid">
                        <div class="col-lg-12">
                            <div class="card mb-0">
                                <div class="card-header">
                                    <h2 class="h2 mb-0 text-center">Editar Repuesto</h2>
                                </div>
                                <div class="card-body pt-0">
                                    <!--  -->
                                    <%
                                        RepuestoDAO daprep = new RepuestoDAO();
                                        Repuesto rep = new Repuesto();

                                        rep = daprep.list(Integer.parseInt((String) request.getAttribute("id")));

                                    %>

                                    <form action="Controlador" class="form-horizontal">
                                        <div class="row">
                                            <label class="col-sm-3 form-label">IdRepuesto</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="number" value="<%=rep.getIdrepuesto()%>" min="1"  name="txtRepuesto" required >
                                            </div>
                                        </div>

                                        <!--  -->
                                        <div class="my-4"></div>
                                        <!--  -->
                                        <div class="row">
                                            <label class="col-sm-3 form-label">fkidalmacen</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="number" value="<%=rep.getFkidalmacen()%>" min="1"  name="txtFkidalmacen" required >
                                            </div>
                                        </div>

                                        <div class="my-4"></div>
                                        <!--  -->
                                        <div class="row">
                                            <label class="col-sm-3 form-label">fkidalmacen</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="number" value="<%=rep.getFkidestado()%>" min="1"  max="2" name="txtFkidestado" required >
                                            </div>
                                        </div>

                                        <div class="my-4"></div>
                                        <div class="row">
                                            <label class="col-sm-3 form-label">Nombre</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="<%=rep.getNombre()%>"  name="txtNombre" required >
                                            </div>
                                        </div>
                                        <div class="my-4"></div>
                                        <div class="row">
                                            <label class="col-sm-3 form-label">fkidcategoria</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="number" value="<%=rep.getFkidcategoria()%>" min="1"  name="txtFkidcategoria" required >
                                            </div>
                                        </div>
                                        <div class="my-4"></div>
                                        <div class="row">
                                            <label class="col-sm-3 form-label">Extension de la Imagen</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="<%=rep.getImagen()%>"  name="txtImagen" required >
                                            </div>
                                        </div>
                                        <div class="my-4"></div>
                                        <div class="row">
                                            <label class="col-sm-3 form-label">Precio Unitario</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="<%=rep.getPreciounitario()%>"  name="txtPrecioUnitario" required >
                                            </div>
                                        </div>
                                        <div class="my-4"></div>
                                        <div class="row">
                                            <label class="col-sm-3 form-label">Cantidad</label>
                                            <div class="col-sm-9">
                                                <input class="form-control" type="text" value="<%=rep.getCantidad()%>"  name="txtCantidad" required >
                                            </div>
                                        </div>

                                        <input type="hidden" name="accion" value="EditarRepuesto">
                                        <div class="my-4"></div>


                                        <!--  -->                
                                        <div class="container-fluid py-2">
                                            <div class="modal-footer">
                                                <a href="Controlador?accion=ListarRepuestos" class="btn btn-secondary" >Regresar</a>
                                                <input class="btn btn-primary" type="submit" name="EditarRepuestoDB" value="EditarRepuestoDB">
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
</html>

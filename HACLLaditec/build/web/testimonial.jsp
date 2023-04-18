<%@page import="Modelo.Comentarios"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ComentariosDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <!-- Site Metas // Logo -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />

        <title>Laditec</title>

        <!-- bootstrap css-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- fonts style -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet"> <!-- range slider -->

        <!-- font awesome style -->
        <script src="https://use.fontawesome.com/8fe783cf35.js"></script>

        <!-- Custom styles for this template -->
        <link href="css/testimonios.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />

    </head>

    <body class="sub_page">

        <div class="hero_area">
            <!-- header section strats -->
            <%@ include file="header/header.jsp"%>
            <!-- end header section -->
        </div>


        <div class="page-content form-page">


            <section class="tables py-0">
                <div class="container-fluid">
                    <div class="col-lg-12">
                        <div class="card mb-0">
                            <div class="card-header">
                                <h2 class="h2 mb-0 text-center p-3"><b>Comentarios</b></h2>
                            </div>
                            <div class="card-body pt-0">
                                <div class="table-responsive">

                                    <table class="table mb-0 table-striped table-hover">

                                        <thead>
                                            <tr>


                                                <th>USUARIO</th>
                                                <th>DESCRIPCION</th>
                                                <th>CALIFICACION</th>

                                            </tr>
                                        </thead>
                                        <tbody>

                                            <%                                                ComentariosDAO cdao = new ComentariosDAO();
                                                List<Comentarios> list = cdao.listar();
                                                Iterator<Comentarios> iter = list.iterator();

                                                Comentarios com = null;
                                                while (iter.hasNext()) {
                                                    com = iter.next();
                                            %>

                                            <tr>

                                                <td> <%=com.getNombre()%>   </td>
                                                <td> <%=com.getDescripcion()%>   </td>
                                                <td> 
                                                    <% while (com.getCalificacion() > 0) {
                                                    %>
                                                    <i class="fa fa-star" aria-hidden="true" style="color:#BF9765"></i>
                                                    <%
                                                        com.setCalificacion(com.getCalificacion()-1);
                                                        }
                                                    %>


                                                </td>



                                                <td>


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

        <!-- info section -->
        <%@ include file="footer/footer.jsp"%>


    </body>
</html>
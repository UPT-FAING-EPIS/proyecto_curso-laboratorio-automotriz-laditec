<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>
<%@page import="ModeloDAO.*"%>
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
        <link href="css/product.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />

    </head>

    <body class="sub_page">

        <div class="hero_area">
            <%@ include file="header/header.jsp"%>
        </div>

        <section class="product_section p-4"><%--Modificado por Helbert--%>
            <div class="container">
                <div class="heading_container heading_center">
                    <h2>
                        Nuestros Productos
                    </h2>
                </div>
                <form>
                    <select name="txtfiltro">
                        <option value="%">Todos</option>
                        <option value="1">Nissan</option>
                        <option value="2">Mitsubishi</option>
                        <option value="3">Toyota</option>
                    </select>
                    <input type="hidden" name="accion" value="ListarProductos">
                    <input type="submit" name="Filtrar" value="Filtrar">
                </form>



                <div class="row">
                    <%              List<CarritoCompra> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");

                        ProductoDAO prodao = new ProductoDAO();
                        List<Producto> elementos = null;
                        int idproducto = 0;
                        boolean mostrarcantidad = true;

                        if (request.getParameter("Filtrar") != null && request.getParameter("Filtrar").equals("Filtrar")  ) {

                            elementos = prodao.listar(request.getParameter("txtfiltro"));
                            

                        } else {
                            elementos = prodao.listar("%");
                        }

                        for (int i = 0; i < elementos.size(); i++) {
String val="";
                            int pasar = elementos.get(i).getIdRepuesto() + 3;
                            if(request.getParameter("txtfiltro")!=null && !request.getParameter("txtfiltro").equals("%") ){
                             val = "Controlador?accion=MandarACarrito&Filtrar=Filtrar&txtfiltro="+request.getParameter("txtfiltro")+"&idRepuesto=" + String.valueOf(pasar - 3);
                            
                        }else{
                        val = "Controlador?accion=MandarACarrito&txtfiltro=%25&Filtrar=Filtrar2&idRepuesto=" + String.valueOf(pasar - 3);
                            
                        }
                            
                            String imagen = "images/p" + pasar + "." + elementos.get(i).getImagenRepuesto().trim();
                            System.out.println(imagen);

                    %>

                    <div class="col-sm-6 col-lg-4">
                        <div class="box">
                            <div class="img-box">
                                <img src=<%=imagen%> alt="">



                                <%
                                    if (articulos != null ) {
                                            
                                        for (CarritoCompra carr : articulos) {
                                            mostrarcantidad = true;
                                            if (carr.getIdProducto() == elementos.get(i).getIdRepuesto()) {
                                                if (elementos.get(i).getCantidad() - carr.getCantidad() < 1) {
                                                    mostrarcantidad = false;
                                                    break;
                                                } else {
                                                    mostrarcantidad = true;
                                                }

                                            }

                                        }
                                    
                                    }
                                    if (elementos.get(i).getCantidad() > 0 && mostrarcantidad) {%>
                                <a href=<%=val%> class="add_cart_btn">
                                    <span>
                                        Agregar al Carrito
                                    </span>
                                </a>
                                <%};%>

                            </div>

                            <div class="detail-box">
                                <h5>
                                    <%=elementos.get(i).getNombreRepuesto()%>
                                </h5>
                                <div class="product_info">
                                    <h5>
                                        <span>$/.</span> <%=elementos.get(i).getPrecioUnitarioRepuesto()%>
                                        <br>
                                        <%if (articulos == null) {
                                        %>
                                        Cantidad: <%=elementos.get(i).getCantidad()%>
                                        <%
                                        } else {
                                            mostrarcantidad = false;

                                            for (CarritoCompra carr : articulos) {
                                                if (carr.getIdProducto() == elementos.get(i).getIdRepuesto()) {
                                                    mostrarcantidad = true;
                                                    idproducto = carr.getCantidad();
                                                    break;
                                                } else {
                                                    mostrarcantidad = false;
                                                }

                                            }

                                            if (mostrarcantidad) {
                                        %>
                                        Cantidad: <%=elementos.get(i).getCantidad() - idproducto%>
                                        <%

                                        } else {
                                        %>
                                        Cantidad: <%=elementos.get(i).getCantidad()%>
                                        <%
                                                }

                                            }


                                        %>

                                    </h5>
                                </div>
                            </div>
                        </div>
                    </div>      
                    <% }%>
                </div>
            </div>
        </section>

        <!-- info section -->
        <%@ include file="footer/footer.jsp"%>




    </body>

</html>
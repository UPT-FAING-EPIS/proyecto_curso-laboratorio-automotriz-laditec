
<%@page import="ModeloDAO.BoletaVentaDAO"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="ModeloDAO.PedidoVentaDAO"%>
<%@page import="ModeloDAO.CarritoCompraDAO"%>
<%@page import="Modelo.*" %>
<%@page import="ModeloDAO.ProductoDAO" %>
<%@page import="Controlador.*" %> 
<%@page import="java.util.*"%>
<%@page import="java.math.*"%>




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

        <!-- responsive style -->
        <link href="css/responsive.css" rel="stylesheet" />
        <link href="css/carrito.css" rel="stylesheet" />

    </head>

    <body class="sub_page">

        <div class="hero_area">
            <!-- header section strats -->
            <%@ include file="header/header.jsp"%>

            <%List<CarritoCompra> articulos = sesion.getAttribute("carrito") == null ? null : (ArrayList) sesion.getAttribute("carrito");%>
            <%
                if (articulos == null || articulos.isEmpty()) {
                    sesion.removeAttribute("carrito");
                    response.sendRedirect("product.jsp");
                }
            %>


            <script src="https://cdnjs.cloudFlare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
            <!-- bootstrap js -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
            <!-- custom js -->
            <script src="js/custom.js"></script>

        </div>

        <div class="containerr lista">
            <div class="card">
                <div class="row" id="div2">
                    <script type="text/javascript">

                        $(document).ready(function () {

                            var height = $(window).height();

                            $('#div2').height(height);
                        });

                    </script>

                    <div class="col-md-8 cart">
                        <div class="title">
                            <div class="row">
                                <div class="col"><h4><b>Lista de pedidos</b></h4></div>
                                <div class="col align-self-center text-right text-muted"></div>
                            </div>
                        </div>


                        <%
                            int total = 0;
                            ProductoDAO productosdao = new ProductoDAO();
                            if (articulos != null) {
                                for (int i = 0; i < articulos.size(); i++) {
                                    int esto = articulos.get(i).getIdProducto();
                                    Producto Elemento = new Producto();
                                    Elemento = productosdao.listarPorId(esto);
                                    total += Elemento.getPrecioUnitarioRepuesto() * articulos.get(i).getCantidad();
                                    String imagen = "images/p" + String.valueOf(Elemento.getIdRepuesto() + 3) + "." + Elemento.getImagenRepuesto();

                        %>


                        <div class="row border-top border-bottom">
                            <div class="row main align-items-center">
                                <div class="col-2"><img class="img-fluid" src=<%=imagen%>></div>
                                <div class="col">
                                    <div class="row"><%=Elemento.getNombreRepuesto()%></div>
                                </div>
                                <div class="col">
                                    <%=articulos.get(i).getCantidad()%>
                                </div>
                                <div class="col">$/. <%=Elemento.getPrecioUnitarioRepuesto() * articulos.get(i).getCantidad()%> <a href="Controlador?accion=borrarElementoCarrito&idRepuesto=<%=esto%>"><span class="close"> &#10005;</span></a></div>

                            </div>
                        </div>

                        <%

                                }
                            }
                            BigDecimal bd = new BigDecimal(total * 0.18).setScale(2, RoundingMode.HALF_UP);

                            double impuesto = bd.doubleValue();

                        %>


                        <div class="back-to-shop"><a href="product.jsp"><span class="text-muted">< Back to shop</span></a></div>

                    </div>

                    <div class="col-md-4 summary">
                        <div><h5><b>Resumen </b></h5></div>
                        <hr>
                        <div class="row costo">
                            <div class="col " style="padding-left:0;">Subtotal</div>
                            <div class="col text-right">$/. <%=total - total * 0.18%></div>
                        </div>
                        <div class="row costo">
                            <div class="col" style="padding-left:0;">Impuesto</div>
                            <div class="col text-right">$/. <%=impuesto%></div>
                        </div>

                        <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                            <div class="col">TOTAL PRICE</div>
                            <div class="col text-right">$/.<%=total%></div>
                        </div>
                        <form>
                            <input type="submit" class="btnCheckout" name="Checkout" value="Checkout" >
                        </form>
                        <%
                            if (request.getParameter("Checkout") != null) {
                                CarritoCompraDAO Daocarrito = new CarritoCompraDAO();
                                DetalleBolVenta dbv = new DetalleBolVenta();
                                LocalDateTime d = LocalDateTime.now();
                                

                                PedidoVenta ped = new PedidoVenta();
                                PedidoVentaDAO peddao = new PedidoVentaDAO();
                                ped.setIdusuario((Integer) sesion.getAttribute("idusuario"));
                                ped.setFecha(d.toString());
                                sesion.setAttribute("idpedido",peddao.contarpedidos());
                                ped.setIdpedido((Integer) sesion.getAttribute("idpedido"));
                                ped.setEstado("A");                                

                                peddao.add(ped);

                                BoletaVenta dboleta = Daocarrito.CrearBoleta(total, ped);

                                for (int i = 0; i < articulos.size(); i++) {
                                    int esto = articulos.get(i).getIdProducto();
                                    Producto Elemento = new Producto();
                                    Elemento = productosdao.listarPorId(esto);
                                    dbv.setFknroboleta(dboleta.getNroboleta());
                                    dbv.setFkserieboleta(dboleta.getSerieboleta());
                                    dbv.setFkidrepuesto(Elemento.getIdRepuesto());
                                    dbv.setCantidad(articulos.get(i).getCantidad());
                                    dbv.setImporte(Elemento.getPrecioUnitarioRepuesto() * articulos.get(i).getCantidad());
                                    Daocarrito.mtdBajarcantidad(Elemento.getIdRepuesto());
                                    
                                    Daocarrito.InsertarDetalleBoleta(dbv);

                                }

                                String datosboleta = dboleta.getSerieboleta() + "-" + dboleta.getNroboleta();
                                String dnicliente = String.valueOf(sesion.getAttribute("idusuario"));
                                String fechaemision = dboleta.getFechaemision();
                                BoletaVentaDAO boldao = new BoletaVentaDAO();

                        %>
                        <script >
                            var xhr = new XMLHttpRequest();
                            xhr.addEventListener("readystatechange", function () {
                                if (this.readyState === 4) {
                                    var data = JSON.parse(this.responseText);
                                    document.cookie="txrid = "+data.trxid;
                                    document.cookie="hash = "+data.hash["stamp"];
                                    
                                    
                            <%                                
                                sesion.setAttribute("carrito", null);
                                
                            %>
                                    
                                    window.location.href = "validarcompra.jsp";
                                    
                                }
                                
                            });
                            xhr.open("POST", "https://api.stamping.io/credential/create/?privateKey=008711d0ee706ca32774e7791262890f88d852c70ac7962a0f35e3f53820a010&id=@uuid&idcredential=@uuid&mode=normal&validFrom=1669116941&validTo=1671708120&data=%7B%0A%20%22SerieyNumeroBolventa%22:%22<%=datosboleta%>%22,%0A%20%22DniCliente%22:%22<%=dnicliente%>%22,%0A%20%22Fechaemision%22:%22<%=fechaemision%>%22%0A%7D&token=205c8293aad30b1ebf978c77097600862feb441ed47bfe785a22d09da49");
                            xhr.send();
                        </script>   



                        <%

                            }
                        %>



                    </div>


                </div>
            </div>
        </div>
    </body>

</html>
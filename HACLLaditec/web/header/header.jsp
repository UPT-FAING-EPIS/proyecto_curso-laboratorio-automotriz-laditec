
<!-- header section strats -->
<header class="header_section"><%--Modificado por Helbert--%>
    <div class="header_top">
        <div class="container-fluid">
            <div class="top_nav_container">
                <div class="contact_nav" >
                    <img src="images/logo2.png" alt="alt" width="60" height="50">
                </div>



                <div class="user_option_box">
                    <%

                        HttpSession sesion = request.getSession(true);

                        
                        
                        
 
                        if (sesion.getAttribute("fkidrolusuario") == null) {
                    %>
                    <a href="Controlador?accion=LogearUsuario" class="account-link">
                        <i class="fa fa-user" aria-hidden="true" style="color:#BF9765"></i>
                        <span>
                            Mi cuenta
                        </span>
                    </a><%
                    } else if ((int) sesion.getAttribute("fkidrolusuario") == 2) {
                    %>
                    <a href="administrar.jsp" class="account-link">
                        <i class="fa fa-user" aria-hidden="true" style="color:#BF9765"></i>
                        <span>
                            Volvemos a Admin
                        </span>
                    </a>

                    <%
                    } else {
                    %>

                    <span style="color: White">
                        Bienvenido: <%=sesion.getAttribute("nomusuariologin")%>
                    </span>

                    <a href="VerMisPedidos.jsp" class="account-link">
                        <i class="fa fa-shopping-bag" aria-hidden="true" style="color:#BF9765"></i>
                        <span>
                            Ver mis Pedidos
                        </span>
                    </a>
                    
                    <a href="Controlador?accion=LogoutUsuario" class="account-link">
                        <i class="fa fa-user" aria-hidden="true" style="color:#BF9765"></i>
                        <span>
                            Logout
                        </span>
                    </a>


                    <%
                        }
                    %>
                    <a href="carrito.jsp" class="cart-link">
                        <i class="fa fa-shopping-cart" aria-hidden="true" style="color:#BF9765"></i>
                        <span>
                            Carrito
                        </span>
                    </a>
                </div>
            </div>

        </div>
    </div>


    <div class="header_bottom">
        <div class="container-fluid">
            <nav class="navbar navbar-expand-lg custom_nav-container ">

                <a class="navbar-brand" href="index.jsp">
                    <span>
                        LADITEC
                    </span>
                </a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class=""> </span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ">
                        <li class="nav-item">
                            <a class="nav-link Inicio" href="index.jsp">Inicio <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link Nosotros" href="about.jsp">Nosotros</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link Productos" href="product.jsp">Productos</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link Cliente" href="testimonial.jsp">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link Contactanos" href="contac.jsp">Contactanos</a>
                        </li>

                    </ul>
                </div>
            </nav>
        </div>
    </div>
                    
</header>
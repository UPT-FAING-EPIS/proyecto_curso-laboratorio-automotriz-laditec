<!DOCTYPE html>
<html><%--modificado por Helbert Andres Condori Loayza--%>
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
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>

<body>

  <div class="hero_area">
    <!-- header section strats -->
<%@ include file="header/header.jsp"%>

    <!-- end header section -->
    <a href="VerificarCompra.jsp">Consultar Pedido</a>
    <!-- slider section -->
    <section class="slider_section ">
      <div id="customCarousel1" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container ">
              <div class="row">
                <div class="col-md-6">
                  <div class="detail-box">
                    <h1>
                      Bienvenido a LADITEC
                    </h1>
                    <p>
                      Somos un laboratorio automotriz técnico peruano encargado del mantenimiento y venta de repuestos en diferentes variades de vehiculos brindando un gran servicio y calidad por más de 15 años en la ciudad de tacna.
                    </p>
                    <a href="about.jsp">
                      Saber más
                    </a>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="img-box">
                    <img src="images/Slider-inicio.png" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container ">
              <div class="row">
                <div class="col-md-6">
                  <div class="detail-box">
                    <h1>
                      MITSUBISHI
                    </h1>
                    <p>
                      Trabajamos con diferentes repuestos de la marca Mitsubishi para saber más al respecto hacer click sobre el siguiente boton
                    </p>
                    <a href="https://www.mitsubishi-motors.com.pe/">
                      Saber más
                    </a>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="img-box">
                    <img src="images/p1.png" style="height: 370px" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <div class="container ">
              <div class="row">
                <div class="col-md-6">
                  <div class="detail-box">
                    <h1>
                      NISSAN
                    </h1>
                    <p>
                      Trabajamos con diferentes repuestos de la marca Nissan para saber más al respecto hacer click sobre el siguiente boton
                    </p>
                    <a href="https://www.nissan.pe/">
                      Saber más
                    </a>
                  </div>
                </div>
                <div class="col-md-6">
                  <div class="img-box">
                    <img src="images/p2.png" style="height: 370px" alt="">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="carousel_btn_box">
          <a class="carousel-control-prev" href="#customCarousel1" role="button" data-slide="prev">
            <i class="fa fa-angle-left" aria-hidden="true"></i>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#customCarousel1" role="button" data-slide="next">
            <i class="fa fa-angle-right" aria-hidden="true"></i>
            <span class="sr-only">Next</span>
          </a>
        </div>
      </div>
    </section>
    <!-- end slider section -->
  </div>


  <!-- product section -->

  <section class="product_tipos layout_padding">
    <div class="container">
      <div class="heading_container heading_center">
        <h2>
          Marcas Contenidas
        </h2>
      </div>
      <div class="row">
        <div class="col-sm-6 col-lg-4">
          <div class="box">
            <div class="img-box">
              <img src="images/p1.png" alt="">
              <a href="product.jsp" class="add_cart_btn">
                <span>
                  Ver
                </span>
              </a>
            </div>
            <div class="detail-box">
              <h5>
                Mitsubishi
              </h5>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-lg-4">
          <div class="box">
            <div class="img-box">
              <img src="images/p2.png" alt="">
              <a href="product.jsp" class="add_cart_btn">
                <span>
                  Ver
                </span>
              </a>
            </div>
            <div class="detail-box">
              <h5>
                Nissan
              </h5>
            </div>
          </div>
        </div>
        <div class="col-sm-6 col-lg-4">
          <div class="box">
            <div class="img-box">
              <img src="images/p3.png" alt="">
              <a href="product.jsp" class="add_cart_btn">
                <span>
                  Ver
                </span>
              </a>
            </div>
            <div class="detail-box">
              <h5>
                Toyota
              </h5>
            </div>
          </div>
        </div>
    </div>
  </section>

  <!-- end product section -->


  <!-- end why us section -->
  <!-- info section -->
  <%@ include file="footer/footer.jsp"%>
  
<df-messenger
  chat-icon="https:&#x2F;&#x2F;thumbs.dreamstime.com&#x2F;b&#x2F;agente-del-centro-de-atenciï¿½n-telefï¿½nica-con-el-avatar-los-auriculares-diseï¿½o-grï¿½fico-ejemplo-vector-141774176.jpg"
  chat-title="LADIBOT"
  agent-id="666d4933-d21a-42d6-92e1-673313cce0e6"
  language-code="es"
></df-messenger>
  
  
<script src="https://www.gstatic.com/dialogflow-console/fast/messenger/bootstrap.js?v=1"></script>


</body>

</html>
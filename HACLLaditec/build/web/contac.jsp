

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
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
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>

  <!-- Custom styles for this template -->
  <link href="css/contac.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
  <!-- Map box -->
  <link href="https://api.mapbox.com/mapbox-gl-js/v2.10.0/mapbox-gl.css" rel="stylesheet">
  <script src="https://api.mapbox.com/mapbox-gl-js/v2.10.0/mapbox-gl.js"></script>
  <!-- sweetalert2 -->
  <script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>

</head>

<body class="sub_page">
    

  <div class="hero_area">
    <!-- header section strats -->
    <%@ include file="header/header.jsp"%>
    <!-- end header section -->
  </div>

  <!-- about section -->
  <section>
      <div class = "contact">
          <br>
          <h2>Contactanos</h2>
          <p class = "descrip">Cu&#233ntanos qu&#233 necesitas.
              Nuestro equipo se pondr&#225; a trabajar inmediatamente contigo.</p>
      </div>
      <div>
          <div class = "info">
              <div>
                  <span><i class = "fas fa-mobile-alt"></i></span>
                  <span>Nro. Celular </span>
                  <span class = "text">+52 974264666</span>
              </div>
              <div>
                  <span><i class = "fas fa-envelope-open"></i></span>
                  <span>E-mail</span>
                  <span class = "text">julio777@gmail.com</span>
              </div>
              <div>
                  <span><i class = "fas fa-map-marker-alt"></i></span>
                  <span>Direcci&#243n</span>
                  <span class = "text">Av. centenario por talara</span>
              </div>
              <div>
                  <span><i class = "fas fa-clock"></i></span>
                  <span>Horario</span>
                  <span class = "text">Lunes a Sabado (9:00 AM - 5:00 PM)</span>
              </div>
          </div>
          
      </div>
      <div id="map"></div>
      <script src="js/scriptruta.js"></script>
      <br>
  </section>

  <!-- end about section -->

  <!-- info section -->
  <%@ include file="footer/footer.jsp"%>
 


</body>

</html>


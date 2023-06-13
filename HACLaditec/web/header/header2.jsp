<header class="header">   
      <nav class="navbar navbar-expand-lg py-3 bg-dash-dark-2 border-bottom border-dash-dark-1 z-index-10">
        <div class="container-fluid d-flex align-items-center justify-content-between py-1">
          <div class="navbar-header d-flex align-items-center"><a class="navbar-brand text-uppercase text-reset" href="administrar.jsp">
              <div class="brand-text brand-big"><strong class="text-primary">Ladi</strong><strong>tec</strong></div>
              <div class="brand-text brand-sm"><strong class="text-primary">L</strong><strong>T</strong></div></a>
            <button class="sidebar-toggle">
                  <svg class="svg-icon svg-icon-sm svg-icon-heavy transform-none">
                    <use xlink:href="#arrow-left-1"> </use>
                  </svg>
            </button>
          </div>
          <ul class="list-inline mb-0">
            <li class="list-inline-item logout px-lg-2">                 
              <a class="nav-link text-xl text-reset px-1 px-lg-0" id="logout" href="Controlador?accion=LogoutUsuario"> 
                Salir
                <i class="fa fa-unlock-alt" aria-hidden="true"></i>
              </a>
            </li>
          </ul>
        </div>
      </nav>
    </header>
    <div class="d-flex align-items-stretch">

    <nav id="sidebar">
        <!-- Sidebar Header-->
        <div class="sidebar-header d-flex align-items-center p-4"><img class="avatar shadow-0 img-fluid rounded-circle" src="img/avatar-6.jpg" alt="...">
          <div class="ms-3 title">
              <% HttpSession sesion = request.getSession(true); %>
              <h1 class="h5 mb-1"><%=sesion.getAttribute("nomusuariologin") %></h1>
            <p class="text-sm text-gray-700 mb-0 lh-1">Admin</p>
          </div>
        </div><span class="text-uppercase text-gray-600 text-xs mx-3 px-2 heading mb-2">Main</span>
        
             
      </nav>
      <script>
      function injectSvgSprite(path) {
      
          var ajax = new XMLHttpRequest();
          ajax.open("GET", path, true);
          ajax.send();
          ajax.onload = function(e) {
          var div = document.createElement("div");
          div.className = 'd-none';
          div.innerHTML = ajax.responseText;
          document.body.insertBefore(div, document.body.childNodes[0]);
          }
      }
      injectSvgSprite('https://bootstraptemple.com/files/icons/orion-svg-sprite.svg'); 
      
      
    </script>
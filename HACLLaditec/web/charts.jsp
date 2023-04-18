

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controlador.Controlador"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="Config.*"%>
<%@page import="ModeloDAO.GraficasDAO"%>
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
    <!-- Google fonts - Muli-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/header.css"> 
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/charts.css"> <!-- para agregar -->
     <!-- Font Awesome -->
     <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet'>
  </head>
  <body>
    <%@ include file="header/header2.jsp"%>
<!------------------------------------------------- INICIO CONTENIDO ------------------------------------------------------------->
<%
ResultSet rs;
try{
    GraficasDAO graf=new  GraficasDAO();
    rs=graf.cantidad();
%>
  <div class="page-content">
    <div class="container" >
        <div class="row" >
            <h1 class="grfico">Estadisticas</h1>
        <div>
          <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
          <div class="Grafico1" >
            <script>
                google.charts.load('current', {'packages':['corechart']});
                google.charts.setOnLoadCallback(drawChart);
                function drawChart() {

                  var data = google.visualization.arrayToDataTable([
                   ['Productos', 'Ultimos7 dias'],
                    <% while(rs.next()){
      
                      %>
                    ['<%= rs.getString("nombre") %>', <%= rs.getString("cantidad") %>],
                            
                      <% } %>
                  ]);

                  var options = {
                    "title": "Productos vendidos los ultimos 7 dias",
                    titleTextStyle: {
                        color: "c7c4c4",             
                        fontSize: 25,               
                        bold: true},
                    backgroundColor: '#34373d',
                    'height':400,
                    responsive: true,
                    "legend" : { "textStyle" : { "color" : "c7c4c4"} }
                  };

                  var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                  chart.draw(data, options);
                }
            </script>
          </div>
    <%
    }catch (Exception e){
    System.out.println(e.toString());
    }
    %> 
  </div>
  <div id="piechart"></div>
  </div>


            <%
        try{
            GraficasDAO graf2=new  GraficasDAO();
            rs=graf2.Ganancias();
        %>
            <div class="row">
                  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                <script type="text/javascript">
                  google.charts.load("current", {packages:['corechart']});
                  google.charts.setOnLoadCallback(drawChart);
                  function drawChart() {
                    var data = google.visualization.arrayToDataTable([
                      ["Fecha", "Dolares", { role: "style"} ],
                       <% while(rs.next()){
        
                        %>
                        ["<%=rs.getString("fechaemision") %>", <%=rs.getString(2) %>, "#6610f2"],
                    <% } %>
                    ]);
        <%
        }
    catch (Exception e){
        System.out.println(e.toString());
        }
        %> 
                    var view = new google.visualization.DataView(data);
                    view.setColumns([0, 1,
                                     { calc: "stringify",
                                       sourceColumn: 1,
                                       type: "string",
                                       role: "annotation" },
                                     2]);
<%
        try{
            GraficasDAO graf3=new  GraficasDAO();
            rs=graf3.total();
       while(rs.next()){
%>
                    var options = {
                      title: 'Se tiene ganancias totales de <%=rs.getString("Ganancia") %> Dolares',
                      titleTextStyle: {
                          color: "c7c4c4",             
                          fontSize: 25,               
                          bold: true},
                       isStacked: true,
                        colors: ['#6610f2'],
                      hAxis: {
                        title: 'Fechas',
                        textStyle: {color: '#ffffff',
                        fontSize: 14,
                        bold: false,
                        italic: false},
                        titleTextStyle: {
                        fontSize: 18,
                        color: '#ffffff',
                        bold: true,
                        italic: false}
                        },
                      vAxis: {
                        title: 'Dolares',
                        textStyle: {color: '#ffffff',
                        fontSize: 14,
                        bold: false,
                        italic: false},
                        titleTextStyle: {
                        fontSize: 18,
                        color: '#ffffff',
                        bold: true,
                        italic: false}
                        },
                      text:{color: '#ffffff'},
                      backgroundColor: '#34373d',
                      'height':400,
                      responsive: true,
                      "legend" : { "textStyle" : { "color" : "c7c4c4",fontSize: 16} }
                    };
    <%
            }
        }
    catch (Exception e){
        System.out.println(e.toString());
        }
        %> 
                    var chart = new google.visualization.ColumnChart(document.getElementById("columnchart_values"));
                    chart.draw(view, options);
                }
                </script>
                <div id="columnchart_values" style="width: 100%; height: 300px;"></div>

            </div>
          </div>
      </div>
    <!-- Main File-->
    <script src="js/front.js"></script>
</body>
</html>
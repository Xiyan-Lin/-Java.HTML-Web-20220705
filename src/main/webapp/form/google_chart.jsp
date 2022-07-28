<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Work',     11],
          ['Eat',      2],
          ['Commute',  2],
          ['Watch TV', 2],
          ['Sleep',    2],
          ['Game',    5]
        ]);

        var options = {
          title: 'My Daily Activities',
          is3D: true
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
        
        var chart2 = new google.visualization.BarChart(document.getElementById('barchart'));
        chart2.draw(data, options);
        
        var chart3 = new google.visualization.ColumnChart(document.getElementById('columnchart'));
        chart3.draw(data, options);
        
        var chart4 = new google.visualization.LineChart(document.getElementById('linechart'));
        chart4.draw(data, options);
        
        
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 900px; height: 500px;"></div>
    <div id="barchart" style="width: 900px; height: 500px;"></div>
    <div id="columnchart" style="width: 900px; height: 500px;"></div>
    <div id="linechart" style="width: 900px; height: 500px;"></div>
  </body>
</html>
    
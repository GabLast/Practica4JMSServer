<#include "base.ftlh">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <div class="container-fluid">

        <div class="container-fluid">
            <div class="row">
                <div class="container-fluid">
                    <div class="row">
                        <h3 class="text-light">Device 1</h3>
                        <div class="col-md-6">
                            <div id="chart1a">
                            </div>
                        </div>
                        <div class="col md-6">
                            <div id="chart1b"></div>
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <h3 class="text-light">Device 2</h3>
                        <div class="col-md-6">
                            <div id="chart2a"></div>
                        </div>
                        <div class="col md-6">
                            <div id="chart2b"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages': ['line']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {

            var data1 = new google.visualization.DataTable();
            data1.addColumn('number', 'X');
            data1.addColumn('number', 'Temperature (Celcius)');

            <#assign count = 0>
            <#if dataDevice1??>
            <#list 0..sizeDataDevice1-1 as index>
            <#assign count = count + 1>
            <#if index == 0>
            data1.addRows([
                [0, 0]
            ]);
            </#if>
            data1.addRows([
                [${count}, ${dataDevice1.getTemps()[index]}]
            ]);
            </#list>
            </#if>

            var options1 = {
                backgroundColor: '#F5F5F5',
                chart: {
                    title: 'Temperature vs X, Device 1'
                },
                // Adds titles to each axis.
                hAxis: {title: 'X'},
                vAxis: {title: 'Temperature (Celcius)'},
                width: 700,
                height: 500
            };

            var chart1 = new google.charts.Line(document.getElementById('chart1a'));

            chart1.draw(data1, google.charts.Line.convertOptions(options1));

            //    ======================================================================================

            var data2 = new google.visualization.DataTable();
            data2.addColumn('number', 'X');
            data2.addColumn('number', 'Humidity');

            <#assign count = 0>
            <#if dataDevice1??>
            <#list 0..sizeDataDevice1-1 as index>
            <#assign count = count + 1>
            <#if index == 0>
            data2.addRows([
                [0, 0]
            ]);
            </#if>
            data2.addRows([
                [${count}, ${dataDevice1.getHumidities()[index]}]
            ]);
            </#list>
            </#if>

            var options2 = {
                backgroundColor: '#F5F5F5',
                chart: {
                    title: 'Temperature vs X, Device 1'
                },
                // Adds titles to each axis.
                hAxis: {title: 'X'},
                vAxis: {title: 'Temperature (Celcius)'},
                width: 700,
                height: 500
            };

            var chart2 = new google.charts.Line(document.getElementById('chart1b'));

            chart2.draw(data1, google.charts.Line.convertOptions(options2));

            //    ======================================================================================

            var data3 = new google.visualization.DataTable();
            data3.addColumn('number', 'X');
            data3.addColumn('number', 'Temperature');

            <#assign count = 0>
            <#if dataDevice2??>
            <#list 0..sizeDataDevice2-1 as index>
            <#assign count = count + 1>
            <#if index == 0>
            data3.addRows([
                [0, 0]
            ]);
            </#if>
            data3.addRows([
                [${count}, ${dataDevice2.getTemps()[index]}]
            ]);
            </#list>
            </#if>

            var options3 = {
                backgroundColor: '#F5F5F5',
                chart: {
                    title: 'Temperature vs X, Device 1'
                },
                // Adds titles to each axis.
                hAxis: {title: 'X'},
                vAxis: {title: 'Temperature (Celcius)'},
                width: 700,
                height: 500
            };

            var chart3 = new google.charts.Line(document.getElementById('chart2a'));

            chart3.draw(data3, google.charts.Line.convertOptions(options3));

            //    ======================================================================================

            var data4 = new google.visualization.DataTable();
            data4.addColumn('number', 'X');
            data4.addColumn('number', 'Humidity');

            <#assign count = 0>
            <#if dataDevice1??>
            <#list 0..sizeDataDevice2-1 as index>
            <#assign count = count + 1>
            <#if index == 0>
            data4.addRows([
                [0, 0]
            ]);
            </#if>
            data4.addRows([
                [${count}, ${dataDevice2.getHumidities()[index]}]
            ]);
            </#list>
            </#if>

            var options4 = {
                backgroundColor: '#F5F5F5',
                chart: {
                    title: 'Temperature vs X, Device 1'
                },
                // Adds titles to each axis.
                hAxis: {title: 'X'},
                vAxis: {title: 'Temperature (Celcius)'},
                width: 700,
                height: 500
            };

            var chart4 = new google.charts.Line(document.getElementById('chart2b'));

            chart4.draw(data4, google.charts.Line.convertOptions(options4));

        }
    </script>

</#macro>
<@display_page/>

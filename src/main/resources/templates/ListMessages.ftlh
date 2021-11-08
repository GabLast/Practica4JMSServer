<#include "base.ftlh">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
        <script src="resources/js/sockjs-0.3.4.js"></script>
        <script src="resources/js/stomp.js"></script>

<#--        https://www.baeldung.com/websockets-spring-->
        <script type="text/javascript">
            var stompClient = null;

            function connect() {
                var socket = new SockJS('/socket');
                stompClient = Stomp.over(socket);
                stompClient.connect({}, function(frame) {
                    setConnected(true);
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/messages/list', function(messageOutput) {
                        showMessageOutput(JSON.parse(messageOutput.body));
                    });
                });
            }

            function disconnect() {
                if(stompClient != null) {
                    stompClient.disconnect();
                }
                setConnected(false);
                console.log("Disconnected");
            }

            //https://stackoverflow.com/questions/21106943/add-td-element-to-tr-with-id
            function showMessageOutput(messageOutput) {
                var response = document.getElementById('response');

                var td1 = document.createElement('td');
                td1.innerHTML = messageOutput.idMessage;
                var td2 = document.createElement('td');
                td2.innerHTML = messageOutput.idDispositivo;
                var td3 = document.createElement('td');
                td3.innerHTML = messageOutput.fechaGeneracion;
                var td4 = document.createElement('td');
                td4.innerHTML = messageOutput.temperatura;
                var td5 = document.createElement('td');
                td5.innerHTML = messageOutput.humedad;

                response.appendChild(td1);
                response.appendChild(td2);
                response.appendChild(td3);
                response.appendChild(td4);
                response.appendChild(td5);

            }
        </script>
    </#if>
</#macro>

<#macro page_body>
    <body>
    <div class="container-fluid">
        <div class="row">
            <div class="container-fluid">
                <div class="row">
                    <div class="col md-1">
                    </div>
                    <div class="col-md-10 me-auto">
                            <div class="table-responsive" style="height: 600px">
                                <table class="table table-striped table-hover">
                                    <thead class="table-dark text-center">
                                    <tr>
                                        <th scope="col">ID Message</th>
                                        <th scope="col">Device ID</th>
                                        <th scope="col">Timestamp</th>
                                        <th scope="col">Temperature</th>
                                        <th scope="col">Humidity</th>
                                    </tr>
                                    </thead>
                                    <tbody class="text-center table-bordered">
                                        <tr onload="connect()" id="response" class="table-secondary">

                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                    </div>
                    <div class="col md-1">
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</#macro>
<@display_page/>
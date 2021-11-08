<#include "base.ftlh">
<#macro page_head>
    <#if title?has_content>
        <title>${title}</title>
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
                    <div class="col-md-9 me-auto">
                        <#if listamsg??>
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
                                    <#list listamsg as msg>
                                        <tr id="response" class="table-secondary">
                                            <td>${msg.getIdMessage()}</td>
                                            <td>${msg.getIdDispositivo()}</td>
                                            <td>${msg.getFechaGeneracion().getDayOfMonth()}/${msg.getFechaGeneracion().getMonthValue()}/${msg.getFechaGeneracion().year?c} ${msg.getFechaGeneracion().getHour()}:${msg.getFechaGeneracion().getMinute()}:${msg.getFechaGeneracion().getSecond()}</td>
                                            <td>${msg.getTemperatura()}</td>
                                            <td>${msg.getHumedad()}%</td>
                                        </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                        <#else>
                            <div class="row justify-content-evenly">
                                <div class="col-md-4 offset-md-1">
                                    <h4 style="color: whitesmoke">No data</h4>
                                </div>
                            </div>
                        </#if>
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
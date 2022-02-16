<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'castle.label', default: 'Castle')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <link rel='stylesheet' type='text/css' href='https://api.tomtom.com/maps-sdk-for-web/cdn/6.x/6.15.0/maps/maps.css'>
        <script src="https://api.tomtom.com/maps-sdk-for-web/cdn/6.x/6.15.0/maps/maps-web.min.js"></script>
    </head>
    <body>
        <a href="#list-castle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <!--Div do mapa-->
        <div id="list-castle" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${castleList}" />
            <h1> Teste </h1>
            <div>
                <div id="map" style="width: 100%; height: 100%;">map</div>
                <script>
                    var map = tt.map({
                        key: "9qS0UDvMv0IMnr4b0Gw7p2mxDQQiXroQ",
                        container: "map",
                        zoom: 3});
                        $.getJSON('castle/index.json').done(function(data){
                            $.each(data, function(i, coords){
                                var marker = new tt.Marker()
                                .setLngLat([coords.longitude, coords.latitude)
                                .addTo(map);}
                            }))
                </script>
            </div>

            <div class="pagination">
                <g:paginate total="${castleCount ?: 0}" />
            </div>
        </div>
    </body>
</html>
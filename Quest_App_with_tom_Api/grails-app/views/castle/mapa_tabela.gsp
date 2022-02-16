<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="layout" content="main"/>
     <g:set var="entityName" value="${message(code: 'castle.label', default: 'Castle')}" />
    <title>Mapa</title>
    <link rel='stylesheet' type='text/css' href='https://api.tomtom.com/maps-sdk-for-web/cdn/6.x/6.15.0/maps/maps.css'>
    <script src="https://api.tomtom.com/maps-sdk-for-web/cdn/6.x/6.15.0/maps/maps-web.min.js"></script>
    <asset:javascript src='jquery-2.2.0.min.js'/>
    <script>(function(){ window.SS = window.SS || {}; SS.Require = function (callback){ if (typeof callback === 'function') { if (window.SS && SS.EventTrack) { callback(); } else { var siteSpect = document.getElementById('siteSpectLibraries'); var head = document.getElementsByTagName('head')[0]; if (siteSpect === null && typeof head !== 'undefined') { siteSpect = document.createElement('script'); siteSpect.type = 'text/javascript';siteSpect.src = '/__ssobj/core.js+ssdomvar.js+generic-adapter.js';siteSpect.async = true; siteSpect.id = 'siteSpectLibraries'; head.appendChild(siteSpect); } if (window.addEventListener){ siteSpect.addEventListener('load', callback, false); } else { siteSpect.attachEvent('onload', callback, false); } } } };})(); </script>
</head>
<body>
    <div>
        <a href="#list-castle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
    </div>

    <div id="map" style="width: 100%; height: 50%;"></div>
    <script>
        var map = tt.map({
            key: "9qS0UDvMv0IMnr4b0Gw7p2mxDQQiXroQ",
            container: "map",
            zoom: 3});
            console.log('Teste aquiccccccccccccccccccccccccccccccccc')
           
            const xhr = new XMLHttpRequest();
            xhr.onreadystatechange = () => {
                if (xhr.readyState === XMLHttpRequest.DONE){
                    console.log(typeof xhr.responseText);
                    console.log(xhr.responseText);
                    const parser = new DOMParser();
                    const texto = xhr.responseText;
                    console.log(texto);
                    var xmlDoc = $.parseXML(texto); 

                    var $xml = $(xmlDoc);

                    var $castle = $xml.find("castle");

                    $castle.each(function(){

                        var long = $(this).find('longitude').text(),
                            lat = $(this).find('latitude').text();

                        console.log(typeof long);
                        console.log(typeof lat);

                        var marker = new tt.Marker()
                            .setLngLat([parseFloat(long), parseFloat(lat)])
                            .addTo(map);

                        });
                    };
            };
            xhr.open('GET', '/castle/pegar_json.xml', true);
            xhr.setRequestHeader('Accept', 'application/xml');
            xhr.send(null);

    </script>
    <div> 
        <f:table collection = "${dados}"/>
    </div>
</body>
</html>
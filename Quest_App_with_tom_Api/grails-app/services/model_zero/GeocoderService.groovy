package model_zero

import grails.gorm.transactions.Transactional

@Transactional
class GeocoderService {
    public static final String BaseURL = 'https://api.tomtom.com/search/2/geocode/'
    def fillCoords(Castle castle) {
        String encoded = [castle.city, castle.state].collect{
            URLEncoder.encode(it,'UTF-8')}.join(',')
        
        def resposta = new XmlSlurper().parse("${BaseURL}${encoded}.xml?key=9qS0UDvMv0IMnr4b0Gw7p2mxDQQiXroQ")
        def location = resposta.results.item[0].position
        castle.latitude = location.lat.toDouble()
        castle.longitude = location.lon.toDouble()
        return castle

    }
}

/*
Este service primeiro cria uma url que acessa a api da tomtom para o geocoder
- o geocoder eh uma api capaz de retornar um xml ou json com os dados de 
longitude e latitude, desde que sejam passados parms na url como nome da cidade,
provincia, pais e a chave de acesso a api.

formato 
https://api.tomtom.com/search/2/[geocode/cidade,estado].[xml]?[chave_da_api]

na parte onde vem xlm pode ser json tambem
os parenteses retos nao entram na url (apenas ilustrando)

A funcao fillCoord recebe como parametro uma instancia da classe castle
e extrai os atributos city e state da classe castle e armazena numa lista (que chamei de encoded)
de seguida usei uma clojure do tipo colect para colectar os dados da lista e transformar cada item
da lista em uma string no formato utf-8 com ajuda do metodo URLEncoder do java. depois
apliquei o metodo join na string para juntar os itens com uma virgula (veja o campo da url
onde tem cidade, estado eh separado por virgula)

Depois juntei a BaseURL com a string formado com a funcao fillcoord para formar a url no formato
acima.

passei essa url para o metodo parse do objecto XmlSlurper() - que vai baixar o xml e armazenar
na variavel resposta

depois usei a estrutura hierarquica do xml para acessar a longitude e latitude
passei a longitude para o campo longitude da classe castle e o mesmo para latitude (converti para
double)
*/
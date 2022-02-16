package model_zero

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CastleController {
    def geocoderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Castle.list(params), model:[castleCount: Castle.count()]
    }

    def show(Castle castle) {
        respond castle
    }

    def create() {
        respond new Castle(params)
    }

    @Transactional
    def save(Castle castle) {
        if (castle == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (castle.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond castle.errors, view:'create'
            return
        }

        geocoderService.fillCoords(castle) //Para salval as coordenadas automatocamente
        castle.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'castle.label', default: 'Castle'), castle.id])
                redirect castle
            }
            '*' { respond castle, [status: CREATED] }
        }
    }

    def edit(Castle castle) {
        respond castle
    }

    @Transactional
    def update(Castle castle) {
        if (castle == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (castle.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond castle.errors, view:'edit'
            return
        }
        geocoderService.fillCoords(castle) // Service - Para salva automatocamente as coordenadas
        castle.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'castle.label', default: 'Castle'), castle.id])
                redirect castle
            }
            '*'{ respond castle, [status: OK] }
        }
    }

    @Transactional
    def delete(Castle castle) {

        if (castle == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        castle.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'castle.label', default: 'Castle'), castle.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    @Transactional
    def pegar_json(Integer max){
        params.max = Math.min(max?:10,100)
        respond Castle.list(params), model:[castleCount:Castle.count()]
    }

    @Transactional
    def mapa_tabela(){
        def caixa = Castle.list()
        [dados:caixa]
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'castle.label', default: 'Castle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

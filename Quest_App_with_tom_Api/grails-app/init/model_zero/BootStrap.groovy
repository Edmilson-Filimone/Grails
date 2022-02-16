package model_zero
import model_zero.Quest
import model_zero.Castle

class BootStrap {
    def geocoderService

    def init = { servletContext ->
        Quest q = new Quest(name:'Keep the door closed')
            .addToTasks(name:'Call someone to lock out the door', priority:4, completed:true)
            .addToTasks(name:'Dont run away', priority:5, completed:false)
            .addToTasks(name:'Kill all the mosquitos', priority:4, completed:true)
            .save(failOnError:true)
        /*Castle britania = new Castle(name:'Britania', city:'Xai-Xai', state:'Gaza')
            .addToKnights(title:'King', name:'Artur', quest:q)
            .addToKnights(title:'Queen', name:'Marlin', quest:q)
            .addToKnights(title:'Sir', name:'Domas', quest:q)
        geocoderService.fillCoord(britania) //service
            .save(failOnError:true)
        Castle nortumbia = new Castle(name:'Nortumbia', city:'Maxixe', state:'Inhambane')
            .addToKnights(title:'King', name:'Germa', quest:q)
            .addToKnights(title:'Queen', name:'Veronica', quest:q)
            .addToKnights(title:'Sir', name:'Mirano', quest:q)
        geocoderService.fillCoord(nortumbia) //service
            .save(failOnError:true)*/

    }
    def destroy = {
    }
}

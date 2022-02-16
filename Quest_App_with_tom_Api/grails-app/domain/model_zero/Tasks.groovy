package model_zero

class Tasks {
    String name
    int priority =3
    Date startDate = new Date()
    Date endDate = new Date()
    boolean completed

    static belongsTo = [quest: Quest]
    /* Cada tarefa pertence a uma missao*/

    static constraints = {
        name blank: false 
        priority range: 1..5
        startDate()
        endDate validator: {val, tasks -> val >= tasks.startDate} /*Garante que a data de fim seja 
        maior ou igual a data de inicio da tarefa*/
        completed()

    }
}

/*Classe Tasks ou tarefas, eh uma extensao da classe missao
Cada tarefa tem um nome
prioridade da tarefa
data de inicio
data de fim 
e status de completude da tarefa*/
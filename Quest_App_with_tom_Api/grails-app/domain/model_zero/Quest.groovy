package model_zero

class Quest {
    
    /*Quest - Missao*/
    
    String name
    String toString() {name}
    
    static hasMany = [tasks: Tasks]
    static constraints = {name blank:false
    }
}

/* Classe Quest ou Missao, tem um atributo nome que
se refere ao nome de cada missao

toString(){name} - garante que o grails represente o atriuto
name corretamente

Uma missao pode ter varias tarefas, por isso
temos como classe filha 'Task'(no bloco hasMany) que armazena 
os dados de cada  - aqui teremos o cascate delete ou seja se 
a classe quest/ missao for apagada a Task/tarefa automaticamente sera
apagada e por isso incluimos o 'belongsTo = [Quest]' na classe Task
(Relacionamento bi-direcional com cascate delete)
*/
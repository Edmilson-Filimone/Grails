package model_zero

class Knight {
    String name
    String title
    Castle castle

    static hasMany = [quest:Quest, tasks: Tasks]
    static constraints = {
        title inList:['Sir','Lord', 'Lady', 'King', 'Queen', 'Duke', 'Barano', 'Conde']
        name blank:false
        quest nullable:true
        castle nullable:true
        tasks nullable:true
    }
}

/*Classe Knight ou cavaleiros
cada cavaleiro tem um nome
um titulo
e pode pertencer a um castelo (neste caso e um relacionamento bi-direcional [tambem apontamos 
para a classe cavaleiro la na classe Castle com o hasMany]
sem cascate delete porque o cavaleiro pode existir mesmo sem o castelo
e deste modo nao incluimos o belongsTo (que forca a cascata))

o cavaleiro pode receber varias missoes que por sua
vez tem varias tarefas (casta)

/CONTRAINS
os titulos de cada cavaleiro estao na lista fornecida
quest nullable:true e task nullable:true - o campo missao pode ser nullo
porque o cavaleiro pode estar sem nehuma missao e automaticamente
o campo task deve ser nullo poruque task pertence a quest
se o cavaleiro esta sem missao entao nao tem nenhuma tarefa
*/

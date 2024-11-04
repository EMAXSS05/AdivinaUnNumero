import kotlin.random.Random
const val CYAN = "\u001B[36m"
fun main() {
    println(CYAN)
    var lista= mutableListOf<String>("1.Jugar","2.Ver Traza de último intento", "3.Salir")
    //var num_aleatorio=Random.nextInt(1000,10000)
    /*var l=(1.. 6).toList()
    l=l.shuffled()
    println(l)
    var nSecreto=""
    for(i in 0 until 4){
        nSecreto+=l[i]
    }
    println(nSecreto)*/
    println(lista[0])
    println(lista[1])
    println(lista[2])
    print("Opción: ")
    var entrada=readln().toInt()
    while(entrada!=null){
        if(entrada==1) {
            var l = (1..6).toList()
            l = l.shuffled()
            println(l)
            var nSecreto = ""
            for (i in 0 until 4) {
                nSecreto += l[i]
            }
            var comparacion = nSecreto
            print("Teclea un numero de 4 cifras sin números repetidos:")
            var numero_usuario = readln()

        }
    }
}
import kotlin.random.Random
const val CYAN = "\u001B[36m"
fun main() {
    println(CYAN)
    var lista= mutableListOf<String>("1.Jugar","2.Ver Traza de último intento", "3.Salir")
    var num_aleatorio=Random.nextInt(1000,10000)
    println(lista[0])
    println(lista[1])
    println(lista[2])
    print("Opción: ")
    var entrada=readln().toInt()
    while(entrada!=null){
        if(entrada==1){
            println()
            var numero_usuario= readln()
        }

    }
}
const val CYAN = "\u001B[36m"
fun main() {
    println(CYAN)
    var numeroSecreto = generarNumeroSecreto()
    var intentos = mutableListOf<String>()

    while (true) {
        println("1. Jugar")
        println("2. Ver traza de último intento")
        println("3. Salir")
        print("Opción: ")
        val entrada = readln().toInt()

        if (entrada == 1){
            intentos = mutableListOf()
            jugar(numeroSecreto, intentos)
        } else if (entrada == 2) {
            mostrarIntentos(intentos, numeroSecreto)
        } else if (entrada == 3) {
            println("Gracias por jugar")
            break
        } else {
            println("Opción no válida, intenta de nuevo")
        }
    }
}

fun generarNumeroSecreto(): String {
    val lista = (1..6).toList().shuffled()
    var numeroSecreto = ""
    for (i in 0 until 4) {
        numeroSecreto += lista[i]
    }
    return numeroSecreto
}

fun jugar(numeroSecreto: String, intentos: MutableList<String>) {
    val maxIntentos = 10

    for (intentoActual in 1..maxIntentos) {
        print("Teclea un número de 4 cifras sin números repetidos: ")
        val entradaDeUsuario = readln()

        if (esEntradaInvalida(entradaDeUsuario)) {
            println("Entrada inválida. Asegúrate de que el número tenga 4 cifras únicas entre 1 y 6.")
            continue
        }

        intentos.add(entradaDeUsuario)

        val aciertos = intArrayOf(0)
        val coincidencias = intArrayOf(0)
        compararNumeros(entradaDeUsuario, numeroSecreto, aciertos, coincidencias)

        if (aciertos[0] == 4) {
            println("¡Felicidades! Adivinaste el número correctamente: $numeroSecreto")
            break
        } else {
            println("Aciertos: ${aciertos[0]}, Coincidencias: ${coincidencias[0]}")
        }
    }

    println("Fin del juego. El número secreto era: $numeroSecreto")
}

fun esEntradaInvalida(entrada: String): Boolean {
    // Verifica que la longitud sea 4
    if (entrada.length != 4) return true

    // Verifica que todos los caracteres estén en el rango '1' a '6'
    for (i in 0 until entrada.length) {
        if (entrada[i] !in '1'..'6') return true
    }

    // Verifica si hay cifras repetidas
    for (i in 0 until entrada.length) {
        for (j in i + 1 until entrada.length) {
            if (entrada[i] == entrada[j]) return true
        }
    }
    return false
}

fun compararNumeros(entrada: String, secreto: String, aciertos: IntArray, coincidencias: IntArray) {
    var aciertosTemp = 0
    var coincidenciasTemp = 0

    for (i in 0 until 4) {
        if (entrada[i] == secreto[i]) {
            aciertosTemp++
        } else {
            for (j in 0 until 4) {
                if (entrada[i] == secreto[j] && i != j) {
                    coincidenciasTemp++
                    break
                }
            }
        }
    }

    aciertos[0] = aciertosTemp
    coincidencias[0] = coincidenciasTemp
}

fun mostrarIntentos(intentos: List<String>, numeroSecreto: String) {
    if (intentos.size == 0) {
        println("No hay intentos previos para mostrar.")
    } else {
        for (i in 0 until intentos.size) {
            val intento = intentos[i]
            val aciertos = intArrayOf(0)
            val coincidencias = intArrayOf(0)
            compararNumeros(intento, numeroSecreto, aciertos, coincidencias)
            println("Intento ${i + 1}: $intento, Aciertos: ${aciertos[0]}, Coincidencias: ${coincidencias[0]}")
        }
    }
}
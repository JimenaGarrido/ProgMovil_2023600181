fun main() {

    var seleccion:Int // Opción del menú
    val entrada = Scanner(System.`in`) // Scanner para leer datos

    do  {
        // Menú de opciones
        println("""
        Hola, elige una opción:
        1. Calcular suma de tres valores
        2. Registrar nombre
        3. Cálculo de tiempo desde nacimiento
        0. Salir
        """.trimIndent())

        seleccion = entrada.nextInt() // Leer opción

        when (seleccion) {
            1 -> {
                calcularSuma()
            }
            2 -> {
                registrarNombre()
            }
            3 -> {
                calcularTiempoDesdeNacimiento()
            }
            0 -> {
                println("Hasta luego!")
            } else -> {
            println("Elige una opción válida")
        }
        }
    } while(seleccion != 0) // Finaliza el programa
}

fun calcularSuma() {
    val entrada = Scanner(System.`in`)
    try {
        println("Introduce tres números:")
        val valor1 = entrada.nextDouble()
        val valor2 = entrada.nextDouble()
        val valor3 = entrada.nextDouble()

        val resultado = valor1 + valor2 + valor3
        println("El resultado de la suma es: $resultado")

    } catch (e: InputMismatchException) {
        println("Por favor, introduce números válidos")
        calcularSuma()
    }
}

fun registrarNombre() {
    println("Por favor, introduce tu nombre:")
    val entrada = Scanner(System.`in`)
    val nombreUsuario = entrada.nextLine()
    println("Tu nombre registrado es: $nombreUsuario")
}

fun calcularTiempoDesdeNacimiento() {
    val formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
    val entrada = Scanner(System.`in`)

    println("""
        Ingresa tu fecha de nacimiento con el formato Día-Mes-Año
    """.trimIndent())

        val fechaIngresada: String = entrada.next()
        val fechaNacimiento = LocalDateTime.parse("$fechaIngresada 00:00:00", formato)

        val meses = ChronoUnit.MONTHS.between(fechaNacimiento, LocalDateTime.now())
        val semanas = ChronoUnit.WEEKS.between(fechaNacimiento, LocalDateTime.now())
        val dias = ChronoUnit.DAYS.between(fechaNacimiento, LocalDateTime.now())
        val horas = ChronoUnit.HOURS.between(fechaNacimiento, LocalDateTime.now())
        val minutos = ChronoUnit.MINUTES.between(fechaNacimiento, LocalDateTime.now())
        val segundos = ChronoUnit.SECONDS.between(fechaNacimiento, LocalDateTime.now())

        println(
            """
        Desde tu nacimiento en $fechaNacimiento han transcurrido:
        $meses ${if (meses.toInt() == 1) "mes" else "meses"}
        $semanas ${if (semanas.toInt() == 1) "semana" else "semanas"}
        $dias ${if (dias.toInt() == 1) "día" else "días"}
        $horas horas
        $minutos minutos
        $segundos segundos
            """.trimIndent()
        )
}

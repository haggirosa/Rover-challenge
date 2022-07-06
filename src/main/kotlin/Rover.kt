import Direction as Direction

class Rover(
   var position: Position = Position()


) {

    fun print() {

        println("${position.print()}")
    }

    fun control(command: Command): Position {
        when (command) {
            Command.L -> position.left()
            //println("Spin 90 degrees left")

            Command.R -> position.right()
            //println("Spin 90 degrees right")

            Command.M -> position.move()
            //println("Move forward one grid point")

            else -> {
                print("Command not implemented")
            }
        }
        return this.position
    }

    companion object {

        @JvmStatic
        fun instruction(value: String): Rover {

            var listInstruction = value.split(",")
            if (listInstruction.size !== 2) {
                throw Exception("Necessário que as posições e os comandos sejam separados por ',': {posições},{comandos}")
            }
            var strInitialPosition = listInstruction[0]
            var strCommand = listInstruction[1]
            var listPosition = strInitialPosition.split(" ").filter { it.isNotBlank() }
            if (listPosition.size !== 3) {
                throw Exception("Necessário ter o valor: x y direction")
            }

            if ( listPosition[0].toIntOrNull() == null) {
                throw Exception("Valor de position x inválida '${listPosition[0]}', necessário ser apenas números inteiros")
            }

            var x = listPosition[0].toInt()

            if ( listPosition[1].toIntOrNull() == null) {
                throw Exception("Valor de position y inválida '${listPosition[1]}', necessário ser apenas números inteiros")
            }

            var y = listPosition[1].toInt()

            if (listPosition[2] != Direction.W.toString() && listPosition[2] != Direction.E.toString() && listPosition[2] != Direction.N.toString() && listPosition[2] != Direction.S.toString())
            {
                throw Exception("Valor inválido '${listPosition[2]}', necessário ser apenas as direções 'N, W, S, E'")
            }
            var direction = Direction.valueOf(listPosition[2])

            var position = Position(x, y, direction)
            var rover = Rover(position)

            val listCommand = strCommand.map { it.toString() }.filter { it.isNotBlank() }



            for (strCommand in listCommand) {

                if (strCommand != Command.L.toString() && strCommand != Command.R.toString() && strCommand != Command.M.toString())  {
                    throw Exception("Comando inválido '${strCommand}', necessário ser apenas os comandos 'M, R, L")
                }
                var command = Command.valueOf(strCommand)

                rover.control(command)
            }
            return rover
        }
    }
}


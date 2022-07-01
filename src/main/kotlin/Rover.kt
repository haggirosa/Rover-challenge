import java.lang.reflect.Field

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

    fun instruction(value: String) {

        var listInstruction: List<String> = value.split(", ")
        var strInitialPosition = listInstruction[0]
        var strCommand = listInstruction [1]
        var xyString = strInitialPosition!!.split(" ")
        var x = xyString[0].toInt()
        var y = xyString[1].toInt()
        var direction = Direction.valueOf(xyString[2])
        var position = Position(x, y, direction)
        var rover = Rover(position)
        rover.print()

        val listStr: List<String> = strCommand.map { it.toString() }

        for (strCommand in listStr) {
            println(strCommand)
            var command = Command.valueOf(strCommand)

            rover.control(command)
            rover.print()
        }
    }
}

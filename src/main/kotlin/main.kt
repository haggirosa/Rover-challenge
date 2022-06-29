

fun main() {
    var initialPosition: Position = Position(3, 3, Direction.E)
    var rover: Rover = Rover(initialPosition)

    println("start")
    rover.print()
    rover.control(command = Command.M)
    rover.print()
    rover.control(command = Command.M)
    rover.print()
    rover.control(command = Command.R)
    rover.print()
    rover.control(command = Command.M)
    rover.print()
    rover.control(command = Command.M)
    rover.print()
    rover.control(command = Command.R)
    rover.print()
    rover.control(command = Command.M)
    rover.print()
    rover.control(command = Command.R)
    rover.print()
    rover.control(command = Command.R)
    rover.control(command = Command.M)
    rover.print()

}


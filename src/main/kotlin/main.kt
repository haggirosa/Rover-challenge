

fun main() {
    var initialPosition: Position = Position(3, 3, Direction.E)
    var rover: Rover = Rover(initialPosition)


    println("start")

    rover.instruction("3 3 E, MMRMMRMRRM")


}


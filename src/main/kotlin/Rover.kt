class Rover(
   var position: Position = Position()


) {

    fun print(){

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
}

 class Position(
    var x: Int = 0,
    var y: Int = 0,
    var direction: Direction = Direction.N
) {
     fun print() {
         println("${this.x} ${this.y} ${this.direction}")
     }

     fun left() {
         when (direction) {
             Direction.N -> direction = Direction.W
             Direction.W -> direction = Direction.S
             Direction.S -> direction = Direction.E
             Direction.E -> direction = Direction.N
         }
     }

     fun right() {
         when (direction) {
             Direction.N -> direction = Direction.E
             Direction.E -> direction = Direction.S
             Direction.S -> direction = Direction.W
             Direction.W -> direction = Direction.N
         }
     }

     fun move() {
         when (direction) {
             Direction.N -> y += 1
             Direction.W -> x -= 1
             Direction.S -> y -= 1
             Direction.E -> x += 1
         }
     }
 }



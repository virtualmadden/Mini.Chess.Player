fun main(args: Array<String>) {
    val argsLength = args.size

    val board = Board()
    val state = State()

    if (argsLength == 0) {
        board.createBoard()
        state.print()

        while (!state.gameOver()) {
            state.bestMove()
            state.print()
        }
    } else if (argsLength == 2) {
        if (args[0] == "-b" || args[0] == "-w") {
            board.createBoard()

            if (args[0] == "-b") {
                if (args[1] == "-s") {
                    while (!state.gameOver()) {
                        state.serverMove()

                        if (state.gameOver())
                            break

                        state.bestMove()
                    }
                } else if (args[1] == "-h") {
                    state.print()

                    while (!state.gameOver()) {
                        state.bestMove()
                        state.print()

                        state.humanMove()
                        state.print()
                    }
                } else
                    println("Error: Incorrect arguments.")
            } else if (args[0] == "-w") {
                if (args[1] == "-s") {
                    while (!state.gameOver()) {
                        state.bestMove()
                        state.print()

                        if (state.gameOver())
                            break

                        state.serverMove()
                        state.print()
                    }
                } else if (args[1] == "-h") {
                    state.print()

                    while (!state.gameOver()) {
                        state.humanMove()
                        state.print()

                        state.bestMove()
                        state.print()
                    }
                } else
                    println("Error: Incorrect arguments.")
            } else
                println("Error: Incorrect arguments.")
        } else
            println("Error: Incorrect arguments.")

    } else
        println("Error: To few arguments.")
}
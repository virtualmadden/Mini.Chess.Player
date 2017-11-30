class Board {
    internal fun createBoard() {
        var row: Int
        var col: Int

        State.moves = 0
        State.turn = 'W'

        board[0][0] = 'k'
        board[0][1] = 'q'
        board[0][2] = 'b'
        board[0][3] = 'n'
        board[0][4] = 'r'

        col = 0
        while (col < 5) {
            row = 1
            board[row][col] = 'p'
            col++
        }

        row = 2
        while (row < 4) {
            col = 0
            while (col < 5) {
                board[row][col] = '.'
                col++
            }
            row++
        }

        col = 0
        while (col < 5) {
            row = 4
            board[row][col] = 'P'
            col++
        }

        board[5][0] = 'R'
        board[5][1] = 'N'
        board[5][2] = 'B'
        board[5][3] = 'Q'
        board[5][4] = 'K'

        initPieceCount()
    }

    private fun initPieceCount() {
        State.wKing = 1
        State.wQueen = 1
        State.wRook = 1
        State.wBishop = 1
        State.wKnight = 1
        State.wPawn = 5

        State.bKing = 1
        State.bQueen = 1
        State.bRook = 1
        State.bBishop = 1
        State.bKnight = 1
        State.bPawn = 5
    }

    internal fun readBoard() {
        createPieceCount()
    }

    private fun createPieceCount() {
        for (row in 0..5) {
            for (col in 0..4) {
                when {
                    board[row][col] == 'k' -> State.bKing++
                    board[row][col] == 'q' -> State.bQueen++
                    board[row][col] == 'b' -> State.bBishop++
                    board[row][col] == 'n' -> State.bKnight++
                    board[row][col] == 'r' -> State.bRook++
                    board[row][col] == 'p' -> State.bPawn++
                    board[row][col] == 'K' -> State.wKing++
                    board[row][col] == 'Q' -> State.wQueen++
                    board[row][col] == 'B' -> State.wBishop++
                    board[row][col] == 'N' -> State.wKnight++
                    board[row][col] == 'R' -> State.wRook++
                    board[row][col] == 'P' -> State.wPawn++
                }
            }
        }
    }

    companion object {
        var board = Array(6) { CharArray(5) }

        val coordinate: Array<Array<String>> = arrayOf(
                arrayOf("a6", "b6", "c6", "d6", "e6"),
                arrayOf("a5", "b5", "c5", "d5", "e5"),
                arrayOf("a4", "b4", "c4", "d4", "e4"),
                arrayOf("a3", "b3", "c3", "d3", "e3"),
                arrayOf("a2", "b2", "c2", "d2", "e2"),
                arrayOf("a1", "b1", "c1", "d1", "e1")
        )
    }
}

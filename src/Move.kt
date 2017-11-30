class Move {
    internal fun toSquare(row: Int, col: Int) {
        when {
            Board.board[row][col] == 'k' -> State.bKing--
            Board.board[row][col] == 'q' -> State.bQueen--
            Board.board[row][col] == 'b' -> State.bBishop--
            Board.board[row][col] == 'n' -> State.bKnight--
            Board.board[row][col] == 'r' -> State.bRook--
            Board.board[row][col] == 'p' -> State.bPawn--
            Board.board[row][col] == 'K' -> State.wKing--
            Board.board[row][col] == 'Q' -> State.wQueen--
            Board.board[row][col] == 'B' -> State.wBishop--
            Board.board[row][col] == 'N' -> State.wKnight--
            Board.board[row][col] == 'R' -> State.wRook--
            Board.board[row][col] == 'P' -> State.wPawn--
        }
    }

    internal fun pawnQueen(row: Int, col: Int) {
        if (Board.board[row][col] == 'P') {
            State.wQueen++
            State.wPawn--

            println("*******************************************")
        } else if (Board.board[row][col] == 'p') {
            State.bQueen++
            State.bPawn--

            println("*******************************************")
        }
    }

    internal fun fromSquare(row: Int, col: Int) {
        when {
            Board.board[row][col] == 'k' -> State.bKing++
            Board.board[row][col] == 'q' -> State.bQueen++
            Board.board[row][col] == 'b' -> State.bBishop++
            Board.board[row][col] == 'n' -> State.bKnight++
            Board.board[row][col] == 'r' -> State.bRook++
            Board.board[row][col] == 'p' -> State.bPawn++
            Board.board[row][col] == 'K' -> State.wKing++
            Board.board[row][col] == 'Q' -> State.wQueen++
            Board.board[row][col] == 'B' -> State.wBishop++
            Board.board[row][col] == 'N' -> State.wKnight++
            Board.board[row][col] == 'R' -> State.wRook++
            Board.board[row][col] == 'P' -> State.wPawn++
        }
    }
}

class Square {
    internal fun onBoard(row: Int, col: Int): Boolean {
        return if (row in 0..5) {
            col in 0..4
        } else
            false
    }

    internal fun blocked(row: Int, col: Int): Boolean {
        return when {
            State.turn == 'W' -> when {
                Board.board[row][col] == 'K' -> true
                Board.board[row][col] == 'Q' -> true
                Board.board[row][col] == 'B' -> true
                Board.board[row][col] == 'N' -> true
                Board.board[row][col] == 'R' -> true
                else -> Board.board[row][col] == 'P'
            }
            State.turn == 'B' -> when {
                Board.board[row][col] == 'k' -> true
                Board.board[row][col] == 'q' -> true
                Board.board[row][col] == 'b' -> true
                Board.board[row][col] == 'n' -> true
                Board.board[row][col] == 'r' -> true
                Board.board[row][col] == 'p' -> true
                else -> false
            }
            else -> false
        }
    }

    internal fun pawnBlocked(row: Int, col: Int): Boolean {
        return when {
            Board.board[row][col] == 'K' -> true
            Board.board[row][col] == 'Q' -> true
            Board.board[row][col] == 'B' -> true
            Board.board[row][col] == 'N' -> true
            Board.board[row][col] == 'R' -> true
            Board.board[row][col] == 'P' -> true
            Board.board[row][col] == 'k' -> true
            Board.board[row][col] == 'q' -> true
            Board.board[row][col] == 'b' -> true
            Board.board[row][col] == 'n' -> true
            Board.board[row][col] == 'r' -> true
            Board.board[row][col] == 'p' -> true
            else -> false
        }
    }
}

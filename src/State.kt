import java.io.*
import java.util.*

class State {
    private var startTime: Long = 0
    private var endTime: Long = 0
    private var totalTime = 5f

    private var pieceFrom: Char = 0.toChar()
    private var pieceTo: Char = 0.toChar()

    private var moveHist = ArrayList<MutableList<String>>()
    private var moveTemp = ArrayList<MutableList<String>>()

    interface Constants {
        companion object {
            val QUEEN = 9
            val ROOK = 5
            val BISHOP = 3
            val KNIGHT = 3
            val PAWN = 1
        }
    }

    private fun moveGen(moveList: ArrayList<MutableList<String>>) {
        for (row in 0..5) {
            for (col in 0..4) {
                if (turn == 'W') {
                    when {
                        Board.board[row][col] == 'K' -> kingMove(row, col, moveList)
                        Board.board[row][col] == 'Q' -> {
                            diagonalMove(row, col, moveList)
                            straightMove(row, col, moveList)
                        }
                        Board.board[row][col] == 'B' -> {
                            diagonalMove(row, col, moveList)
                            bishopMove(row, col, moveList)
                        }
                        Board.board[row][col] == 'N' -> knightMove(row, col, moveList)
                        Board.board[row][col] == 'R' -> straightMove(row, col, moveList)
                        Board.board[row][col] == 'P' -> pawnMove(row, col, moveList)
                    }
                } else if (turn == 'B') {
                    when {
                        Board.board[row][col] == 'k' -> kingMove(row, col, moveList)
                        Board.board[row][col] == 'q' -> {
                            diagonalMove(row, col, moveList)
                            straightMove(row, col, moveList)
                        }
                        Board.board[row][col] == 'b' -> {
                            diagonalMove(row, col, moveList)
                            bishopMove(row, col, moveList)
                        }
                        Board.board[row][col] == 'n' -> knightMove(row, col, moveList)
                        Board.board[row][col] == 'r' -> straightMove(row, col, moveList)
                        Board.board[row][col] == 'p' -> pawnMove(row, col, moveList)
                    }
                }
            }
        }
    }

    private fun straightMove(row: Int, col: Int, moveList: ArrayList<MutableList<String>>) {
        var x: Int = row + 1
        var y: Int = col

        val square = Square()

        while (square.onBoard(x, y)) {
            if (!square.pawnBlocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)
            } else if (square.pawnBlocked(x, y) && !square.blocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)

                break
            } else
                break

            x += 1
        }

        x = row - 1
        y = col

        while (square.onBoard(x, y)) {
            if (!square.pawnBlocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)
            } else if (square.pawnBlocked(x, y) && !square.blocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)

                break
            } else
                break

            x -= 1
        }

        x = row
        y = col + 1

        while (square.onBoard(x, y)) {
            if (!square.pawnBlocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)
            } else if (square.pawnBlocked(x, y) && !square.blocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)

                break
            } else
                break

            y += 1
        }

        x = row
        y = col - 1

        while (square.onBoard(x, y)) {
            if (!square.pawnBlocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)
            } else if (square.pawnBlocked(x, y) && !square.blocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)

                break
            } else
                break

            y -= 1
        }
    }

    private fun diagonalMove(row: Int, col: Int, moveList: ArrayList<MutableList<String>>) {
        var x: Int = row + 1
        var y: Int = col + 1

        val square = Square()

        while (square.onBoard(x, y)) {
            if (!square.pawnBlocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)
            } else if (square.pawnBlocked(x, y) && !square.blocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)

                break
            } else
                break

            x += 1
            y += 1
        }

        x = row + 1
        y = col - 1

        while (square.onBoard(x, y)) {
            if (!square.pawnBlocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)
            } else if (square.pawnBlocked(x, y) && !square.blocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)

                break
            } else
                break

            x += 1
            y -= 1
        }

        x = row - 1
        y = col + 1

        while (square.onBoard(x, y)) {
            if (!square.pawnBlocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)
            } else if (square.pawnBlocked(x, y) && !square.blocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)

                break
            } else
                break

            x -= 1
            y += 1
        }

        x = row - 1
        y = col - 1

        while (square.onBoard(y, x)) {
            if (!square.pawnBlocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)
            } else if (square.pawnBlocked(x, y) && !square.blocked(x, y)) {
                val genMove: MutableList<String> = mutableListOf()

                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[x][y])
                moveList.add(genMove)

                break
            } else
                break

            x -= 1
            y -= 1
        }
    }

    private fun bishopMove(row: Int, col: Int, moveList: ArrayList<MutableList<String>>) {
        val square = Square()

        if (square.onBoard(row + 1, col) && !square.pawnBlocked(row + 1, col)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row + 1][col])
            moveList.add(genMove)
        }
        if (square.onBoard(row, col + 1) && !square.pawnBlocked(row, col + 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row][col + 1])
            moveList.add(genMove)
        }
        if (square.onBoard(row - 1, col) && !square.pawnBlocked(row - 1, col)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row - 1][col])
            moveList.add(genMove)
        }
        if (square.onBoard(row, col - 1) && !square.pawnBlocked(row, col - 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row][col - 1])
            moveList.add(genMove)
        }
    }

    private fun kingMove(row: Int, col: Int, moveList: ArrayList<MutableList<String>>) {
        val square = Square()

        if (square.onBoard(row + 1, col) && !square.blocked(row + 1, col)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row + 1][col])
            moveList.add(genMove)
        }
        if (square.onBoard(row, col + 1) && !square.blocked(row, col + 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row][col + 1])
            moveList.add(genMove)
        }
        if (square.onBoard(row - 1, col) && !square.blocked(row - 1, col)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row - 1][col])
            moveList.add(genMove)
        }
        if (square.onBoard(row, col - 1) && !square.blocked(row, col - 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row][col - 1])
            moveList.add(genMove)
        }

        if (square.onBoard(row + 1, col + 1) && !square.blocked(row + 1, col + 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row + 1][col + 1])
            moveList.add(genMove)
        }
        if (square.onBoard(row + 1, col - 1) && !square.blocked(row + 1, col - 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row + 1][col - 1])
            moveList.add(genMove)
        }
        if (square.onBoard(row - 1, col + 1) && !square.blocked(row - 1, col + 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row - 1][col + 1])
            moveList.add(genMove)
        }
        if (square.onBoard(row - 1, col - 1) && !square.blocked(row - 1, col - 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row - 1][col - 1])
            moveList.add(genMove)
        }
    }

    private fun knightMove(row: Int, col: Int, moveList: ArrayList<MutableList<String>>) {
        val square = Square()

        if (square.onBoard(row + 2, col + 1) && !square.blocked(row + 2, col + 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row + 2][col + 1])
            moveList.add(genMove)
        }
        if (square.onBoard(row + 2, col - 1) && !square.blocked(row + 2, col - 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row + 2][col - 1])
            moveList.add(genMove)
        }
        if (square.onBoard(row - 2, col - 1) && !square.blocked(row - 2, col - 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row - 2][col - 1])
            moveList.add(genMove)
        }
        if (square.onBoard(row - 2, col + 1) && !square.blocked(row - 2, col + 1)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row - 2][col + 1])
            moveList.add(genMove)
        }
        if (square.onBoard(row + 1, col + 2) && !square.blocked(row + 1, col + 2)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row + 1][col + 2])
            moveList.add(genMove)
        }
        if (square.onBoard(row + 1, col - 2) && !square.blocked(row + 1, col - 2)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row + 1][col - 2])
            moveList.add(genMove)
        }
        if (square.onBoard(row - 1, col + 2) && !square.blocked(row - 1, col + 2)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row - 1][col + 2])
            moveList.add(genMove)
        }
        if (square.onBoard(row - 1, col - 2) && !square.blocked(row - 1, col - 2)) {
            val genMove: MutableList<String> = mutableListOf()
            genMove.add(Board.coordinate[row][col])
            genMove.add(Board.coordinate[row - 1][col - 2])
            moveList.add(genMove)
        }
    }

    private fun pawnMove(row: Int, col: Int, moveList: ArrayList<MutableList<String>>) {
        val square = Square()

        if (turn == 'W' && Board.board[row][col] == 'P') {
            if (square.onBoard(row - 1, col) && !square.pawnBlocked(row - 1, col)) {
                val genMove: MutableList<String> = mutableListOf()
                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[row - 1][col])
                moveList.add(genMove)
            }
            if (!square.onBoard(row - 1, col)) {
                val genMove: MutableList<String> = mutableListOf()
                genMove.add(Board.coordinate[row][col])
                genMove.add(genMove[0])
                moveList.add(genMove)
            }
            if (square.onBoard(row - 1, col + 1) && square.pawnBlocked(row - 1, col + 1) && !square.blocked(row - 1, col + 1)) {
                val genMove: MutableList<String> = mutableListOf()
                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[row - 1][col + 1])
                moveList.add(genMove)
            }
            if (square.onBoard(row - 1, col - 1) && square.pawnBlocked(row - 1, col - 1) && !square.blocked(row - 1, col - 1)) {
                val genMove: MutableList<String> = mutableListOf()
                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[row - 1][col - 1])
                moveList.add(genMove)
            }
        } else if (turn == 'B' && Board.board[row][col] == 'p') {
            if (square.onBoard(row + 1, col) && !square.pawnBlocked(row + 1, col)) {
                val genMove: MutableList<String> = mutableListOf()
                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[row + 1][col])
                moveList.add(genMove)
            }
            if (!square.onBoard(row + 1, col)) {
                val genMove: MutableList<String> = mutableListOf()
                genMove.add(Board.coordinate[row][col])
                genMove.add(genMove[0])
                moveList.add(genMove)
            }
            if (square.onBoard(row + 1, col + 1) && square.pawnBlocked(row + 1, col + 1) && !square.blocked(row + 1, col + 1)) {
                val genMove: MutableList<String> = mutableListOf()
                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[row + 1][col + 1])
                moveList.add(genMove)
            }
            if (square.onBoard(row + 1, col - 1) && square.pawnBlocked(row + 1, col - 1) && !square.blocked(row + 1, col - 1)) {
                val genMove: MutableList<String> = mutableListOf()
                genMove.add(Board.coordinate[row][col])
                genMove.add(Board.coordinate[row + 1][col - 1])
                moveList.add(genMove)
            }
        }
    }

    private fun score(): Int {
        val wScore: Int
        val bScore: Int
        val moveVal: Int

        if (turn == 'B' && wKing == 0)
            return -26
        else if (turn == 'W' && bKing == 0)
            return 26
        else {
            wScore = wQueen * Constants.QUEEN + wBishop * Constants.BISHOP + wKnight * Constants.KNIGHT + wRook * Constants.ROOK + wPawn * Constants.PAWN
            bScore = bQueen * Constants.QUEEN + bBishop * Constants.BISHOP + bKnight * Constants.KNIGHT + bRook * Constants.ROOK + bPawn * Constants.PAWN

            moveVal = if (turn == 'W')
                wScore - bScore
            else
                bScore - wScore
        }

        return moveVal
    }

    internal fun bestMove() {
        var depth = 3
        var elapsedTime = 0f
        startTime = System.currentTimeMillis()
        endTime = 0

        while (java.lang.Float.compare(elapsedTime, totalTime) < 0) {
            alphaBeta(depth, Integer.MIN_VALUE, Integer.MAX_VALUE)
            endTime = System.currentTimeMillis()

            elapsedTime = (endTime - startTime) / 1000f

            depth++
        }

        println("Depth: " + depth + "\n")

        val result: Int
        val length: Int = moveTemp.size
        result = (Math.random() * (length - 1)).toInt()
        doMove(moveTemp[result])

        val move: MutableList<String>

        move = moveTemp[result]

        println("! " + move[0] + "-" + move[1])

        moveHist.clear()
        moveTemp.clear()
    }

    private fun alphaBeta(depth: Int, alpha: Int, beta: Int): Int {
        var newAlpha = alpha
        val moveList = ArrayList<MutableList<String>>()

        if (depth == 0) {
            return score()
        }

        moveGen(moveList)

        Collections.sort(moveList, MOVE_ORDER)

        if (moveList.size == 0) {
            println("Out of moves.")
        }

        for (x in moveList.indices) {
            endTime = System.currentTimeMillis()
            val elapsedTime = (endTime - startTime) / 1000f
            if (java.lang.Float.compare(elapsedTime, totalTime) > 0)
                break

            doMove(moveList[x])
            moveHist.add(moveList[x])

            val temp = CharArray(2)
            temp[0] = pieceFrom
            temp[1] = pieceTo

            if (moveHist.size == 1 && (wKing == 0 || bKing == 0)) {
                moveTemp.clear()
                moveTemp.add(moveHist[0])

                undoMove(moveTemp[0], temp)
                break
            }

            val value = -alphaBeta(depth - 1, -beta, -newAlpha)

            undoMove(moveList[x], temp)

            if (moveHist.size > 0) {
                var size = moveHist.size
                size -= 1
                if (size < 0)
                    size = 0

                moveHist.removeAt(size)
            }

            if (value >= beta) {
                return beta
            }

            if (value >= newAlpha) {
                if (value == newAlpha) {
                    if (moveHist.size != 0) {
                        moveTemp.add(moveHist[0])
                    }
                } else {
                    if (moveHist.size != 0) {
                        moveTemp.clear()
                        moveTemp.add(moveHist[0])
                    }
                }

                newAlpha = value
            }
        }

        return newAlpha
    }

    private fun doMove(move2: MutableList<String>) {
        var piece: Char = 0.toChar()

        val move = Move()

        for (row in 0..5) {
            for (col in 0..4) {
                val temp: MutableList<String> = move2

                if (Board.coordinate[row][col] == temp[0]) {
                    pieceFrom = Board.board[row][col]
                    piece = Board.board[row][col]
                    Board.board[row][col] = '.'
                }
            }
        }

        for (row in 0..5) {
            for (col in 0..4) {
                val temp: MutableList<String> = move2

                if (Board.coordinate[row][col] == temp[1]) {
                    if (temp[1] === temp[0]) {
                        move.pawnQueen(row, col)

                        if (turn == 'W') {
                            Board.board[row][col] = 'Q'
                            pieceTo = Board.board[row][col]
                            Board.board[row][col] = 'Q'
                        } else if (turn == 'B') {
                            Board.board[row][col] = 'q'
                            pieceTo = Board.board[row][col]
                            Board.board[row][col] = 'q'
                        }
                    } else {
                        move.toSquare(row, col)
                        pieceTo = Board.board[row][col]
                        Board.board[row][col] = piece
                    }
                }
            }
        }

        moves++

        if (turn == 'W')
            turn = 'B'
        else if (turn == 'B')
            turn = 'W'
    }

    private fun undoMove(move2: MutableList<String>, temp2: CharArray) {
        val move = Move()

        for (row in 0..5) {
            for (col in 0..4) if (Board.coordinate[row][col] == move2[1]) {
                Board.board[row][col] = temp2[1]
                move.fromSquare(row, col)
            }
        }

        for (row in 0..5) {
            (0..4)
                    .filter { Board.coordinate[row][it] == move2[0] }
                    .forEach { Board.board[row][it] = temp2[0] }
        }

        moves--

        if (turn == 'W')
            turn = 'B'
        else if (turn == 'B')
            turn = 'W'
    }

    internal fun sortMove(move: MutableList<String>): Int {
        val score = score()

        doMove(move)

        val temp = CharArray(2)
        temp[0] = pieceFrom
        temp[1] = pieceTo

        undoMove(move, temp)

        return score
    }

    internal fun humanMove() {
        var hMove: String? = null

        val converter = InputStreamReader(System.`in`)
        val `in` = BufferedReader(converter)

        var x = 0

        try {
            hMove = `in`.readLine()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val genMove: MutableList<String> = mutableListOf()

        val token = StringTokenizer(hMove!!, "-")

        while (token.hasMoreTokens()) {
            genMove.add(token.nextToken())

            x++
        }

        doMove(genMove)
    }

    internal fun serverMove() {
        var hMove: String? = null

        val converter = InputStreamReader(System.`in`)
        val `in` = BufferedReader(converter)

        var x = 0
        var y = 0

        try {
            hMove = `in`.readLine()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        val temp = arrayOf<String>()

        val token2 = StringTokenizer(hMove!!, " ")

        while (token2.hasMoreTokens()) {
            temp[x] = token2.nextToken()

            y++
        }

        val genMove: MutableList<String> = mutableListOf()

        val token = StringTokenizer(temp[0], "-")

        while (token.hasMoreTokens()) {
            genMove[x] = token.nextToken()

            x++
        }

        doMove(genMove)
    }

    internal fun gameOver(): Boolean {
        return when {
            moves == 40 -> {
                println("= Draw")
                true
            }
            bKing == 0 -> {
                println("= W wins")
                true
            }
            wKing == 0 -> {
                println("= B wins")
                true
            }
            else -> false
        }
    }

    internal fun print() {
        println(moves.toString() + " " + turn)

        for (row in 0..5) {
            for (col in 0..4) {
                print(Board.board[row][col])
            }

            print("\n")
        }

        print("\n")
    }

    companion object {
        var moves: Int = 0
        var turn: Char = ' '

        var wKing = 0
        var wQueen = 0
        var wRook = 0
        var wBishop = 0
        var wKnight = 0
        var wPawn = 0

        var bKing = 0
        var bQueen = 0
        var bRook = 0
        var bBishop = 0
        var bKnight = 0
        var bPawn = 0

        internal val MOVE_ORDER: Comparator<MutableList<String>> = Comparator { e1, e2 ->
            val state = State()

            state.sortMove(e1) - state.sortMove(e2)
        }
    }
}

import java.io.File

fun main() {
    val input = File("day04/in04_all.txt").readLines()

    var board = mutableListOf<List<Char>>()

    for (i in input) {
        board.add(i.toList())
    }

    var counter = 0
    var visited = mutableSetOf<Triple<Int, Int, String>>()

    for (i in 0 until board.size) {
        for (j in 0 until board[i].size) {

            if (j + 3 < board[i].size) {
                val row = board[i][j].toString() + board[i][j+1] + board[i][j+2] + board[i][j+3]
                if (row == "XMAS" || row.reversed() == "XMAS") {
                    val direction = if (row == "XMAS") "row" else "row-rev"
                    if (visited.add(Triple(i, j, direction))) counter++
                }
            }

            if (i + 3 < board.size) {
                val col = board[i][j].toString() + board[i+1][j] + board[i+2][j] + board[i+3][j]
                if (col == "XMAS" || col.reversed() == "XMAS") {
                    val direction = if (col == "XMAS") "col" else "col-rev"
                    if (visited.add(Triple(i, j, direction))) counter++
                }
            }

            if (i + 3 < board.size && j + 3 < board[i].size) {
                val diag = "" + board[i][j] + board[i+1][j+1] + board[i+2][j+2] + board[i+3][j+3]
                if (diag == "XMAS" || diag.reversed() == "XMAS") {
                    val direction = if (diag == "XMAS") "main-diag" else "main-diag-rev"
                    if (visited.add(Triple(i, j, direction))) counter++
                }
            }

            if (i - 3 >= 0 && j + 3 < board[i].size) {
                val revDiag = "" + board[i][j] + board[i-1][j+1] + board[i-2][j+2] + board[i-3][j+3]
                if (revDiag == "XMAS" || revDiag.reversed() == "XMAS") {
                    val direction = if (revDiag == "XMAS") "anti-diag" else "anti-diag-rev"
                    if (visited.add(Triple(i, j, direction))) counter++
                }
            }
        }
    }

    println(counter)

    counter = 0

    for (i in 0 until board.size) {
        for (j in 0 until board[i].size) {
            if (i + 2 < board.size && j + 2 < board[i].size) {
                val diag = "" + board[i][j] + board[i+1][j+1] + board[i+2][j+2]
                val diag2 = "" + board[i][j+2] + board[i+1][j+1] + board[i+2][j]

                if ((diag == "MAS" || diag.reversed() == "MAS") && (diag2 == "MAS" || diag2.reversed() == "MAS")) counter++
            }
        }
    }

    println(counter)
}

package day01

import java.io.File
import kotlin.math.abs


fun main() {
    var input = File("day01/in01.txt").readLines().map { it.split("   ") }

    var first = input.map { it[0].toInt() }.sorted()
    var second = input.map { it[1].toInt() }.sorted()

    var sum = 0
    for (i in 0..<first.size) {
        sum += abs(first[i] - second[i])
    }
    println("*: " + sum)

    sum = 0
    for (i in 0..<first.size) {
        sum += first[i] * second.count { it == first[i] }
    }

    println("**: " + sum)
}
package Day03

import println
import readInput
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main() {
    fun part1(input: List<String>): Int {
        var result: Int = 0
        input.forEach{ battery ->
            var left: Int = -1
            val string: StringBuilder = StringBuilder()
            val batteryLength: Int = battery.length
            for (i in 1 downTo 0 ) {
                val subsequence: String = battery.subSequence(left+1, batteryLength-i).toString()
                val maxLeft = subsequence.max()
                left = battery.indexOf(maxLeft,left+1)
                string.append(maxLeft)
            }
            result += string.toString().toInt()
        }
        return result
    }

    fun part2(input: List<String>): Long {
        var result: Long = 0
        input.forEach{ battery ->
            var left: Int = -1
            val string: StringBuilder = StringBuilder()
            val batteryLength: Int = battery.length
            for (i in 11 downTo 0 ) {
                val subsequence: String = battery.subSequence(left+1, batteryLength-i).toString()
                val maxLeft = subsequence.max()
                left = battery.indexOf(maxLeft,left+1)
                string.append(maxLeft)
            }
            result += string.toString().toLong()
        }

        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 3)

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day03/Day03_test")
    check(part1(testInput) == 357)
    check(part2(testInput) == 3121910778619)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day03/Day03")

    val time1 = measureTime {
        part1(input)
    }
    val time2 = measureTime {
        part2(input)
    }
    println("Time taken fun 1: $time1; Time taken fun 2: $time2")
    part1(input).println()
    part2(input).println()
}

package Day02

import println
import readInput
import kotlin.system.measureTimeMillis

fun main() {
    fun part1(input: List<String>): Long {
        var result: Long = 0
        val pattern = Regex("\\b(\\d+)\\1\\b")

        val dataset = mutableSetOf<String>()

        input[0].split(",").forEach { idRanges ->
            val ids = idRanges.split("-")
            for (i in ids[0].toLong()..ids[1].toLong()) {
                dataset.add(i.toString())
            }
        }

        dataset.forEach { value ->
            pattern.find(value)?.value?.toLong()?.let { result+=it }
        }
        return result
    }

    fun part2(input: List<String>): Long {
        var result: Long = 0
        val pattern = Regex("\\b(\\d+)\\1+\\b")

        val dataset = mutableSetOf<String>()

        input[0].split(",").forEach { idRanges ->
            val ids = idRanges.split("-")
            for (i in ids[0].toLong()..ids[1].toLong()) {
                dataset.add(i.toString())
            }
        }

        dataset.forEach { value ->
            pattern.find(value)?.value?.toLong()?.let { result+=it }
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 3)

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02/Day02_test")
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 4174379265)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02/Day02")
    val time1 = measureTimeMillis {
        part1(input)
    }
    val time2 = measureTimeMillis {
        part2(input)
    }
    println("Time taken fun 1: ${time1}ms; Time taken fun 2: ${time2}ms")
    part1(input).println()
    part2(input).println()
}

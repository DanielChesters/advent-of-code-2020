package xyz.coincoin.adventofcode2020

class Day01 : Day {
    override fun part1(input: List<String>): Int {
        val pairs = getPairs(input)
        val exactPair = filterPairs(pairs)

        return exactPair.first * exactPair.second
    }

    private fun filterPairs(pairs: List<Pair<Int, Int>>): Pair<Int, Int> =
        pairs.first { pair ->
            pair.first + pair.second == 2020
        }

    private fun getPairs(input: List<String>): List<Pair<Int, Int>> {
        val ints = input.map(String::toInt)

        return ints.map {first ->
            ints.mapNotNull { second ->
                if (first != second) Pair(first, second)
                else null
            }
        }.flatten()

    }

    override fun part2(input: List<String>): Int {
        TODO("Not yet implemented")
    }
}

fun main() {
    val day01 = Day01()
    val input = readInput("Day01")

    println("part 1 : ${day01.part1(input)}")
}

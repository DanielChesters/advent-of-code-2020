package xyz.coincoin.adventofcode2020

class Day01 : Day {
    override fun part1(input: List<String>): Long {
        val pairs = getPairs(input)
        val exactPair = filterPairs(pairs)

        return exactPair.first.toLong() * exactPair.second.toLong()
    }

    override fun part2(input: List<String>): Long {
        val triples = getTriples(input)
        val exactTriple = filterTriples(triples)

        return exactTriple.first.toLong() * exactTriple.second.toLong() * exactTriple.third.toLong()
    }

    private fun filterPairs(pairs: List<Pair<Int, Int>>): Pair<Int, Int> =
        pairs.first { pair ->
            pair.first + pair.second == 2020
        }

    private fun getPairs(input: List<String>): List<Pair<Int, Int>> {
        val ints = input.map(String::toInt)

        return ints.map { first ->
            ints.mapNotNull { second ->
                if (first != second) Pair(first, second)
                else null
            }
        }.flatten()
    }

    private fun filterTriples(triples: List<Triple<Int, Int, Int>>): Triple<Int, Int, Int> =
        triples.first { triple ->
            triple.first + triple.second + triple.third == 2020
        }

    private fun getTriples(input: List<String>): List<Triple<Int, Int, Int>> {
        val ints = input.map(String::toInt)

        return ints.map { first ->
            ints.map { second ->
                ints.mapNotNull { third ->
                    if (first != second && second != third && third != first) Triple(first, second, third)
                    else null
                }
            }.flatten()
        }.flatten()
    }
}

fun main() {
    val day01 = Day01()
    val input = readInput("Day01")

    println("part 1 : ${day01.part1(input)}")
    println("part 2 : ${day01.part2(input)}")
}

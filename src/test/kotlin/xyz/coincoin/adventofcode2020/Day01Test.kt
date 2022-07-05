package xyz.coincoin.adventofcode2020

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class Day01Test: ShouldSpec({
    val day01 = Day01()
    val input = readInput("Day01_test")
    should("give 514579 for part 1") {
        day01.part1(input) shouldBe 514579
    }
})
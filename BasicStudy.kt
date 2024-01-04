package com.study

fun main() {
    while (true) {
        print("년도를 입력하세요: ")
        val year = readLine()?.toIntOrNull() ?: return

        print("월을 입력하세요: ")
        val month = readLine()?.toIntOrNull() ?: return

        println(String.format("      %4d년 %2d월       ", year, month))

        val daysInMonth = getDaysInMonth(year, month)
        val startDayOfWeek = getStartDayOfWeek(year, month)

        println("  일  월  화  수  목  금  토")

        var dayOfWeek = startDayOfWeek
        for (dayOfMonth in 1..daysInMonth) {
            if (dayOfWeek == 0 && dayOfMonth != 1) {
                println()
            }

            if (dayOfMonth < 10) {
                print("      $dayOfMonth")
            } else {
                print("     $dayOfMonth")
            }

            dayOfWeek = (dayOfWeek + 1) % 7
        }

        println("\n")

        break
    }
}

fun getDaysInMonth(year: Int, month: Int): Int {
    val leapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
    return when (month) {
        1, 3, 5, 7, 8, 10, 12 -> 31
        4, 6, 9, 11 -> 30
        2 -> if (leapYear) 29 else 28
        else -> throw IllegalArgumentException("Invalid month: $month")
    }
}

fun getStartDayOfWeek(year: Int, month: Int): Int {
    // Zeller's Congruence algorithm to calculate the day of the week
    var m = month
    var y = year
    if (m < 3) {
        m += 12
        y -= 1
    }
    val k = y % 100
    val j = y / 100
    val dayOfWeek = (1 + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7
    return (dayOfWeek + 6) % 7 // Convert to 0-based indexing, where Monday is 0
}

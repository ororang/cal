fun main() {
    var year: Int
    var month: Int
    var dateList = arrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    var yoil = " 일  월  화  수  목  금  토"
    while (true) {
        year = readLine()!!.toInt()
        month = readLine()!!.toInt()

        // Reset dateList to its original valu

        println(String.format("      %4d년 %2d월       ", year, month))

        if (year % 4 == 0) {
            dateList[1] = 29
        }
        var month_index = month - 1
            val daysInMonth = dateList[month_index]
            println("  ${month}월은 ${daysInMonth}일까지 있습니다.")
            println(yoil)
        for(x in 1..daysInMonth){
            print("$x ")
            if(x % 7 == 0) print("\n")
        }
        break
        }




    }


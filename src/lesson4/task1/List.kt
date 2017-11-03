@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import com.sun.org.apache.bcel.internal.generic.IXOR
import lesson1.task1.discriminant
import lesson3.task1.isPrime
import java.lang.Double.NaN
import java.lang.Math.sqrt
import java.lang.Math.pow


/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var sum = 0.0
    for (element in v) {
        sum += pow(element, 2.0)
    }
    return sqrt(sum)
}


/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    return if (list.isEmpty()) {
        0.0
    } else {
        list.sum() / list.size
    }
}


/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    var arithmeticMean = mean(list)
    for (i in 0..list.size - 1) {
        list[i] -= arithmeticMean
    }
    return list
}


/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var product = 0.0
    for (i in 0 until a.size) {
        product += a[i] * b[i]
    }
    return product
}


/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var value = 0.0
    var extent = 1.0
    for (element in p) {
        value += element * extent
        extent *= x
    }
    return value
}


/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    if (list.isNotEmpty()) {
        var Sum = list.first()
        for (i in 1 until list.size) {
            Sum += list[i]
            list[i] = Sum
        }
    }
    return list
}


/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    var divisor = 2
    var N = n
    while (N > 0 && divisor <= N) {
        if (N % divisor == 0) {
            result.add(divisor)
            N /= divisor
        } else {
            divisor++
        }
    }
    return result.sorted()
}


/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val result = mutableListOf<Int>()
    var N = n
    do {
        result.add(N % base)
        N /= base
    } while (N > 0)
    return result.reversed()
}


/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    var list = convert(n, base)
    var list2 = ""
    for (i in 0 until list.size) {
        if (list[i] in 0..9) {
            list2 += list[i]
        } else {
            list2 += alphabet[list[i] - 10]
        }
    }
    return list2
}


/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var n = 0
    var factor = digits.size - 1
    for (i in 0 until digits.size) {
        n += pow(base.toDouble(), factor.toDouble()).toInt() * digits[i]
        factor--
    }
    return n
}


/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int = TODO()

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val romanDigits = listOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    val decimalRank = listOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    var numberRoman = ""
    var number = n
    for (i in 0 until decimalRank.size) {
        while (number >= decimalRank[i]) {
            numberRoman += romanDigits[i]
            number -= decimalRank[i]
        }
    }
    return numberRoman
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var decimalRank = listOf(900, 800, 700, 600, 500, 400, 300, 200, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19,
            18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    var decimalWritten = listOf("девятьсот", "восемьсот", "семьсот", "шестьсот", "пятьсот", "четыреста",
            "триста", "двести", "сто", "девяносто", "восемьдесят", "семьдесят", "шестьдесят", "пятьдесят", "сорок",
            "тридцать", "двадцать", "девятнадцать", "восемнадцать", "семнадцать", "шестнадцать", "пятнадцать",
            "четырнадцать", "тринадцать", "двенадцать", "одиннадцать", "десять", "девять", "восемь", "семь", "шесть",
            "пять", "четыре", "три", "два", "один")
    var numberWritten = ""
    var halfNumberLeft = n / 1000
    var halfNumberRight = n % 1000
    if (halfNumberLeft != 0) {
        if (halfNumberLeft in 100..999) {
            numberWritten += decimalWritten[decimalRank.indexOf(halfNumberLeft - (halfNumberLeft % 100))] + " "
            halfNumberLeft %= 100
        }
        if (halfNumberLeft in 20..99) {
            numberWritten += decimalWritten[decimalRank.indexOf(halfNumberLeft / 10 * 10)] + " "
            halfNumberLeft %= 10
        }
        if (halfNumberLeft in 5..19) {
            numberWritten += decimalWritten[decimalRank.indexOf(halfNumberLeft)] + " "
        }
        if (halfNumberLeft == 4) {
            numberWritten += "четыре тысячи"
        }
        if (halfNumberLeft == 3) {
            numberWritten += "три тысячи"
        }
        if (halfNumberLeft == 2) {
            numberWritten += "две тысячи"
        }
        if (halfNumberLeft == 1) {
            numberWritten += "одна тысяча"
        }
        if (halfNumberLeft !in 1..4) {
            numberWritten += "тысяч"
        }
    }
    if (n / 1000 != 0 && n % 1000 != 0) {
        numberWritten += " "
    }
        if (halfNumberRight in 100..999) {
            numberWritten += decimalWritten[decimalRank.indexOf(halfNumberRight - (halfNumberRight % 100))] + " "
            halfNumberRight %= 100
        }
        if (halfNumberRight in 20..99) {
            numberWritten += decimalWritten[decimalRank.indexOf(halfNumberRight / 10 * 10)] + " "
            halfNumberRight %= 10
        }
        if (halfNumberRight != 0) {
            numberWritten += decimalWritten[decimalRank.indexOf(halfNumberRight)]
        }
    return numberWritten
}



@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1
import java.lang.Math.sqrt
import java.lang.Math.pow
import java.lang.Math.abs

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int  {
    var count = 0
    var number = n
    do {
        count++
        number /= 10
    } while (abs(number) > 0)
    return count
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
 fun fib(n: Int): Int {
    var fib1 = 1
    var fib2 = 1
    var fibn = 0
   return when {
       n == 1 -> 1
       n == 2 -> 1
       else -> {
           for (i in 3..n) {
               fibn = fib2 + fib1
               fib1 = fib2
               fib2 = fibn
           }
           return fibn
       }
   }
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var M = m
    var N = n
    val answer = when {
        m == n -> m
        n > m -> if (n % m == 0) {
            n
        } else {
            do N++
            while ((N % m != 0) || (N % n !=0))
            return N
        }
        else -> if (m % n == 0) {
            m
        } else {
            do M++
            while ((M % n != 0) || (M % m !=0))
            return M
        }
    }
    return answer
}




    /**
     * Простая
     *
     * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
     */
        fun minDivisor(n: Int): Int {
        var divisor = 2
        if (n % divisor == 0) {divisor}
        else {
            while (n % divisor != 0) {
                divisor++
            }
        }
        return divisor
    }



/**
             * Простая
             *
             * Для заданного числа n > 1 найти максимальный делитель, меньший n
             */
            fun maxDivisor(n: Int): Int  {
    var divisor = (n-1)
    if (n % divisor == 0) {divisor}
    else
    {
        while (n % divisor != 0) {
            divisor--
        }

    }
    return divisor
}
    /**
     * Простая
     *
     * Определить, являются ли два заданных числа m и n взаимно простыми.
     * Взаимно простые числа не имеют общих делителей, кроме 1.
     * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
     */
        fun isCoPrime(m: Int, n: Int): Boolean {
        var max = 0
        if (m >= n) {max = m}
        else {max = n}
        for (i in 2..max)  {
            if ((m % i ==0) && (n % i ==0)) return false
        }
        return true
    }

            /**
             * Простая
             *
             * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
             * то есть, существует ли такое целое k, что m <= k*k <= n.
             * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
             */
            fun squareBetweenExists(m: Int, n: Int): Boolean {
                val sqrtn = sqrt(n.toDouble())
                val sqrtm = sqrt(m.toDouble())
                if (sqrtn % 1.0 == 0.0) return true
                else {
                    for (i in sqrtn.toInt() + 1..sqrtm.toInt()) {
                        if (sqrt(i.toDouble()) % 1.0 == 0.0) return true
                    }
                    return false
                }
            }





/**
     * Средняя
     *
     * Для заданного x рассчитать с заданной точностью eps
     * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
     * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
     */
        fun sin(x: Double, eps: Double): Double  = TODO()


/**
             * Средняя
             *
             * Для заданного x рассчитать с заданной точностью eps
             * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
             * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
             */
            fun cos(x: Double, eps: Double)
            : Double  = TODO()


/**
     * Средняя
     *
     * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
     * Не использовать строки при решении задачи.
     */
        fun revert(n: Int): Int {
        val DigitNumber = digitNumber(n)
        var ReversedNumber:Int = 0
        var power = 0.0
        var number = n
        for (i in 1..DigitNumber) {
            power = (DigitNumber - i).toDouble()
            ReversedNumber += (number % 10) * pow(10.0, power).toInt()
            number /= 10
        }
return ReversedNumber
    }

            /**
             * Средняя
             *
             * Проверить, является ли заданное число n палиндромом:
             * первая цифра равна последней, вторая -- предпоследней и так далее.
             * 15751 -- палиндром, 3653 -- нет.
             */
            fun isPalindrome(n: Int)
            : Boolean {
                val RevertedN = revert(n)
                if (RevertedN == n) return true
                else return false
            }

    /**
     * Средняя
     *
     * Для заданного числа n определить, содержит ли оно различающиеся цифры.
     * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
     */
        fun hasDifferentDigits(n: Int): Boolean  = TODO()





/**
             * Сложная
             *
             * Найти n-ю цифру последовательности из квадратов целых чисел:
             * 149162536496481100121144...
             * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
             */
            fun squareSequenceDigit(n: Int): Int {
                var Length = 0L
                var number = 0L
                var NumberSquare = 0L
                do {
                    number++
                    NumberSquare = number * number
                    Length += digitNumber(NumberSquare.toInt())
                }
                while (Length < n)
                return when {
                    (Length == 1L) -> 1
                    (Length.toInt() == n) -> NumberSquare.toInt()  % 10
                    else -> {
                        val difference =  Length - n
                        val lengthLastComponent = digitNumber(NumberSquare.toInt())
                        var answer = NumberSquare
                        for (i in 1..difference) {
                            answer /= 10
                        }
                        return answer.toInt() % 10
                    }
                }
            }

/**
     * Сложная
     *
     * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
     * 1123581321345589144...
     * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
     */
        fun fibSequenceDigit(n: Int): Int  {
    var Length = 0L
    var Number = 0L
    var NumberFib = 0L
    do {
        Number++
        NumberFib = fib(Number.toInt()).toLong()
        Length += digitNumber(NumberFib.toInt())
    }
    while (Length.toInt() < n)
    return when {
        (Length.toInt() == 1) -> 1
        (Length.toInt() == n) -> NumberFib.toInt() % 10
        else -> {
            val difference = Length.toInt() - n
            val lengthLastComponent = digitNumber(NumberFib.toInt())
            var answer = NumberFib
                    for (i in 1..difference) {
                        answer /= 10
                    }
            return answer.toInt() % 10
        }
    }
}



@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String = when {
    (age % 10 == 1) && (age % 100 != 11) -> age.toString() + " год"
    (age % 10 in 2..4) && (age !in 12..14) && (age !in 112..114) -> age.toString() + " года"
    else -> age.toString() + " лет"

}


/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val FullLength = t1 * v1 + t2 * v2 + t3 * v3
    val HalfLength = FullLength * 0.5
    val Length1 = t1 * v1
    val Length2 = t2 * v2
    val Length3 = t3 * v3
    var result: Double = 0.0
    if (HalfLength <= Length1) {
          result =  HalfLength / v1
    }
    if (HalfLength in Length1..Length1+Length2) {
       result = t1 + (HalfLength - Length1) / v2
    }
    if (HalfLength >= Length1 + Length2) {
     result = t1 + t2 + (HalfLength - Length1 - Length2) / v3
    }
return result
}





/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int = when {
    kingX != rookX1 && kingX != rookX2 && kingY != rookY1 && kingY != rookY2 -> 0
    (kingX == rookX1 || kingY == rookY1) && (kingX != rookX2 && kingY != rookY2) -> 1
    (kingX == rookX2 || kingY == rookY2) && (kingX != rookX1 && kingY != rookY1) -> 2
    else -> 3

}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int {
    var bishopDangerX: Int = 0
    var bishopDangerY: Int = 0
    if (kingX - bishopX >= 0) {
        bishopDangerX = kingX - bishopX
    } else {
        bishopDangerX = bishopX - kingX
    }
    if (kingY - bishopY >= 0) {
        bishopDangerY = kingY - bishopY
    } else {
        bishopDangerY = bishopY - kingY
    }
    return when {
        ((kingX == rookX) || (kingY == rookY)) && (bishopDangerX == bishopDangerY) -> 3
        (kingX != rookX) && (kingY != rookY) && (bishopDangerX == bishopDangerY) -> 2
        (kingX == rookX || kingY == rookY) && (bishopDangerX != bishopDangerY)  -> 1
        else -> 0
    }
}
    /**
     * Простая
     *
     * Треугольник задан длинами своих сторон a, b, c.
     * Проверить, является ли данный треугольник остроугольным (вернуть 0),
     * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
     * Если такой треугольник не существует, вернуть -1.
     */
    fun triangleKind(a: Double, b: Double, c: Double): Int {
        val cosA = (b * b + c * c - a *a)/ 2 / b / c
        val cosB = (a * a + c *c - b *b) / 2 / a / c
        val cosC = (a * a + b * b - c *c) / 2 / a / b
        return when {
            ((a + b < c) || (a + c < b) || (c + b < a)) -> -1
            ((cosA == 0.0) && (cosB > 0) && (cosC > 0)) || ((cosA > 0) && (cosB == 0.0) && (cosC > 0)) || ((cosA > 0) && (cosB > 0) && (cosC == 0.0)) -> 1
            ((c * c > a * a + b * b) && (cosA > 0) && (cosB > 0))   || ((a * a > b * b + c * c) && (cosC > 0) && (cosB > 0)) || ((b * b > a * a + c * c) && (cosA > 0) && (cosC > 0)) -> 2
            else -> 0
        }
    }

    /**
     * Средняя
     *
     * Даны четыре точки на одной прямой: A, B, C и D.
     * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
     * Найти длину пересечения отрезков AB и CD.
     * Если пересечения нет, вернуть -1.
     */
    fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
        return when {
            (a >= c) && (b <= d) -> (b - a)
            (c <= b) && (c >= a) && (d >= b) -> (b - c)
            (d <= b) && (c >= a) -> (d -c)
            (d <= b) && (d >= a) && (c <= a) -> (d - a)
      else -> -1
        }
    }


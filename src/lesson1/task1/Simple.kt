@file:Suppress("UNUSED_PARAMETER")

package lesson1.task1

import kotlin.math.*

/**
 * Пример
 *
 * Вычисление квадрата целого числа
 */
fun sqr(x: Int) = x * x

/**
 * Пример
 *
 * Вычисление квадрата вещественного числа
 */
fun sqr(x: Double) = x * x

/**
 * Пример
 *
 * Вычисление дискриминанта квадратного уравнения
 */
fun discriminant(a: Double, b: Double, c: Double) = sqr(b) - 4 * a * c

/**
 * Пример
 *
 * Поиск одного из корней квадратного уравнения
 */
fun quadraticEquationRoot(a: Double, b: Double, c: Double) =
        (-b + sqrt(discriminant(a, b, c))) / (2 * a)

/**
 * Пример
 *
 * Поиск произведения корней квадратного уравнения
 */
fun quadraticRootProduct(a: Double, b: Double, c: Double): Double {
    val sd = sqrt(discriminant(a, b, c))
    val x1 = (-b + sd) / (2 * a)
    val x2 = (-b - sd) / (2 * a)
    return x1 * x2 // Результат
}

/**
 * Пример главной функции
 */
fun main(args: Array<String>) {
    //Trivial #1
    val hours = 8
    val minutes = 20
    val seconds = 35
    println("seconds have passed since $hours:$minutes:$seconds = ${lesson1.task1.seconds(hours, minutes, seconds)}")

    //Trivial #2
    val sagenes = 8
    val arshins = 2
    val vershoks = 11
    println("\n$sagenes sagenes, $arshins arshins and $vershoks vershoks are equal %.2f".format(lengthInMeters(sagenes, arshins, vershoks)))


    //Easy #1
    println("\nLet's calculate third number of your digit from the end..")
    var inputDigit = 0
    while (inputDigit < 100) {
        println("Enter the digit please. The digit must be equal or more than 100..")
        inputDigit = readLine()!!.toInt()
    }
    println("Your number is ${thirdDigit(inputDigit)}")

    //Easy #2
    println("\nLet's get know how much minutes it take for train to travel..")
    var hoursDepart = -1
    var minutesDepart = -1
    var hoursArrive = -1
    var minutesArrive = -1
    while (hoursDepart < 0 || hoursDepart > 23) {
        print("Please enter hoursDepart : ")
        hoursDepart = readLine()!!.toInt()
    }
    while (minutesDepart < 0 || minutesDepart > 59) {
        print("Please enter minutesDepart : ")
        minutesDepart = readLine()!!.toInt()
    }
    while (hoursArrive < 0 || hoursArrive > 23) {
        print("Please enter hoursArrive : ")
        hoursArrive = readLine()!!.toInt()
    }
    while (minutesArrive < 0 || minutesArrive > 59) {
        print("Please enter minutesArrive : ")
        minutesArrive = readLine()!!.toInt()
    }
    println("Time to travel in minutes from departure point to arrive point is equal ${travelMinutes(hoursDepart, minutesDepart, hoursArrive, minutesArrive)}")

}

/**
 * Тривиальная
 *
 * Пользователь задает время в часах, минутах и секундах, например, 8:20:35.
 * Рассчитать время в секундах, прошедшее с начала суток (30035 в данном случае).
 */
fun seconds(hours: Int, minutes: Int, seconds: Int): Int = (hours * 60 + minutes) * 60 + seconds

/**
 * Тривиальная
 *
 * Пользователь задает длину отрезка в саженях, аршинах и вершках (например, 8 саженей 2 аршина 11 вершков).
 * Определить длину того же отрезка в метрах (в данном случае 18.98).
 * 1 сажень = 3 аршина = 48 вершков, 1 вершок = 4.445 см.
 */
fun lengthInMeters(sagenes: Int, arshins: Int, vershoks: Int): Double = (sagenes * 48 + arshins * 48 / 3 + vershoks) * 4.445 / 100

/**
 * Тривиальная
 *
 * Пользователь задает угол в градусах, минутах и секундах (например, 36 градусов 14 минут 35 секунд).
 * Вывести значение того же угла в радианах (например, 0.63256).
 */
fun angleInRadian(deg: Int, min: Int, sec: Int): Double = TODO()

/**
 * Тривиальная
 *
 * Найти длину отрезка, соединяющего точки на плоскости с координатами (x1, y1) и (x2, y2).
 * Например, расстояние между (3, 0) и (0, 4) равно 5
 */
fun trackLength(x1: Double, y1: Double, x2: Double, y2: Double): Double = TODO()

/**
 * Простая
 *
 * Пользователь задает целое число, большее 100 (например, 3801).
 * Определить третью цифру справа в этом числе (в данном случае 8).
 */
fun thirdDigit(number: Int): Int {
    val inputDigitAsString = number.toString()
    val foundDigit: String = inputDigitAsString[inputDigitAsString.length - 3].toString()
    return foundDigit.toInt()
}

/**
 * Простая
 *
 * Поезд вышел со станции отправления в h1 часов m1 минут (например в 9:25) и
 * прибыл на станцию назначения в h2 часов m2 минут того же дня (например в 13:01).
 * Определите время поезда в пути в минутах (в данном случае 216).
 */
fun travelMinutes(hoursDepart: Int, minutesDepart: Int, hoursArrive: Int, minutesArrive: Int):
        Int = (hoursArrive - hoursDepart - 1) * 60 + 60 - minutesDepart + minutesArrive

/**
 * Простая
 *
 * Человек положил в банк сумму в s рублей под p% годовых (проценты начисляются в конце года).
 * Сколько денег будет на счету через 3 года (с учётом сложных процентов)?
 * Например, 100 рублей под 10% годовых превратятся в 133.1 рубля
 */
fun accountInThreeYears(initial: Int, percent: Int): Double = TODO()

/**
 * Простая
 *
 * Пользователь задает целое трехзначное число (например, 478).
 * Необходимо вывести число, полученное из заданного перестановкой цифр в обратном порядке (например, 874).
 */
fun numberRevert(number: Int): Int = TODO()

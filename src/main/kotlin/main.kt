fun main() {
    println(comission(type = "Visa", 10000_00, sumTransfer = 50000_00))

}
fun comission(type : String = "VK Pay", transfer : Int, sumTransfer : Int = 0) : String = when(type){
    "VK Pay" -> checkCommissionVKPay(sumTransfer, transfer)
    "Maestro" -> checkCommissionMaestro(sumTransfer, transfer)
    "Mastercard" -> checkCommissionMaestro(sumTransfer, transfer)
    "Visa" -> checkComissionVisa(sumTransfer, transfer)
    "Мир" -> checkComissionVisa(sumTransfer, transfer)
    else -> "ERROR"
}
// проверка и расчет VKPay
fun checkCommissionVKPay(sumTransfer: Int, transfer: Int) : String = when{
    (sumTransfer + transfer) <= 40000_00 && transfer <= 15000_00 -> "Комиссия не взимается"
    else -> "Превышен лимит"
}
// проверка и расчет Maestro и Mastercard
fun checkCommissionMaestro(sumTransfer: Int, transfer: Int) : String = when{
    (sumTransfer + transfer) <= 75000_00 -> "Комиссия не взимается"
    (sumTransfer + transfer) > 75000_00 && (sumTransfer + transfer) <= 600000_00 && transfer <= 150000_00 ->
        "Комиссия составляет " + ((transfer*0.6/10000)+20).toInt() + " рублей " + ((transfer*0.6/100) % 100).toInt() + " копеек"
    else -> "Превышен лимит"
}
// проверка и расчет Visa и Мир
fun checkComissionVisa(sumTransfer: Int, transfer: Int) : String = when {
    (sumTransfer + transfer) <= 600000_00 && transfer <= 150000_00 && (transfer * 0.75 / 10000).toInt() > 35 ->
        "Комиссия составляет " + (transfer * 0.75 / 10000).toInt() + " рублей " + ((transfer * 0.75 / 100) % 100).toInt() + " копеек"
    (sumTransfer + transfer) <= 600000_00 && transfer <= 150000_00 && (transfer * 0.75 / 10000).toInt() < 35 ->
        "Комиссия составляет 35 рублей 0 копеек"
    else -> "Превышен лимит"
}
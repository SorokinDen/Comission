import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestCommision {
    @Test
    fun testComissionVKPayNoCommision() {
        val transfer = 10000
        val sumTransfer = 0
        val result = checkCommissionVKPay(sumTransfer, transfer)
        assertEquals("", result)
    }

    @Test
    fun testComissionVKPayLimit() {
        val transfer = 10000
        val sumTransfer = 5000000
        val result = checkCommissionVKPay(sumTransfer, transfer)
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun testComissionMaestroNoComission() {
        val transfer = 10000
        val sumTransfer = 0
        val result = checkCommissionMaestro(sumTransfer, transfer)
        assertEquals("Комиссия не взимается", result)
    }

    @Test
    fun testComissionMaestroComission() {
        val transfer = 80000_00
        val sumTransfer = 50000_00
        val result = checkCommissionMaestro(sumTransfer, transfer)
        assertEquals("Комиссия составляет 500 рублей 0 копеек", result)
    }

    @Test
    fun testComissionMaestroLimit() {
        val transfer = 800000_00
        val sumTransfer = 500000_00
        val result = checkCommissionMaestro(sumTransfer, transfer)
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun testComissionVisaComissionMin() {
        val transfer = 800_00
        val sumTransfer = 500_00
        val result = checkComissionVisa(sumTransfer, transfer)
        assertEquals("Комиссия составляет 35 рублей 0 копеек", result)
    }

    @Test
    fun testComissionVisaComissionMax() {
        val transfer = 8000_00
        val sumTransfer = 5000_00
        val result = checkComissionVisa(sumTransfer, transfer)
        assertEquals("Комиссия составляет 60 рублей 0 копеек", result)
    }

    @Test
    fun testComissionVisaComissionLimit() {
        val transfer = 800000_00
        val sumTransfer = 5000000_00
        val result = checkComissionVisa(sumTransfer, transfer)
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun testComissionVK() {
        val type = "VK Pay"
        val transfer = 800000_00
        val sumTransfer = 5000000_00
        val result = comission(type, transfer, sumTransfer)
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun testComissionMaestro() {
        val type = "Maestro"
        val transfer = 800000_00
        val sumTransfer = 5000000_00
        val result = comission(type, transfer, sumTransfer)
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun testComissionMastercard() {
        val type = "Mastercard"
        val transfer = 800000_00
        val sumTransfer = 5000000_00
        val result = comission(type, transfer, sumTransfer)
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun testComissionVisa() {
        val type = "Visa"
        val transfer = 800000_00
        val sumTransfer = 5000000_00
        val result = comission(type, transfer, sumTransfer)
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun testComissionMir() {
        val type = "Мир"
        val transfer = 800000_00
        val sumTransfer = 5000000_00
        val result = comission(type, transfer, sumTransfer)
        assertEquals("Превышен лимит", result)
    }

    @Test
    fun testComissionError() {
        val type = "Error"
        val transfer = 800000_00
        val sumTransfer = 5000000_00
        val result = comission(type, transfer, sumTransfer)
        assertEquals("ERROR", result)
    }

}

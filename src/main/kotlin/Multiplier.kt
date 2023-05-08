fun payoutCalculator(bet: Double, color: String ): Double{
    var payout: Double = 0
    when(color){
        "red" -> payout = bet * 2
        "blue" -> payout = bet * 2
        "green" -> payout = bet * 7
    }
    return payout
}
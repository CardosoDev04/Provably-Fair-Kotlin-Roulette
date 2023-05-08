import java.lang.IllegalArgumentException

val BLUE_RANGE = 16
val RED_RANGE = 32
val GREEN_RANGE = 4


fun multiplier(color: String): Double{
    return when(color){
        "red" -> 2.0
        "blue" -> 2.0
        "green" -> 7.0

        else -> throw IllegalArgumentException("Invalid Color")
    }
}
fun payout(bet: Double, color: String, clientSeed: String, serverSeed: String ): String{

    val winningNumber = winnerSeed(serverSeed,clientSeed)
    val winColor = when(winningNumber){
        in 0..BLUE_RANGE -> "blue"
        in BLUE_RANGE..RED_RANGE -> "red"
        in RED_RANGE until RED_RANGE + BLUE_RANGE + GREEN_RANGE -> "green"
        else -> "Not a valid choice"
    }

    if( color == winColor) return "You won! " + "And your payout was: "+ bet * multiplier(color)
    else return "The winning color was ${winColor.uppercase()} " + "and your payout was: "+ 0.0

}
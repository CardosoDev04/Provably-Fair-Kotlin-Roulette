fun main(){

    println("Welcome to the Provably Fair Roulette")
    println("Red/Blue = 2x Multiplier  -----   Green = 7x Multiplier")
    println("Please insert the color you wish to bet on (red/green/blue) in lowercase")
    var betColor = readln()
    println("Please insert your bet amount (You can use decimal point)")
    var betAmount = readln().toDouble()

    val clientSeed = generateSeed(20)
    val serverSeed = generateSeed(20)

    val serverHash = serverPublic(serverSeed)

    println("The public hashed server seed is: $serverHash")

    val payout = payout(betAmount,betColor,clientSeed,serverSeed)

    println(payout)
}
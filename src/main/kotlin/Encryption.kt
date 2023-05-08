import java.security.MessageDigest
import java.security.SecureRandom

fun serverPublic(input: String): String{
    val algorithmObj = MessageDigest.getInstance("SHA-256")
    val inputByteArray = input.toByteArray(Charsets.UTF_8)

    val hash = algorithmObj.digest(inputByteArray)

    return hash.joinToString("") {"%02x".format(it)}


}
fun sha256(clientSeed: String,serverSeed: String): String{
    val input = "$serverSeed:$clientSeed"
    val algorithmObj = MessageDigest.getInstance("SHA-256")
    val inputByteArray = input.toByteArray(Charsets.UTF_8)

    val hash = algorithmObj.digest(inputByteArray)

    return hash.joinToString("") {"%02x".format(it)}


}

fun generateSeed(length: Int): String{
    val random = SecureRandom()
    val seed = ByteArray(length)
    random.nextBytes(seed)
    return seed.joinToString(""){"%02x".format(it)}
}

fun winnerSeed(serverSeed: String, clientSeed: String): Int {
    val hash = sha256(serverSeed,clientSeed)
    val number = hash.substring(0,8).toLong(16) // Gets the first 8 characters (64 bit) of the hash and turns them into Long with base 16
    println(number)
    return (number % 64).toInt()  // Divides the number by 64 and the rest of it's division is converted to int being that our winner number to set the color later
}


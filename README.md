# Provably-Fair-Kotlin-Roulette
This is a provably fair roulette coded using the Kotlin programming language, this roulette uses the SHA-256 Encryption Algorithm.

## How does it work?
This roulette works by executing the following steps:

- Taking in the input for the player's bet (color and bet amount)
- Generating a client and server seed and encrypting each one using SHA-256 Encryption
- Concatenating the hashed strings
- Converting the new string to a Long and then doing it's module with 64
- Taking the result of the previous step and assigning it to a winningNumber variable
- Checking in what color range that winningNumber variable falls and getting the winningColor.
- Comparing the players color input with winningColor and respectively using the win multiplier in case theres a match.

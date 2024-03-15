/*
Spielregel (Reizwert)
5 to [12,11,10,9]
4 to [12,11,10]
3 to [12,11]
2 to [12]
5 to []
4 to [9]
3 to [10,9]
2 to [11,10,9]

 */
fun main() {
    val deck = Deck()
    val game = Game(deck)

    game.distributeCard()
    game.playersBid()
    println("${game.gameLeader()} beginnt das Spiel")


}

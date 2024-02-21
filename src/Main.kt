data class Skatkarte(val symbol: String, val name: String, val wert: Int, val farbwert: Int)


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

    val skat = Player("Skat")
    val players = mutableMapOf<Int, Player>(
        1 to Player("Spieler 1"),
        2 to Player("Spieler 2"),
        3 to Player("Spieler 3"),
    )

    players.forEach { (_, player) ->
        println("${player.name()}, bitte gib deinen Namen ein...")
        val neuerName = readln()
        if (neuerName != "") {
            player.name(neuerName)
        }
    }


    /*
    fun spielerReizen (players: Map<Int, Player>) {
        val aktuelleReizschritte = reizschritte.toMutableList()
        var reizer = false;
        var gegenSpielerAnzahl = players.count() { (_, player) -> player.gegenSpieler}

        while (gegenSpielerAnzahl < 2) {
            val reizschritt = aktuelleReizschritte.removeFirst()
            players.forEach { (_, player) ->
                if(player.gegenSpieler) {

                }
               else  if(player.maxReizwert < reizschritt && !player.gegenSpieler) {
                    player.gegenSpieler = true;
                    println("${player.name} sagt ich bin raus")
                }
                else if(player.maxReizwert >= reizschritt && !player.gegenSpieler && !reizer) {
                    println("${player.name} sagt $reizschritt")
                    reizer = true
                }
                else if(player.maxReizwert >= reizschritt && !player.gegenSpieler && reizer) {
                    println("${player.name} sagt ich gehe mit")
                }

            }
            reizer = false
            gegenSpielerAnzahl = players.filter { (_, player) -> player.gegenSpieler}.size
        }
    }
     */

    players.forEach{ (_, player) ->
        player.giveCards(deck.cards(3))
    }
    skat.giveCards(deck.cards(2))

    players.forEach{ (_, player) ->
        player.giveCards(deck.cards(4))
    }
    players.forEach{ (_, player) ->
        player.giveCards(deck.cards(3))
        player.sortWenzel()
        player.calculateBid()
    }


    //spielerReizen(players)
    //println(deck) hat geklappt


}

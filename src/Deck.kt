class Deck {
    val cards = mutableListOf(
        Skatkarte("\u001b[107;30m♣️A \u001B[0m", "Eichel Ass", 11, 12),
        Skatkarte("\u001b[107;30m♣️️K \u001B[0m", "Eichel König", 4, 12),
        Skatkarte("\u001b[107;30m♣️D \u001B[0m", "Eichel Dame", 3, 12),
        Skatkarte("\u001b[107;30m♣️W \u001B[0m", "Eichel Wenzel", 2, 12),
        Skatkarte("\u001b[107;30m♣️10\u001B[0m", "Eichel 10", 10, 12),
        Skatkarte("\u001b[107;30m♣️9 \u001B[0m", "Eichel 9", 0, 12),
        Skatkarte("\u001b[107;30m♣️8 \u001B[0m", "Eichel 8", 0, 12),
        Skatkarte("\u001b[107;30m♣️7 \u001B[0m", "Eichel 7", 0, 12),

        Skatkarte("\u001b[107;32m️ ♠︎️\u001B[0m\u001B[107;30m\uFE0FA \u001B[0m", "Grün Ass", 11, 11),
        Skatkarte("\u001B[107;32m\uFE0F ♠\uFE0E\uFE0F\u001B[0m\u001B[107;30m\uFE0FK \u001B[0m", "Grün König", 4, 11),
        Skatkarte("\u001B[107;32m\uFE0F ♠\uFE0E\uFE0F\u001B[0m\u001B[107;30m\uFE0FD \u001B[0m", "Grün Dame", 3, 11),
        Skatkarte("\u001B[107;32m\uFE0F ♠\uFE0E\uFE0F\u001B[0m\u001B[107;30m\uFE0FW \u001B[0m", "Grün Wenzel", 2, 11),
        Skatkarte("\u001B[107;32m\uFE0F ♠\uFE0E\uFE0F\u001B[0m\u001B[107;30m\uFE0F10 \u001B[0m", "Grün 10", 10, 11),
        Skatkarte("\u001B[107;32m\uFE0F ♠\uFE0E\uFE0F\u001B[0m\u001B[107;30m\uFE0F9 \u001B[0m", "Grün 9", 0, 11),
        Skatkarte("\u001B[107;32m\uFE0F ♠\uFE0E\uFE0F\u001B[0m\u001B[107;30m\uFE0F8 \u001B[0m", "Grün 8", 0, 11),
        Skatkarte("\u001B[107;32m\uFE0F ♠\uFE0E\uFE0F\u001B[0m\u001B[107;30m\uFE0F7 \u001B[0m", "Grün 7", 0, 11),

        Skatkarte("\u001b[107;30m❤️️A \u001B[0m", "Rot Ass", 11, 10),
        Skatkarte("\u001b[107;30m❤️️K \u001B[0m", "Rot König", 4, 10),
        Skatkarte("\u001b[107;30m❤️️D \u001B[0m", "Rot Dame", 3, 10),
        Skatkarte("\u001b[107;30m❤️W \u001B[0m", "Rot Wenzel", 2, 10),
        Skatkarte("\u001b[107;30m❤️️10\u001B[0m", "Rot 10", 10, 10),
        Skatkarte("\u001b[107;30m❤️️9 \u001B[0m", "Rot 9", 0, 10),
        Skatkarte("\u001b[107;30m❤️️8 \u001B[0m", "Rot 8", 0, 10),
        Skatkarte("\u001b[107;30m❤️️7 \u001B[0m", "Rot 7", 0, 10),

        Skatkarte("\u001b[107;30m♦️️A \u001B[0m", "Schell Ass", 11, 9),
        Skatkarte("\u001b[107;30m♦️️K \u001B[0m", "Schell König", 4, 9),
        Skatkarte("\u001b[107;30m♦️️D \u001B[0m", "Schell Ass", 3, 9),
        Skatkarte("\u001b[107;30m♦️️W \u001B[0m", "Schell Ass", 2, 9),
        Skatkarte("\u001b[107;30m♦️️10\u001B[0m", "Schell Ass", 10, 9),
        Skatkarte("\u001b[107;30m♦️️9 \u001B[0m", "Schell Ass", 0, 9),
        Skatkarte("\u001b[107;30m♦️8 \u001B[0m", "Schell Ass", 0, 9),
        Skatkarte("\u001b[107;30m♦️️7 \u001B[0m", "Schell Ass", 0, 9),
    )
    init {
        cards.shuffle()
    }
    fun cards(count: Int) :List<Skatkarte> {
        val selectedCards = cards.slice(0 until count)
        cards.removeAll(selectedCards)
        return selectedCards
    }
}
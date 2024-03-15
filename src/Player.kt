class Player(name: String) {
    private var _name: String
    private val _cardsInHand: MutableList<Skatkarte> = mutableListOf()
    private val _wenzel: MutableList<Int> = mutableListOf()
    protected var _maxBidValue: Int = 0
    private var _opponent: Boolean = false
    private val wenzelWert = 2
    private var _currentBidStep = 0

    // Spieler ist gerade der Gegenspieler (setzen)
    fun opponent(o: Boolean) {
        _opponent = o
    }

    // Bin ich der Gegenspieler
    fun opponent(): Boolean {
        return _opponent
    }

    open fun bid(): Int? {
        if (BID_STEPS[_currentBidStep] <= _maxBidValue) {
            println("Du kannst bis $_maxBidValue bieten! Möchtest Du bieten? j/n")
            val input = readln().first()
            if (input == 'j') {
                val bidValue = BID_STEPS[_currentBidStep]
                _currentBidStep += 1
                return bidValue
            }

        }
        return null
    }

    fun getCards(cards: List<Skatkarte>) {
        _cardsInHand.addAll(cards)
    }

    fun sortWenzel() {
        val wenzelRausholen = _cardsInHand.filter { skatkarte: Skatkarte -> skatkarte.wert == wenzelWert }
        val wenzelFarbwert = wenzelRausholen.map { skatkarte: Skatkarte ->
            skatkarte.farbwert
        }
        wenzelFarbwert.sortedDescending()
        _wenzel.addAll(wenzelFarbwert)
    }

    fun calculateBid() {
        val reizwert = BID_VALUE[_wenzel] ?: 5
        val eichelAnzahl = _cardsInHand.count { skatkarte: Skatkarte -> skatkarte.farbwert == 12 }
        val gruenlAnzahl = _cardsInHand.count { skatkarte: Skatkarte -> skatkarte.farbwert == 11 }
        val rotAnzahl = _cardsInHand.count { skatkarte: Skatkarte -> skatkarte.farbwert == 10 }
        val schellAnzahl = _cardsInHand.count { skatkarte: Skatkarte -> skatkarte.farbwert == 9 }
        val anzahlListe = setOf(12 to eichelAnzahl, 11 to gruenlAnzahl, 10 to rotAnzahl, 9 to schellAnzahl)
        val groessteAnzahl = anzahlListe.maxBy { anzahl -> anzahl.second }
        val kannIchReizen = _wenzel.size + groessteAnzahl.second
        if (kannIchReizen > 4) {
            _maxBidValue = reizwert * groessteAnzahl.first
            return
        }
        _maxBidValue = 0
    }

    override fun toString(): String {
        return name
    }
}
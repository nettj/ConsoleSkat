class Player(name: String) {
    private var _name: String
    private val _cardsInHand: MutableList<Skatkarte> = mutableListOf()
    private val _wenzel: MutableList<Int> = mutableListOf()
    private var _maxBidValue: Int = 0
    private var _gegenSpieler: Boolean = false
    private val wenzelWert = 2
    private var _currentBidStep = 0

    init {
        _name = name
    }
    fun bid(): Int? {
        if (BID_STEPS[_currentBidStep] <= _maxBidValue) {
            val bidValue = BID_STEPS[_currentBidStep]
            _currentBidStep += 1
            return bidValue
        }

        return null
    }

    fun name(): String {
        return _name
    }

    fun name(giveName: String) {
        _name = giveName
    }

    fun giveCards(cards: List<Skatkarte>) {
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
        _gegenSpieler = true
        _maxBidValue = 0
    }
}
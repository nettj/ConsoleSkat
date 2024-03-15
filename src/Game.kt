class Game(a: Deck) {
    private val _maxPlayersCount = 3
    private val _deck: Deck
    private val _players: List<Player>
    private val _skat = Player("Skat")

    init {
        _deck = a
        _players = mutableListOf()
        initPlayers()
    }

    private fun initPlayers() {
        println("Wie viele Spieler spielen heute?")
        val playersCount = readln().toIntOrNull();
        if (playersCount == null || playersCount > _maxPlayersCount) {
            println("Ungültige Anzahl an Spieler")
            return initPlayers()
        }

        initPlayerName(playersCount)
        repeat(_maxPlayersCount - playersCount) {
            _players.addLast(ComputerPlayer(COMPUTER_PLAYER_NAMES.random()))
        }
        println(_players.joinToString("\n") { player -> "Spieler $player spielt mit" })
    }

    private fun initPlayerName(playersCount: Int) {
        repeat(playersCount) {
            println("Spieler ${it + 1}, bitte gib deinen Namen ein...")
            val input = readln()
            val name = input.ifEmpty { "Spieler ${it + 1}" }
            val player = Player(name, 200)
            _players.addLast(player)
        }
    }

    fun distributeCard() {
        _players.forEach { player ->
            println("${player}, bekommt 3 Karten")
            player.getCards(_deck.cards(3))
        }
        Thread.sleep(1000)
        _skat.getCards(_deck.cards(2))
        println("${_skat}, bekommt 2 Karten")

        Thread.sleep(1000)
        _players.forEach { player ->
            println("${player}, bekommt 4 Karten")
            player.getCards(_deck.cards(4))
        }

        Thread.sleep(1000)
        _players.forEach { player ->
            println("${player}, bekommt 3 Karten")
            player.getCards(_deck.cards(3))
            player.sortWenzel()
            player.calculateBid()
        }
    }

    fun gameLeader(): Player {
        return _players.find { player -> !player.opponent() }!!
    }

    fun playersBid() {
        var bidPlayers = _players.filter { player -> !player.opponent() }
        do {
            var currentBid: Int? = null
            bidPlayers.forEach { currentPlayer: Player ->
                val currentPlayerBid = currentPlayer.bid()
                when {
                    currentPlayerBid != null && currentBid != null -> println("$currentPlayer sagt: ich gehe mit")
                    currentPlayerBid == null && currentBid != null -> {
                        println("$currentPlayer sagt: ich bin weg")
                        currentPlayer.opponent(true)
                    }
                    currentPlayerBid == null && currentBid == null -> {
                        println("$currentPlayer sagt: ich bin weg")
                        currentPlayer.opponent(true)
                    }

                    else -> {
                        println("$currentPlayer sagt: $currentPlayerBid")
                        currentBid = currentPlayerBid
                    }
                }
            }
            bidPlayers = _players.filter { player -> !player.opponent() }
        } while (bidPlayers.size > 1)
    }
}
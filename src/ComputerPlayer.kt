class ComputerPlayer(override val name: String) : Player(name) {
    override fun bid(): Int? {
        if (BID_STEPS[_currentBidStep] <= _maxBidValue) {
            val bidValue = BID_STEPS[_currentBidStep]
            _currentBidStep += 1
            return bidValue
        }

        return null
    }
}
package at.asitplus.wallet.ehic

import de.infix.testBalloon.framework.core.TestSession
import kotlin.time.Instant
import kotlinx.datetime.LocalDate
import kotlin.random.Random

class ModuleTestSession : TestSession() {
    init {
        Initializer.initWithVCK()
    }
}

internal fun randomInstant() = Instant.fromEpochSeconds(Random.nextLong(1000L, 3000L))

internal fun randomLocalDate() = LocalDate(Random.nextInt(1900, 2100), Random.nextInt(1, 12), Random.nextInt(1, 28))

private val charPool = ('A'..'Z') + ('a'..'z') + ('0'..'9')

internal fun randomString() = (1..16)
    .map { Random.nextInt(0, charPool.size).let { charPool[it] } }
    .joinToString("")

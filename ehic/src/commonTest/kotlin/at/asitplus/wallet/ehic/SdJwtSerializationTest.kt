package at.asitplus.wallet.ehic

import at.asitplus.wallet.lib.data.vckJsonSerializer
import at.asitplus.wallet.lib.iso.vckCborSerializer
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.encodeToString

@OptIn(ExperimentalSerializationApi::class)
class SdJwtSerializationTest : FunSpec({

    test("serialize credential") {
        val credential = EuropeanHealthInsuranceCard(
            issuingCountry = randomString(),
            socialSecurityNumber = randomString(),
            issuingAuthority = IssuingAuthority(randomString(), randomString()),
            documentNumber = randomString(),
            issuanceDate = randomInstant().toLocalDateTime(TimeZone.UTC).date,
            expiryDate = randomInstant().toLocalDateTime(TimeZone.UTC).date,
        )
        val json = vckJsonSerializer.encodeToString(credential)
        vckJsonSerializer.decodeFromString<EuropeanHealthInsuranceCard>(json) shouldBe credential

        val cbor = vckCborSerializer.encodeToByteArray(credential)
        vckCborSerializer.decodeFromByteArray<EuropeanHealthInsuranceCard>(cbor) shouldBe credential
    }
})

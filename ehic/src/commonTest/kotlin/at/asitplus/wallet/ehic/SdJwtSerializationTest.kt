package at.asitplus.wallet.ehic

import at.asitplus.wallet.lib.data.vckJsonSerializer
import at.asitplus.wallet.lib.iso.vckCborSerializer
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromByteArray
import kotlinx.serialization.encodeToByteArray
import kotlinx.serialization.encodeToString

@OptIn(ExperimentalSerializationApi::class)
class SdJwtSerializationTest : FunSpec({

    test("serialize credential") {
        val credential = EuropeanHealthInsuranceCard(
            healthInsuranceId = randomString(),
            patientId = randomString(),
            taxNumber = randomString(),
            oneTimeToken = randomString(),
            ePrescriptionCode = randomString(),
            affiliationCountry = randomString(),
            issuanceDate = randomInstant(),
            expiryDate = randomInstant(),
            issuingAuthority = randomString(),
            documentNumber = randomString(),
            administrativeNumber = randomString(),
            issuingCountry = randomString(),
            issuingJurisdiction = randomString(),
        )
        val json = vckJsonSerializer.encodeToString(credential)
        vckJsonSerializer.decodeFromString<EuropeanHealthInsuranceCard>(json) shouldBe credential

        val cbor = vckCborSerializer.encodeToByteArray(credential)
        vckCborSerializer.decodeFromByteArray<EuropeanHealthInsuranceCard>(cbor) shouldBe credential
    }

})

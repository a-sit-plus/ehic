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
            issuingCountry = randomString(),
            socialSecurityNumber = randomString(),
            personalAdministrativeNumber = randomString(),
            issuingAuthority = IssuingAuthority(randomString(), randomString()),
            authenticSource = AuthenticSource(randomString(), randomString()),
            documentNumber = randomString(),
            issuanceDate = randomLocalDate(),
            expiryDate = randomLocalDate(),
            dateOfIssuance = randomLocalDate(),
            dateofExpiry = randomLocalDate(),
            startingDate = randomLocalDate(),
            endingDate = randomLocalDate(),
        )
        vckJsonSerializer.decodeFromString<EuropeanHealthInsuranceCard>(
            vckJsonSerializer.encodeToString<EuropeanHealthInsuranceCard>(credential)
        ) shouldBe credential

        vckCborSerializer.decodeFromByteArray<EuropeanHealthInsuranceCard>(
            vckCborSerializer.encodeToByteArray<EuropeanHealthInsuranceCard>(credential)
        ) shouldBe credential
    }
})

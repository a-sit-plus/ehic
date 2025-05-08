package at.asitplus.wallet.ehic

import at.asitplus.wallet.lib.data.ConstantIndex.CredentialRepresentation
import at.asitplus.wallet.lib.data.ConstantIndex.CredentialRepresentation.SD_JWT
import at.asitplus.wallet.lib.data.ConstantIndex.CredentialScheme

object EhicScheme : CredentialScheme {

    override val schemaUri: String = "https://wallet.a-sit.at/schemas/1.0.0/ehic.json"
    override val sdJwtType: String = "urn:eudi:ehic:1"
    override val supportedRepresentations: Collection<CredentialRepresentation> =
        listOf(SD_JWT)

    override val claimNames: Collection<String> = listOf(
        Attributes.ISSUING_COUNTRY,
        Attributes.SOCIAL_SECURITY_NUMBER,
        Attributes.PREFIX_ISSUING_AUTHORITY,

        Attributes.DOCUMENT_NUMBER,
        Attributes.ISSUANCE_DATE,
        Attributes.EXPIRY_DATE,
    )

    val requiredClaims: Collection<String> = claimNames

    object Attributes {
        /**
         * The country where the issuing institution operates, represented as a two-letter country code compliant with ISO 3166-1 alpha-2.
         */
        const val ISSUING_COUNTRY = "issuing_country"

        /**
         * The personal identification number for social security of the credential subject.
         */
        const val SOCIAL_SECURITY_NUMBER = "social_security_number"

        /**
         * Details of the institution issuing the EHIC, including its identifier and official name.
         */
        const val PREFIX_ISSUING_AUTHORITY = "issuing_authority"

        /**
         * The unique identifier of the issuing authority,
         * typically registered in the EESSI system.
         */
        const val ISSUING_AUTHORITY_ID = "$PREFIX_ISSUING_AUTHORITY.id"

        /**
         * The legal name of the issuing authority responsible for delivering the EHIC,
         * typically registered in the EESSI system.
         */
        const val ISSUING_AUTHORITY_NAME = "$PREFIX_ISSUING_AUTHORITY.name"

        object IssuingAuthority {
            const val id = "id"
            const val name = "name"
        }

        /**
         * The unique document identifier assigned by the issuing institution for the EHIC.
         */
        const val DOCUMENT_NUMBER = "document_number"

        /**
         * Issuance date of the EHIC credential,
         * represented as a full-date (YYYY-MM-DD) in accordance with ISO 8601-1 and RFC 3339.
         */
        const val ISSUANCE_DATE = "issuance_date"

        /**
         * Expiry date of the administrative validity period of the EHIC credential,
         * represented as a full-date (YYYY-MM-DD) in accordance with ISO 8601-1 and RFC 3339.
         */
        const val EXPIRY_DATE = "expiry_date"
    }
}

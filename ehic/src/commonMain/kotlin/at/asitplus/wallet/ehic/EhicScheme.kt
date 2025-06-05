package at.asitplus.wallet.ehic

import at.asitplus.wallet.lib.data.ConstantIndex.CredentialRepresentation
import at.asitplus.wallet.lib.data.ConstantIndex.CredentialRepresentation.SD_JWT
import at.asitplus.wallet.lib.data.ConstantIndex.CredentialScheme

object EhicScheme : CredentialScheme {

    override val schemaUri: String = "https://wallet.a-sit.at/schemas/1.1.0/ehic.json"
    override val sdJwtType: String = "urn:eudi:ehic:1"
    override val supportedRepresentations: Collection<CredentialRepresentation> =
        listOf(SD_JWT)

    override val claimNames: Collection<String> = listOf(
        Attributes.ISSUING_COUNTRY,
        Attributes.SOCIAL_SECURITY_NUMBER,
        Attributes.PERSONAL_ADMINISTRATIVE_NUMBER,
        Attributes.PREFIX_ISSUING_AUTHORITY,
        Attributes.ISSUING_AUTHORITY_ID,
        Attributes.ISSUING_AUTHORITY_NAME,
        Attributes.PREFIX_AUTHENTIC_SOURCE,
        Attributes.AUTHENTIC_SOURCE_ID,
        Attributes.AUTHENTIC_SOURCE_NAME,

        Attributes.DOCUMENT_NUMBER,
        Attributes.ISSUANCE_DATE,
        Attributes.DATE_OF_ISSUANCE,
        Attributes.EXPIRY_DATE,
        Attributes.DATE_OF_EXPIRY,
        Attributes.STARTING_DATE,
        Attributes.ENDING_DATE,
    )

    val requiredClaims: Collection<String> = claimNames

    object Attributes {
        /**
         * EHIC issuing country.
         */
        const val ISSUING_COUNTRY = "issuing_country"

        /**
         * The personal identification number for social security of the credential subject.
         */
        @Deprecated("Removed in latest draft", ReplaceWith(PERSONAL_ADMINISTRATIVE_NUMBER))
        const val SOCIAL_SECURITY_NUMBER = "social_security_number"

        /**
         * Unique personal identifier used by social security services.
         */
        const val PERSONAL_ADMINISTRATIVE_NUMBER = "personal_administrative_number"

        /**
         * Details of the institution issuing the EHIC, including its identifier and official name.
         */
        const val PREFIX_ISSUING_AUTHORITY = "issuing_authority"

        /**
         * The unique identifier of the issuing authority, typically registered in the EESSI system.
         */
        const val ISSUING_AUTHORITY_ID = "$PREFIX_ISSUING_AUTHORITY.${IssuingAuthority.ID}"

        /**
         * The legal name of the issuing authority responsible for delivering the EHIC,
         * typically registered in the EESSI system.
         */
        const val ISSUING_AUTHORITY_NAME = "$PREFIX_ISSUING_AUTHORITY.${IssuingAuthority.NAME}"

        object IssuingAuthority {
            /**
             * The unique identifier of the issuing authority, typically registered in the EESSI system.
             */
            const val ID = "id"

            /**
             * The legal name of the issuing authority responsible for delivering the EHIC,
             * typically registered in the EESSI system.
             */
            const val NAME = "name"
        }

        /**
         * Competent institution.
         */
        const val PREFIX_AUTHENTIC_SOURCE = "authentic_source"

        /**
         * Identifier of the competent insitution as registered in the EESSI Institution Repository.
         */
        const val AUTHENTIC_SOURCE_ID = "$PREFIX_AUTHENTIC_SOURCE.${AuthenticSource.ID}"

        /**
         * Name of the competent insitution as registered in the EESSI Institution Repository.
         */
        const val AUTHENTIC_SOURCE_NAME = "$PREFIX_AUTHENTIC_SOURCE.${AuthenticSource.NAME}"

        object AuthenticSource {
            /**
             * Identifier of the competent insitution as registered in the EESSI Institution Repository.
             */
            const val ID = "id"

            /**
             * Name of the competent insitution as registered in the EESSI Institution Repository.
             */
            const val NAME = "name"
        }

        /**
         * The unique document identifier assigned by the issuing institution for the EHIC.
         */
        const val DOCUMENT_NUMBER = "document_number"

        /**
         * Issuance date of the EHIC credential,
         * represented as a full-date (YYYY-MM-DD) in accordance with ISO 8601-1 and RFC 3339.
         */
        @Deprecated("Removed in latest draft", ReplaceWith(DATE_OF_ISSUANCE))
        const val ISSUANCE_DATE = "issuance_date"

        /**
         * EHIC validity start date.
         */
        const val DATE_OF_ISSUANCE = "date_of_issuance"

        /**
         * Expiry date of the administrative validity period of the EHIC credential,
         * represented as a full-date (YYYY-MM-DD) in accordance with ISO 8601-1 and RFC 3339.
         */
        @Deprecated("Removed in latest draft", ReplaceWith(DATE_OF_EXPIRY))
        const val EXPIRY_DATE = "expiry_date"

        /**
         * EHIC expiration date.
         */
        const val DATE_OF_EXPIRY = "date_of_expiry"

        /**
         * Start date of the insurance coverage.
         */
        const val STARTING_DATE = "starting_date"

        /**
         * End date of the insurance coverage.
         */
        const val ENDING_DATE = "ending_date"

    }
}

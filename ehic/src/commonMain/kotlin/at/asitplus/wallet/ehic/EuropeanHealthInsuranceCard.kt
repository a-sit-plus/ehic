package at.asitplus.wallet.ehic


import at.asitplus.wallet.ehic.EhicScheme.Attributes
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class EuropeanHealthInsuranceCard(
    /**
     * The country where the issuing institution operates, represented as a two-letter country code compliant with ISO 3166-1 alpha-2.
     */
    @SerialName(Attributes.ISSUING_COUNTRY)
    val issuingCountry: String,

    /**
     * The personal identification number for social security of the credential subject.
     */
    @SerialName(Attributes.SOCIAL_SECURITY_NUMBER)
    val socialSecurityNumber: String,

    /**
     * Character string that enables the health care provider to identify the person via international search mask
     * (national format)
     */
    @SerialName(Attributes.PREFIX_ISSUING_AUTHORITY)
    val issuingAuthority: IssuingAuthority,

    /**
     * The unique document identifier assigned by the issuing institution for the EHIC.
     */
    @SerialName(Attributes.DOCUMENT_NUMBER)
    val documentNumber: String,

    /**
     * Issuance date of the EHIC credential,
     * represented as a full-date (YYYY-MM-DD) in accordance with ISO 8601-1 and RFC 3339.
     */
    @SerialName(Attributes.ISSUANCE_DATE)
    val issuanceDate: Instant,

    /**
     * Expiry date of the administrative validity period of the EHIC credential,
     * represented as a full-date (YYYY-MM-DD) in accordance with ISO 8601-1 and RFC 3339.
     */
    @SerialName(Attributes.EXPIRY_DATE)
    val expiryDate: Instant,
)
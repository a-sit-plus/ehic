package at.asitplus.wallet.ehic


import at.asitplus.wallet.ehic.EhicScheme.Attributes
import com.ionspin.kotlin.bignum.Endianness
import kotlinx.datetime.LocalDate
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
    @Deprecated("Removed in latest draft", ReplaceWith(Attributes.PERSONAL_ADMINISTRATIVE_NUMBER))
    val socialSecurityNumber: String? = null,

    /**
     * Unique personal identifier used by social security services.
     */
    @SerialName(Attributes.PERSONAL_ADMINISTRATIVE_NUMBER)
    val personalAdministrativeNumber: String,

    /**
     * Details of the institution issuing the EHIC, including its identifier and official name.
     */
    @SerialName(Attributes.PREFIX_ISSUING_AUTHORITY)
    val issuingAuthority: IssuingAuthority,

    /**
     * Competent institution.
     */
    @SerialName(Attributes.PREFIX_AUTHENTIC_SOURCE)
    val authenticSource: AuthenticSource,

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
    @Deprecated("Removed in latest draft", ReplaceWith(Attributes.DATE_OF_ISSUANCE))
    val issuanceDate: LocalDate? = null,

    /**
     * EHIC validity start date.
     */
    @SerialName(Attributes.DATE_OF_ISSUANCE)
    val dateOfIssuance: LocalDate,

    /**
     * Expiry date of the administrative validity period of the EHIC credential,
     * represented as a full-date (YYYY-MM-DD) in accordance with ISO 8601-1 and RFC 3339.
     */
    @SerialName(Attributes.EXPIRY_DATE)
    @Deprecated("Removed in latest draft", ReplaceWith(Attributes.DATE_OF_EXPIRY))
    val expiryDate: LocalDate? = null,

    /**
     * EHIC expiration date.
     */
    @SerialName(Attributes.DATE_OF_EXPIRY)
    val dateofExpiry: LocalDate,

    /**
     * Start date of the insurance coverage.
     */
    @SerialName(Attributes.STARTING_DATE)
    val startingDate: LocalDate,

    /**
     * End date of the insurance coverage.
     */
    @SerialName(Attributes.ENDING_DATE)
    val endingDate: LocalDate,
)
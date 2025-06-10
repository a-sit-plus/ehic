package at.asitplus.wallet.ehic

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthenticSource(
    /**
     * Identifier of the competent insitution as registered in the EESSI Institution Repository.
     */
    @SerialName(EhicScheme.Attributes.AuthenticSource.ID)
    val id: String,

    /**
     * Name of the competent insitution as registered in the EESSI Institution Repository.
     */
    @SerialName(EhicScheme.Attributes.AuthenticSource.NAME)
    val name: String,
)

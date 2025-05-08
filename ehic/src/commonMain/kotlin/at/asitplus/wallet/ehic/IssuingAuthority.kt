package at.asitplus.wallet.ehic

import kotlinx.serialization.Serializable

@Serializable
data class IssuingAuthority(
    /**
     * The unique identifier of the issuing authority,
     * typically registered in the EESSI system.
     */
    val id: String,
    /**
     * The legal name of the issuing authority responsible for delivering the EHIC,
     * typically registered in the EESSI system.
     */
    val name: String,
)

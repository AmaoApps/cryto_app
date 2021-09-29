package pe.paku.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import pe.paku.cryptoapp.domain.model.Crypto

data class CryptoDTO(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

//Converter CryptoDTO to Crypto
fun CryptoDTO.toCrypto(): Crypto {
    return Crypto(
        id = id,
        isActive = isActive,
        isNew = isNew,
        name = name,
        rank = rank,
        symbol = symbol
    )
}
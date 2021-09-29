package pe.paku.cryptoapp.domain.model

data class Crypto(
    val id: String,
    val isActive: Boolean,
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)

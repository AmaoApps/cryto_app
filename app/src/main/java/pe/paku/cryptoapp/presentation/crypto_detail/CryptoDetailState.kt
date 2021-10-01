package pe.paku.cryptoapp.presentation.crypto_detail

import pe.paku.cryptoapp.domain.model.Crypto
import pe.paku.cryptoapp.domain.model.CryptoDetail

data class CryptoDetailState(

    val isLoading: Boolean = false,
    val crypto: CryptoDetail? = null,
    val error: String = ""

)

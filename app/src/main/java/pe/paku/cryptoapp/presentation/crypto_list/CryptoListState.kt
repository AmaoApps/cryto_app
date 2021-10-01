package pe.paku.cryptoapp.presentation.crypto_list

import pe.paku.cryptoapp.domain.model.Crypto

data class CryptoListState(

    val isLoading: Boolean = false,
    val cryptos: List<Crypto> = emptyList(),
    val error: String = ""

)

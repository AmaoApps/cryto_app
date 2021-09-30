package pe.paku.cryptoapp.domain.repository

import pe.paku.cryptoapp.data.remote.dto.CryptoDTO
import pe.paku.cryptoapp.data.remote.dto.CryptoDetailDTO

interface CryptoRepository {

    //functions to call api rest
    suspend fun getCryptos(): List<CryptoDTO>

    suspend fun getCryptoById(coinId : String) : CryptoDetailDTO

    //Functiosn to call database


}
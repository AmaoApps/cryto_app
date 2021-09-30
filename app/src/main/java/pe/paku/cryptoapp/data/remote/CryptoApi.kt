package pe.paku.cryptoapp.data.remote

import pe.paku.cryptoapp.data.remote.dto.CryptoDTO
import pe.paku.cryptoapp.data.remote.dto.CryptoDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("/v1/coins")
    suspend fun getCryptos() : List<CryptoDTO>

    @GET("/v1/coins/{coindId}")
    suspend fun getDetailCrypto(@Path("coindId") coindId:String) : CryptoDetailDTO

}
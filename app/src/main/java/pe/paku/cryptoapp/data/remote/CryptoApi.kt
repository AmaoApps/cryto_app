package pe.paku.cryptoapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("/v1/coins")
    suspend fun getCoins()

    @GET("/v1/coins/{coindId}")
    suspend fun getListCoins(@Path("coindId") coindId:String)

}
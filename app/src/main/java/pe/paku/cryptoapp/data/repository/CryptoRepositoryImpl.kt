package pe.paku.cryptoapp.data.repository

import pe.paku.cryptoapp.data.remote.CryptoApi
import pe.paku.cryptoapp.data.remote.dto.CryptoDTO
import pe.paku.cryptoapp.data.remote.dto.CryptoDetailDTO
import pe.paku.cryptoapp.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val api: CryptoApi
) : CryptoRepository {


    override suspend fun getCryptos(): List<CryptoDTO> {
         return api.getCryptos()
    }

    override suspend fun getCryptoById(coinId: String): CryptoDetailDTO {
        return api.getDetailCrypto(coindId = coinId)
    }


}
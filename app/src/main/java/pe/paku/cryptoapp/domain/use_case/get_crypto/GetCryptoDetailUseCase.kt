package pe.paku.cryptoapp.domain.use_case.get_crypto

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.paku.cryptoapp.common.Resource
import pe.paku.cryptoapp.data.remote.dto.toCryptoDetail
import pe.paku.cryptoapp.domain.model.Crypto
import pe.paku.cryptoapp.domain.model.CryptoDetail
import pe.paku.cryptoapp.domain.repository.CryptoRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCryptoDetailUseCase @Inject constructor(
    private val cryptoRepository: CryptoRepository
) {

    operator fun invoke(crytoId: String) : Flow<Resource<CryptoDetail>> = flow {

        try {

            emit(Resource.Loading())
            val cryptoDetail = cryptoRepository.getCryptoById(crytoId).toCryptoDetail()
            emit(Resource.Success<CryptoDetail>(cryptoDetail))

        } catch (e: HttpException){
            emit(Resource.Error<CryptoDetail>(e.localizedMessage ?: "An Error just appeared right now"))
        } catch (e: IOException){
            emit(Resource.Error<CryptoDetail>("We can't to connect to the server."))
        }

    }

}
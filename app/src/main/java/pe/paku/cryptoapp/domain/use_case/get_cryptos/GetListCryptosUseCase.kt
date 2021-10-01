package pe.paku.cryptoapp.domain.use_case.get_cryptos

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pe.paku.cryptoapp.common.Resource
import pe.paku.cryptoapp.data.remote.dto.toCrypto
import pe.paku.cryptoapp.domain.model.Crypto
import pe.paku.cryptoapp.domain.repository.CryptoRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetListCryptosUseCase @Inject constructor(
    private val cryptoRepository: CryptoRepository
) {

    operator fun invoke(): Flow<Resource<List<Crypto>>> = flow {
        try {

            //Loading of call
            emit(Resource.Loading())
            val cryptos = cryptoRepository.getCryptos().map { it.toCrypto() }
            emit(Resource.Success<List<Crypto>>(cryptos))

        } catch (e: HttpException){
            emit(Resource.Error<List<Crypto>>(e.localizedMessage ?: "un Error acaba de ocurrir"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Crypto>>("Couldn¡t reach server. Check your connection"))
        }
    }

}
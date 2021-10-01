package pe.paku.cryptoapp.presentation.crypto_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pe.paku.cryptoapp.common.Constans
import pe.paku.cryptoapp.common.Resource
import pe.paku.cryptoapp.domain.use_case.get_crypto.GetCryptoDetailUseCase
import pe.paku.cryptoapp.domain.use_case.get_cryptos.GetListCryptosUseCase
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
  private val getCryptoDetailUseCase: GetCryptoDetailUseCase,
  savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CryptoDetailState())
    val state : State<CryptoDetailState> = _state

    init {
        savedStateHandle.get<String>(Constans.PARAMETER_CRYPTO_DETAIL)?.let {
            getCryptoDetail(it)
        }
    }

    private fun getCryptoDetail(cryptoId: String){
      println("Id del Crypto -> " + cryptoId)
      getCryptoDetailUseCase(cryptoId).onEach { result ->
        when(result){
          is Resource.Success -> {
            _state.value = CryptoDetailState(crypto = result.data)
          }
          is Resource.Loading -> {
            _state.value = CryptoDetailState(isLoading = true)
          }
          is Resource.Error -> {
            _state.value = CryptoDetailState(error = result.message ?: "An unexpected error ocurred")
          }
        }
      }.launchIn(viewModelScope)
    }


}
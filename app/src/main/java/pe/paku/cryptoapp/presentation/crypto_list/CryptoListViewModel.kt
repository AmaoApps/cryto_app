package pe.paku.cryptoapp.presentation.crypto_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import pe.paku.cryptoapp.common.Resource
import pe.paku.cryptoapp.domain.use_case.get_cryptos.GetListCryptosUseCase
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
  private val getListCryptosUseCase: GetListCryptosUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CryptoListState())
    val state : State<CryptoListState> = _state

    init {
        getCryptos()
    }

    private fun getCryptos(){
      getListCryptosUseCase().onEach { result ->
        when(result){
          is Resource.Success -> {
            _state.value = CryptoListState(cryptos = result.data ?: emptyList())
          }
          is Resource.Loading -> {
            _state.value = CryptoListState(isLoading = true)
          }
          is Resource.Error -> {
            _state.value = CryptoListState(error = result.message ?: "An unexpected error ocurred")
          }
        }
      }.launchIn(viewModelScope)
    }


}
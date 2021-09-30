package pe.paku.cryptoapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import pe.paku.cryptoapp.common.Constans
import pe.paku.cryptoapp.data.remote.CryptoApi
import pe.paku.cryptoapp.data.repository.CryptoRepositoryImpl
import pe.paku.cryptoapp.domain.repository.CryptoRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCryptoAPI(): CryptoApi{
        return Retrofit.Builder()
            .baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun providesCryptoRepository(api: CryptoApi) : CryptoRepository {
        return CryptoRepositoryImpl(api)
    }

}
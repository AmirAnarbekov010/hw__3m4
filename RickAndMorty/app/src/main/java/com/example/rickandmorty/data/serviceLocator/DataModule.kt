package com.example.rickandmorty.data.serviceLocator
import FavoriteCharactersRepository
import androidx.room.Room
import com.example.rickandmorty.data.api.CharacterApiService
import com.example.rickandmorty.data.api.EpisodeApiService
import com.example.rickandmorty.data.api.LocationApiService
import com.example.rickandmorty.data.db.AppDatabase
import com.example.rickandmorty.data.repository.CharactersRepository
import com.example.rickandmorty.data.repository.EpisodesRepository
import com.example.rickandmorty.data.repository.LocationsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {
    //retrofit
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }

    //room
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "app_database").build() }
    single { get<AppDatabase>().favoriteCharacterDao() }

    //api
    single { get<Retrofit>().create(CharacterApiService::class.java) }
    single { get<Retrofit>().create(LocationApiService::class.java) }
    single { get<Retrofit>().create(EpisodeApiService::class.java) }

    //repo
    single { CharactersRepository(get()) }
    single { LocationsRepository(get()) }
    single { EpisodesRepository(get()) }
    single { FavoriteCharactersRepository(get()) }
}

private const val BASE_URL = "https://rickandmortyapi.com/"

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}
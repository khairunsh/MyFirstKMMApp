package com.shii.myfirstkmmapp

import com.shii.myfirstkmmapp.model.RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Greeting {
    private val platform: Platform = getPlatform()

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    @Throws(Exception::class)
    suspend fun greet(): String {
        val rockets: List<RocketLaunch> = httpClient.get("https://api.spacexdata.com/v4/launches").body()

        val lastSuccessLaunch = rockets.last { it.launchSuccess == true }

        return "Hello, ${platform.name.reversed()}!" +
            "\n\nThere are only ${daysUntilNewYear()} days left until New Year! \uD83C\uDF86" +
            "\n\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} \uD83D\uDE80"
    }
}

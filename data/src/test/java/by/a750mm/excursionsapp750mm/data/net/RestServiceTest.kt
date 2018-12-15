/*
package by.a750mm.excursionsapp750mm.data.net

import by.a750mm.excursionsapp750mm.data.entity.ExcursionResponse
import by.a750mm.excursionsapp750mm.domain.entity.AppErrorType
import by.a750mm.excursionsapp750mm.domain.entity.AppException
import io.reactivex.functions.Predicate
import io.reactivex.observers.TestObserver
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import java.io.IOException


@RunWith(MockitoJUnitRunner::class)
class RestServiceTest {
    private var restService: RestService? = null
    var server = MockWebServer()

    @Before
    @Throws(IOException::class)
    fun setUp() {
        server.start()
        val url = server.url("/")
        restService = RestService(url.toString())
    }

    @After
    @Throws(IOException::class)
    fun release() {
        server.shutdown()
    }

    @Test
    @Throws(Exception::class)
    fun testServerError() {
        val response = MockResponse()
        response.setResponseCode(400)
        response.setBody("{\"message\":\"test error\", \"errorCode\": 400}")
        server.enqueue(response)
        val subscriber = TestObserver<List<ExcursionResponse>>()

        restService?.getExcursions()?.subscribe(subscriber)

        subscriber.assertError(Predicate<Throwable> { throwable ->
            if (throwable is AppException) {
                val appError = throwable as AppException
                if (appError.errorType == AppErrorType.INCORRECT_ID) {
                    return@Predicate true
                }
            }

            false
        })

        subscriber.dispose()
    }


}
*/

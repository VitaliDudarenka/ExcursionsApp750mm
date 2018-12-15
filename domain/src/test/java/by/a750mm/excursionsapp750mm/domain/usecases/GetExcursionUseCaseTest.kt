package by.a750mm.excursionsapp750mm.domain.usecases

import by.a750mm.excursionsapp750mm.domain.entity.Excursion
import by.a750mm.excursionsapp750mm.domain.repositories.ExcursionRepository
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.TestScheduler
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetExcursionUseCaseTest {
    @Mock
    private val excursionRepository:ExcursionRepository? = null

    private var getExcursionUseCase: GetExcursionUseCase? = null

    private var testScheduler: TestScheduler? = null

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

        testScheduler = TestScheduler()
        getExcursionUseCase = GetExcursionUseCase(this.excursionRepository!!)
        getExcursionUseCase!!.postExecutorThread = testScheduler as TestScheduler
        getExcursionUseCase!!.workExecutorThread = testScheduler as TestScheduler
    }

    @Test
    fun testPositiveOnValidData() {


        val listData = ArrayList<Excursion>()
        listData.add(Excursion("1", "name1", "asdf","aaa","sdfsdgb",
                "fff",121242134,20,20))
        listData.add(Excursion("2", "name2", "asdf","aaa","sdfsdgb",
                "fff",121242134,20,20))

        `when`(excursionRepository!!.get()).thenReturn(Observable.just<List<Excursion>>(listData))

        val subscriber = TestObserver<List<Excursion>>()

        getExcursionUseCase!!
                .get()
                .subscribe(subscriber)

        testScheduler!!.triggerActions()

        subscriber.assertValueCount(1)
        subscriber.assertSubscribed()
        subscriber.assertValue(listData)
        subscriber.dispose()
    }
}




package by.a750mm.excursionsapp750mm.presentation.screen.excursion.booking

import android.annotation.SuppressLint
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import by.a750mm.excursionsapp750mm.domain.entity.Booking
import by.a750mm.excursionsapp750mm.domain.usecases.AddBookingUseCase
import by.a750mm.excursionsapp750mm.domain.usecases.GetByIdUseCase
import by.a750mm.excursionsapp750mm.presentation.app.App
import by.a750mm.excursionsapp750mm.presentation.base.BaseViewModel
import by.a750mm.excursionsapp750mm.presentation.screen.excursion.ExcursionRouter
import io.reactivex.rxkotlin.subscribeBy
import java.text.SimpleDateFormat
import javax.inject.Inject


class ExcursionBookingViewModel : BaseViewModel<ExcursionRouter>() {
    val name = ObservableField<String>(" ")
    val imgUrl = ObservableField<String>("")
    val date = ObservableField<String>(" ")
    val seats = ObservableField<Int>(0)
    val customerName = ObservableField<String>("")
    val customerSurname = ObservableField<String>("")
    val email = ObservableField<String>("")
    val number = ObservableField<String>("")
    val note = ObservableField<String>("")
    val seatsBook = ObservableField<String>("0")
    private var excursionId: String? = null
    val isProgressEnabled = ObservableBoolean(false)
    @SuppressLint("SimpleDateFormat")
    private val df2 = SimpleDateFormat("dd/MM/yyyy")
    @Inject
    lateinit var excursionUseCase: GetByIdUseCase
    @Inject
    lateinit var bookingUseCase: AddBookingUseCase


    fun setExcursionId(id: String) {
        if (excursionId != null) return
        excursionId = id
        App.appComponent.inject(this)
        isProgressEnabled.set(true)
        val disposable = excursionUseCase.getById(id).subscribeBy(
                onNext = {
                    name.set(it.name)
                    val dateText = df2.format(it.nextDate)
                    date.set(dateText)
                    imgUrl.set(it.imgUrl)
                    seats.set(it.seatsRest)
                    isProgressEnabled.set(false)
                },
                onError = {
                    isProgressEnabled.set(false)
                    router?.showError(it)
                }
        )
        addToDisposable(disposable)

    }

    fun onClickBook() {
        if (!checkRegForm()) {
            router?.showBookingError()
            return
        }
        if (!checkSeatsMax()) {
            router?.showSeatsError()
            return
        }
        val booking = Booking(id = System.currentTimeMillis().toString(), seats = Integer.parseInt(seatsBook.get()!!),
                name = name.get()!!, customerName = customerName.get()!!, customerSurname = customerSurname.get()!!,
                number = number.get()!!, email = email.get()!!, note = note.get()!!)
        App.appComponent.inject(this)
        val disposable = bookingUseCase.add(booking).subscribeBy(
                onComplete = {
                    router!!.goToExcursionList()
                    router!!.showBookingComplete()
                },
                onError = {
                    isProgressEnabled.set(false)
                    router?.showError(it)
                }
        )
        addToDisposable(disposable)
    }

    override fun onCleared() {
    }

    private fun checkRegForm(): Boolean {
        return !(customerName.get()!!.isEmpty() || customerSurname.get()!!.isEmpty() || number.get()!!.isEmpty() || email.get()!!.isEmpty()
                || Integer.parseInt(seatsBook.get()!!) == 0)
    }

    fun onClickPlus() {
        if (Integer.parseInt(seatsBook.get()!!) < seats.get()!!)
            seatsBook.set((Integer.parseInt(seatsBook.get()!!) + 1).toString())
        else
            return
    }

    fun onClickMinus() {
        if (Integer.parseInt(seatsBook.get()!!) > 0)
            seatsBook.set((Integer.parseInt(seatsBook.get()!!) - 1).toString())
        else
            return
    }

    private fun checkSeatsMax(): Boolean {
        return Integer.parseInt(seatsBook.get()!!) <= seats.get()!!
    }

}

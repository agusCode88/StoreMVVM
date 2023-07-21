package cl.porfolio.storemvvm.ui.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cl.porfolio.storemvvm.ui.common.entities.StoreEntity
import cl.porfolio.storemvvm.ui.mainModule.model.MainInteractor
import cl.porfolio.storemvvm.ui.mainModule.model.MainInteractorCallback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(), MainInteractorCallback {

    private val stores: MutableLiveData<List<StoreEntity>> = MutableLiveData()

    init {
        loadStores()
    }

    fun getStores(): MutableLiveData<List<StoreEntity>> {
        return stores
    }

    private fun loadStores() {
        // Creamos una instancia del MainInteractor y pasamos el ViewModel como callback
        val mainInteractor = MainInteractor(this)

        // Ejecutamos la corutina en el hilo de fondo
        GlobalScope.launch(Dispatchers.IO) {
            // Obtenemos los datos de la base de datos mediante la corutina suspendida
            mainInteractor.getAllStores()
        }
    }

    // Implementamos el método del callback para recibir los datos del Modelo
    override fun onStoresLoaded(stores: MutableList<StoreEntity>) {
        this.stores.postValue(stores)
    }
}
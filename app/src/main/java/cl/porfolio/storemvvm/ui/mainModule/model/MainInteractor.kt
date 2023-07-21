package cl.porfolio.storemvvm.ui.mainModule.model

import cl.porfolio.storemvvm.ui.common.entities.StoreEntity
import cl.porfolio.storemvvm.ui.StoreApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface MainInteractorCallback {
    fun onStoresLoaded(stores: MutableList<StoreEntity>)
}


class MainInteractor(private val callback: MainInteractorCallback) {

    suspend fun getAllStores() {
        withContext(Dispatchers.IO) {
            // lógica para obtener los datos reales de la base de datos.
            val storeList = StoreApplication.database.storeDao().getAllStores()

            // Llamamos al método del callback para entregar los datos al ViewModel.
            callback.onStoresLoaded(storeList)
        }
    }
}
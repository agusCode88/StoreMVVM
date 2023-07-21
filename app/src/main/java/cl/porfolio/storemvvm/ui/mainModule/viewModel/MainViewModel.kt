package cl.porfolio.storemvvm.ui.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.porfolio.storemvvm.ui.StoreApplication
import cl.porfolio.storemvvm.ui.common.entities.StoreEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*
Clase encargada de entregarle todos los datos provenientes de la BD
a la vista.
 */
class MainViewModel: ViewModel() {

    // Acá se almacenaran todas tiendas del modelo que tenemos
    private var stores : MutableLiveData<List<StoreEntity>> = MutableLiveData()

    init {
        loadStores()
    }

    // Esta es la propiedad que será observada para notificar en la vista
    fun getStores():MutableLiveData<List<StoreEntity>>{
        return stores
    }

    private fun loadStores(){
        viewModelScope.launch(Dispatchers.IO) {
            val storeList = StoreApplication.database.storeDao().getAllStores()
            withContext(Dispatchers.Main) {
                 stores.value = storeList

            }
        }
    }
}
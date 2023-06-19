package cl.porfolio.storemvvm.ui.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.porfolio.storemvvm.ui.StoreApplication
import cl.porfolio.storemvvm.ui.common.entities.StoreEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private var stores : MutableLiveData<List<StoreEntity>>

    init {
        stores = MutableLiveData()
        loadStores()
    }

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
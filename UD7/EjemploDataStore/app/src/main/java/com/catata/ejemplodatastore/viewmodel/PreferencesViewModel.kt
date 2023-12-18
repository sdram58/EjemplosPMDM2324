package com.catata.ejemplodatastore.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.catata.ejemplodatastore.User
import com.catata.ejemplodatastore.preferences.AppPreferences
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

//Como se necessita el contexto el viewModel se extiende de AndroidViewModel para que el propio
//Sistema operativa le pase el objeto Application del que se recuperará el contexto
class PreferencesViewModel(application: Application):AndroidViewModel(application) {
    //Declaración del objeto para guardar/almacenar preferencias
    private val preferences = AppPreferences(application.applicationContext)

    private var _id = MutableLiveData<Int>()
    val id:LiveData<Int> get() = _id

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private var _email = MutableLiveData<String>()
    val email:LiveData<String> get() = _email
    fun onUserNameChange(username:String){
        _username.value = username
    }

    fun onEmailChange(email:String){
        _email.value = email
    }

    //Método que llama a AppPreferences para almacenar la preferencia en el archivo de preferencias
    fun saveUser(user: User){
        viewModelScope.launch {
            preferences.saveUser(user)
            _username.postValue("")
        }
    }

    //Método que llama a Appreferences para recuperar la preferencia del archivo de preferencias
    fun loadFullName(){
        viewModelScope.launch {
            //Como loadName devuelve un Flow para recuparar sus datos se usa el método collect()
            preferences.loadUser().collect(){
                _username.postValue(it.username)
                _email.postValue(it.email)
                _id.postValue(it.id)
            }
        }
    }
}
package com.catata.ejemplodatastore.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.catata.ejemplodatastore.User
import kotlinx.coroutines.flow.map

class AppPreferences(val context: Context) {
    //Variables estáticas para representar las calves de los valores a guardar
    companion object{
        val FULL_NAME = stringPreferencesKey("FULL_NAME")
        val EMAIL = stringPreferencesKey("EMAIL")
        val ID = intPreferencesKey("ID")
    }

    //Variable DataStore a la que se le pasa el nombre del archivo de preferencias "preferences"
    //Al declararla con el delegado "by" la variable será un singleton: solo habrá una instancia
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "preferences")

    //Función que recibe un String y lo almacena en el archivo de preferencias declarado en el DataStore
    //El guardado se debe realizar en segundo plano por lo que necesitará una corrutina para ello
    //se añade la palabra suspend para indicar que cuando se realice la llamada se use una corrutina
    suspend fun saveUser(user: User){
        context.dataStore.edit {preferences ->
            preferences[FULL_NAME] = user.username
            preferences[EMAIL] = user.email
            preferences[ID] = user.id
        }
    }

    //Función que recupera un String del archivo de preferencias declarado en el DataStore.
    //Esta función devuelve un Flow
    fun loadUser()= context.dataStore.data.map { preferences ->
        User(
            username = preferences[FULL_NAME] ?: "",
            email = preferences[EMAIL] ?: "",
            id = preferences[ID] ?: 0
        )
    }
}
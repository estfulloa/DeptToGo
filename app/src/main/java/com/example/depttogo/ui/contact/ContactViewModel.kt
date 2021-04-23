package com.example.depttogo.ui.contact

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ContactViewModel {
    private val _text = MutableLiveData<String>().apply {
        value = "Pantalla para el contacto"
    }
    val text: LiveData<String> = _text
}

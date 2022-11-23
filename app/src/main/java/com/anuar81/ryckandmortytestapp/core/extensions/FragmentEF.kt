package com.anuar81.ryckandmortytestapp.core.extensions

import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anuar81.ryckandmortytestapp.domain.core.nav.NavModel

fun Fragment.onNavigate(navModel: NavModel) {
    navModel.navId?.let {
        this.findNavController().navigate(navModel.navId, navModel.bundle, navModel.navOptions)
    }
}

fun Fragment.clearInputs(listOfInputs: List<EditText>) {
    for (item in listOfInputs) {
        item.text.clear()
    }
}

package com.anuar81.ryckandmortytestapp.domain.core.nav

import android.os.Bundle
import androidx.annotation.AnyRes
import androidx.navigation.NavOptions

data class NavModel(@AnyRes val navId: Int?, val bundle: Bundle? = null, val navOptions: NavOptions? = null)

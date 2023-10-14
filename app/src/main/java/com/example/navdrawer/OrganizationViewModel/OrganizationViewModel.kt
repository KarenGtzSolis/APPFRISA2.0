package com.example.navdrawer.UserViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navdrawer.model.OrganizationResponse
import com.example.navdrawer.service.OrgService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrganizationViewModel(private val orgService: OrgService) : ViewModel() {


    private val _getOrgResult = MutableStateFlow<OrganizationResponse?>(null)
    val getOrgResult: StateFlow<OrganizationResponse?> = _getOrgResult



    fun getUserFavoriteOrganization() {
        viewModelScope.launch {
            val response: OrganizationResponse
            try {
                response = orgService.getAllOrgs()
                _getOrgResult.value = response
            } catch (e: Exception) {

                val errorResponse = e.localizedMessage
                Log.d("ERROR-API", errorResponse)
                //_getUserFavoriteOrgsResult.value = errorResponse
            }
        }
    }
}
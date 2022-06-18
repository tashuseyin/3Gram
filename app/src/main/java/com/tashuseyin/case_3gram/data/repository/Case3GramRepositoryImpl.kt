package com.tashuseyin.case_3gram.data.repository

import com.tashuseyin.case_3gram.data.remote.Case3GramApi
import com.tashuseyin.case_3gram.domain.repository.Case3GramRepository
import javax.inject.Inject

class Case3GramRepositoryImpl @Inject constructor(
    private val api: Case3GramApi
) : Case3GramRepository {

    override suspend fun getAlbums() = api.getAlbums()


    override suspend fun getPhotos() = api.getPhotos()

    override suspend fun getComments() = api.getComments()
}
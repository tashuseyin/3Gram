package com.tashuseyin.case_3gram.domain.use_case.get_albums

import com.tashuseyin.case_3gram.common.Resource
import com.tashuseyin.case_3gram.data.toDomain
import com.tashuseyin.case_3gram.domain.model.AlbumItem
import com.tashuseyin.case_3gram.domain.repository.Case3GramRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(
    private val repository: Case3GramRepository
) {
    operator fun invoke(): Flow<Resource<List<AlbumItem>>> = flow {
        try {
            emit(Resource.Loading())
            val albums = repository.getAlbums().map { it.toDomain() }
            emit(Resource.Success(albums))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
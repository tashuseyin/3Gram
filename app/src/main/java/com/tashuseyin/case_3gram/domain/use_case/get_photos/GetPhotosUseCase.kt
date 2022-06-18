package com.tashuseyin.case_3gram.domain.use_case.get_photos

import com.tashuseyin.case_3gram.common.Resource
import com.tashuseyin.case_3gram.data.toDomain
import com.tashuseyin.case_3gram.domain.model.PhotoItem
import com.tashuseyin.case_3gram.domain.repository.Case3GramRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val repository: Case3GramRepository
) {
    operator fun invoke(): Flow<Resource<List<PhotoItem>>> = flow {
        try {
            emit(Resource.Loading())
            val photos = repository.getPhotos().map { it.toDomain() }
            emit(Resource.Success(photos))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}
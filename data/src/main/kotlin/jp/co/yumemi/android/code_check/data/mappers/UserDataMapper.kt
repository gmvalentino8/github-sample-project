package jp.co.yumemi.android.code_check.data.mappers

import jp.co.yumemi.android.code_check.data.models.UserModel
import jp.co.yumemi.android.code_check.domain.entities.User

object UserDataMapper {
    fun toEntity(model: UserModel) = User(
        id = model.id,
        name = model.name,
        username = model.username,
        iconUrl = model.iconUrl,
        description = model.bio
    )
}
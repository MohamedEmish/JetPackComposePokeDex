package com.amosh.jetpackcomposepokedex.data.remote.responses

import com.google.gson.annotations.SerializedName

data class Move(
    val move: DefaultDataObject,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)
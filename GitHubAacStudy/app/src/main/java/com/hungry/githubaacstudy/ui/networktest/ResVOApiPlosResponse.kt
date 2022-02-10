package com.hungry.githubaacstudy.ui.networktest

data class ResVOApiPlosResponse(
    var numFound: Int,
    var start: Int,
    var maxScore: Double,
    var docs: ArrayList<ResVOApiPlosResponseDocs>
)
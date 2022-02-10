package com.hungry.githubaacstudy.ui.networktest

data class ReqVOAppTokenSave(
    var token: String = "",
    var uuid: String,
    var os: String,
    var version: String,
    var app_name: String,
    var agree_yn: String = "",
    var model: String
)
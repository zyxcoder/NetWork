package com.base.network

/**
 * Create by zyx_coder on 2023/7/7
 */
data class DemoData(
    val live_review: List<LiveReview>,
    val nextPage: Int,
    val pageNo: Int,
    val sublives: List<Sublive>,
    val top: List<Top>
)

data class LiveReview(
    val confirm: Int,
    val endTime: String,
    val holdTime: Int,
    val image: String,
    val liveStatus: Int,
    val liveType: Int,
    val mutilVideo: Boolean,
    val pano: Boolean,
    val pcImage: String,
    val roomId: Int,
    val roomName: String,
    val source: String,
    val sourceinfo: Sourceinfo,
    val startTime: String,
    val type: Int,
    val userCount: Int,
    val video: Boolean,
    val videos: List<Video>
)

data class Sublive(
    val cid: String,
    val cname: String,
    val collectionId: Int,
    val ename: String,
    val icon: String,
    val tid: String,
    val tname: String,
    val userCount: Int,
    val userId: String
)

data class Top(
    val confirm: Int,
    val endTime: String,
    val image: String,
    val liveStatus: Int,
    val liveType: Int,
    val mutilVideo: Boolean,
    val pano: Boolean,
    val pcImage: String,
    val roomId: Int,
    val roomName: String,
    val source: String,
    val startTime: String,
    val userCount: Int,
    val video: Boolean
)

data class Sourceinfo(
    val certificationImg: String,
    val tcount: Int,
    val tid: String,
    val timg: String,
    val tname: String
)

data class Video(
    val flvUrl: String,
    val videoType: Int,
    val videoUrl: String
)
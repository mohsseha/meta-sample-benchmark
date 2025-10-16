package com.meta.mediaplayersample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class Video(
    val id: String,
    val title: String,
    val description: String,
    val videoUrl: String,
    val thumbnailUrl: String
)

class VideoPlayerViewModel : ViewModel() {

    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos: StateFlow<List<Video>> = _videos.asStateFlow()

    private val _selectedVideo = MutableStateFlow<Video?>(null)
    val selectedVideo: StateFlow<Video?> = _selectedVideo.asStateFlow()

    private val _isPassthroughEnabled = MutableStateFlow(false)
    val isPassthroughEnabled: StateFlow<Boolean> = _isPassthroughEnabled.asStateFlow()

    init {
        loadVideos()
    }

    private fun loadVideos() {
        viewModelScope.launch {
            // In a real app, you would load this from a remote or local data source.
            _videos.value = listOf(
                Video(
                    id = "1",
                    title = "Big Buck Bunny",
                    description = "A short animated film by the Blender Institute.",
                    videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                    thumbnailUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg"
                ),
                Video(
                    id = "2",
                    title = "Elephants Dream",
                    description = "A short animated film by the Blender Institute.",
                    videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                    thumbnailUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg"
                ),
                Video(
                    id = "3",
                    title = "For Bigger Blazes",
                    description = "A short animated film by the Blender Institute.",
                    videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                    thumbnailUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg"
                )
            )
        }
    }

    fun selectVideo(video: Video) {
        _selectedVideo.value = video
    }

    fun togglePassthrough() {
        _isPassthroughEnabled.value = !_isPassthroughEnabled.value
    }
}

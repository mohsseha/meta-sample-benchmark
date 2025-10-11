package com.meta.spatial.mediaplayersample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class Video(
    val id: Int,
    val title: String,
    val description: String,
    val videoUrl: String,
    val thumbnailUrl: String
)

class VideoViewModel : ViewModel() {

    private val _videos = MutableStateFlow<List<Video>>(emptyList())
    val videos: StateFlow<List<Video>> = _videos

    private val _selectedVideo = MutableStateFlow<Video?>(null)
    val selectedVideo: StateFlow<Video?> = _selectedVideo

    private val _isPassthroughEnabled = MutableStateFlow(false)
    val isPassthroughEnabled: StateFlow<Boolean> = _isPassthroughEnabled

    init {
        loadVideos()
    }

    private fun loadVideos() {
        viewModelScope.launch {
            // In a real app, you would load this from a remote server or local database
            _videos.value = listOf(
                Video(1, "Big Buck Bunny", "A short animated film", "asset:///videos/big_buck_bunny.mp4", "asset:///thumbnails/big_buck_bunny.png"),
                Video(2, "Elephants Dream", "A surreal animated film", "asset:///videos/elephants_dream.mp4", "asset:///thumbnails/elephants_dream.png")
            )
        }
    }

    fun onVideoSelected(video: Video) {
        _selectedVideo.value = video
    }

    fun onPassthroughToggled() {
        _isPassthroughEnabled.value = !_isPassthroughEnabled.value
    }
}

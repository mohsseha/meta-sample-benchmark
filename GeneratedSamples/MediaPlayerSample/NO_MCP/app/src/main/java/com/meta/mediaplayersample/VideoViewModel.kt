package com.meta.mediaplayersample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meta.mediaplayersample.data.VideoItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VideoViewModel : ViewModel() {

    private val _videoItems = MutableStateFlow<List<VideoItem>>(emptyList())
    val videoItems: StateFlow<List<VideoItem>> = _videoItems.asStateFlow()

    private val _selectedVideo = MutableStateFlow<VideoItem?>(null)
    val selectedVideo: StateFlow<VideoItem?> = _selectedVideo.asStateFlow()

    private val _isPassthroughEnabled = MutableStateFlow(false)
    val isPassthroughEnabled: StateFlow<Boolean> = _isPassthroughEnabled.asStateFlow()

    init {
        loadVideoItems()
    }

    private fun loadVideoItems() {
        viewModelScope.launch {
            // In a real app, you would load this from a remote or local data source.
            _videoItems.value = listOf(
                VideoItem(
                    1,
                    "Big Buck Bunny",
                    "A short computer-animated comedy film.",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg"
                ),
                VideoItem(
                    2,
                    "Elephants Dream",
                    "A computer-generated imagery film.",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg"
                ),
                VideoItem(
                    3,
                    "For Bigger Blazes",
                    "A short film by the Blender Foundation.",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4",
                    "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg"
                )
            )
        }
    }

    fun onVideoSelected(videoItem: VideoItem) {
        _selectedVideo.value = videoItem
    }

    fun togglePassthrough() {
        _isPassthroughEnabled.value = !_isPassthroughEnabled.value
    }
}

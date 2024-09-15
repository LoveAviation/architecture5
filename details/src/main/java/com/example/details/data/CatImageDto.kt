package com.example.details.data

import com.example.details.entity.CatImage
import javax.inject.Inject

class CatImageDto @Inject constructor(
    override val id: String,
    override val url: String,
    override val width: Int,
    override val height: Int
): CatImage
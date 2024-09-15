package com.example.list.data

import com.example.list.entity.CatFact
import javax.inject.Inject

class CatFactDto @Inject constructor(
    override val data: List<String>
) : CatFact
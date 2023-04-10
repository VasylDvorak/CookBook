package com.example.cookbook.ui.categories_fragment

interface IItemView {
    var pos: Int
}
interface CategoryItemView : IItemView {
    fun setName (text: String )
    fun loadPicture(url:String)
}

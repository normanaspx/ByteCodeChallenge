package com.normanaspx.prueba_tecnica.ext

object StringExt {

    /***
     * extension function to extend a class with new functionalities.
     * Basically, an extension function of a class that
     * is defined outside the class
     */
    fun String.toListString(): String = this.replace("[", "").replace("]", "")

}
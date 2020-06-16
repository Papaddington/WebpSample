package com.paddington.webptestactivity // 根据url后缀算出 图片高宽比例  isSquare高小于宽变成正方形
    fun getWithAndHeight(url: String?): Float {

        try {
            val start = url!!.lastIndexOf("[")
            val end = url.lastIndexOf("]")
            val startew = url.lastIndexOf("_")//新增下划线判断
            val endew = url.lastIndexOf(".")//新增下划线判断


            if (start == -1 || end == -1) {
                if (startew == -1 || endew == -1) {
                    return 0f
                }
                val temp = url.subSequence(startew + 1, endew)
                val array = temp.split("x")
                return if (array.size > 1) {
                    array[1].toFloat() / array[0].toFloat()
                } else {
                    1f
                }
            }

            if (start >= end) {
                return 0f
            }

            val temp = url.subSequence(start + 1, end)
            val array = temp.split("x")
            return if (array.size > 1) {
                array[1].toFloat() / array[0].toFloat()
            } else {
                1f
            }

        } catch (e: Exception) {
            e.printStackTrace()
            return 1f
        }
    }
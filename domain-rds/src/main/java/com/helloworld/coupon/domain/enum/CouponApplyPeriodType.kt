package com.helloworld.coupon.domain.enum

enum class CouponApplyPeriodType(val codeValue: String, val displayName: String) {
    PERIOD("0", "시작일, 종료일 선택"),
    ABSOLUTE("1", "발급일로부터 기간 제한");

    companion object {
        fun of(codeValue: String): CouponApplyPeriodType {
            return values().firstOrNull { it.codeValue == codeValue } ?: throw IllegalArgumentException()
        }
    }
}

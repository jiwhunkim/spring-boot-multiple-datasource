package com.helloworld.coupon.domain.entity

import com.helloworld.coupon.domain.converter.CouponApplyPeriodTypeConverter
import com.helloworld.coupon.domain.enum.CouponApplyPeriodType
import javax.persistence.*

@Entity(name = "coupons")
class Coupon(applyPeriodType: CouponApplyPeriodType) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
        protected set

    @Convert(converter = CouponApplyPeriodTypeConverter::class)
    @Column(name = "applyPeriodType", columnDefinition = "CHAR")
    var applyPeriodType: CouponApplyPeriodType = applyPeriodType
        protected set
}

package com.helloworld.coupon.domain.converter

import com.helloworld.coupon.domain.enum.CouponApplyPeriodType
import javax.persistence.AttributeConverter

class CouponApplyPeriodTypeConverter: AttributeConverter<CouponApplyPeriodType, String> {
    override fun convertToDatabaseColumn(attribute: CouponApplyPeriodType?): String {
        return attribute!!.codeValue
    }

    override fun convertToEntityAttribute(dbData: String?): CouponApplyPeriodType {
        return CouponApplyPeriodType.of(dbData!!)
    }
}

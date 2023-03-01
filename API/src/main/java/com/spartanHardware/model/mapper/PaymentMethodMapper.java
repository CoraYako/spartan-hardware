package com.spartanHardware.model.mapper;

import com.spartanHardware.model.dto.request.PaymentMethodRequestDto;
import com.spartanHardware.model.dto.response.PaymentMethodResponseDto;
import com.spartanHardware.model.entity.PaymentMethod;
import com.spartanHardware.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.spartanHardware.model.enums.PaymentType.*;
import static com.spartanHardware.model.enums.Provider.*;
import static java.lang.Boolean.FALSE;

@Component
public class PaymentMethodMapper {

    public PaymentMethod toPaymentMethod(PaymentMethodRequestDto dto, User loggedUser){
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setUser(loggedUser);
        paymentMethod.setAccountNumber(dto.getAccountNumber());
        paymentMethod.setExpiryDate(dto.getExpiryDate());
        paymentMethod.setDefaultMethod(dto.isDefaultMethod());
        paymentMethod.setDeleted(FALSE);

        if (dto.getPaymentType().equals(CREDIT_CARD.toString())) paymentMethod.setPaymentType(CREDIT_CARD);
        if (dto.getPaymentType().equals(DEBIT_CARD.toString())) paymentMethod.setPaymentType(DEBIT_CARD);

        if (dto.getProvider().equals(VISA.toString())) paymentMethod.setProvider(VISA);
        if (dto.getProvider().equals(MASTERCARD.toString())) paymentMethod.setProvider(MASTERCARD);

        return paymentMethod;
    }

    public PaymentMethodResponseDto toDto (PaymentMethod paymentMethod){
        return new PaymentMethodResponseDto(
                paymentMethod.getPaymentType().toString(),
                paymentMethod.getProvider().toString(),
                paymentMethod.getAccountNumber(),
                paymentMethod.getExpiryDate(),
                paymentMethod.isDefaultMethod()
        );
    }

    public List<PaymentMethodResponseDto> toDtoList (List<PaymentMethod> paymentMethodList){
        return paymentMethodList.stream().map(this::toDto).collect(Collectors.toList());
    }

}

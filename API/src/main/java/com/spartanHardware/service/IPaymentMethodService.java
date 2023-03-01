package com.spartanHardware.service;

import com.spartanHardware.model.dto.request.PaymentMethodRequestDto;
import com.spartanHardware.model.dto.response.PaymentMethodResponseDto;
import com.spartanHardware.model.entity.PaymentMethod;
import com.spartanHardware.model.entity.User;

import java.util.List;

public interface IPaymentMethodService {
    void createPaymentMethod(PaymentMethodRequestDto dto, User loggedUser);
    void deletePaymentMethod(Long id, User loggedUser);
    PaymentMethod getById(Long id);
}

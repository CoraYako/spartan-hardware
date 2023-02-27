package com.spartanHardware.service.impl;

import com.spartanHardware.exception.CustomException;
import com.spartanHardware.model.dto.request.PaymentMethodRequestDto;
import com.spartanHardware.model.dto.response.PaymentMethodResponseDto;
import com.spartanHardware.model.entity.PaymentMethod;
import com.spartanHardware.model.entity.User;
import com.spartanHardware.model.mapper.PaymentMethodMapper;
import com.spartanHardware.repository.PaymentMethodRepository;
import com.spartanHardware.service.IPaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PaymentMethodServiceImpl implements IPaymentMethodService {

    private final PaymentMethodRepository repository;
    private final PaymentMethodMapper mapper;
    private final MessageSource message;

    @Override
    public void createPaymentMethod(PaymentMethodRequestDto dto, User loggedUser) {
        repository.save(mapper.toPaymentMethod(dto, loggedUser));
    }

    @Override
    public void deletePaymentMethod(Long id, User loggedUser) {
        PaymentMethod paymentMethod = getById(id);
        if(!paymentMethod.getUser().getUsername().equals(loggedUser.getUsername())) throw new CustomException(
                message.getMessage("entity.noAccess", new String[] {"delete", "payment method"}, Locale.US),
                HttpStatus.FORBIDDEN,
                LocalDateTime.now()
        );
        repository.deleteById(id);
    }

    @Override
    public PaymentMethod getById(Long id) {
        return repository.findById(id).orElseThrow((() -> new CustomException(
                message.getMessage("entity.notFound", new String[] {"Payment Method", "id", id.toString()}, Locale.US),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        )));
    }
}

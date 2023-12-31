package dev.practice.order.interfaces.partner;

import dev.practice.order.application.partner.PartnerFacade;
import dev.practice.order.common.response.CommonResponse;
import dev.practice.order.domain.partner.PartnerCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/v1/partners")
@RestController
@RequiredArgsConstructor
public class PartnerApiController {

    private final PartnerFacade partnerFacade;

    private final PartnerDtoMapper partnerDtoMapper;

    @PostMapping
    public CommonResponse registerPartner(PartnerDto.RegisterRequest request) {
        // var command = request.toCommand();
        var command = partnerDtoMapper.of(request);

        var partnerInfo = partnerFacade.registerPartner(command);
        var response = new PartnerDto.RegisterResponse(partnerInfo);

        return CommonResponse.success(response);
    }

}
